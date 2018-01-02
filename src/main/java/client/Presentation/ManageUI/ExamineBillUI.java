package client.Presentation.ManageUI;

import client.BL.Manager.ManagerCheckProcessService.BillgottenController;
import client.BL.Manager.ManagerExamineBillService.ManagerExamineController;
import client.RMI.link;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import client.BL.Manager.ManagerCheckProcessService.Billgotten;
import javafx.util.Callback;
import server.Po.*;
import java.rmi.RemoteException;
import java.security.cert.TrustAnchor;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import shared.checkInTime;

public class ExamineBillUI  {

    private final TableView<Billgotten> table = new TableView<>();
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;
    TitledPane gridTitlePane = new TitledPane();
    final Button button1 = new Button("提交审批");
    final HBox fhb =new HBox();
    //所有单据共有属性
    final Label Type =new Label();
    final Label Id =new Label();
    final Label Operator =new Label();
    final Label IsHongChong =new Label();
    final Label state =new Label();
    //
    //buyingPO 属性
    final Label kind =new Label();
    final Label note =new Label();
    final Label ischeck =new Label();
    final Label provider =new Label();
    final Label base =new Label();
    final Label goodsoutlist =new Label();
    final Label sumall =new Label();

    //审核按钮
    final Button button4 = new Button("查询");

    //search 属性
    int searchcode = -1;
    String kehu ="";
    String yewuyuan ="";
    String cangku ="";
    String TimeBegin ="";
    String TimeEnd ="";


    private Double isDraft;


    ManagerExamineController controller = new ManagerExamineController();

    private final ObservableList<Billgotten> data =
            FXCollections.observableArrayList(

            );


    final HBox hb = new HBox();
    final HBox hb2 =new HBox();

    Callback<TableColumn<Billgotten,String>,
            TableCell<Billgotten,String>> cellFactory
            =(TableColumn<Billgotten,String> p)->new ExamineBillUI.EditingCell();



    public HBox start() {
        Locale.setDefault(Locale.CHINA);
        Scene scene = new Scene(new Group());





        table.setEditable(true);

        TableColumn<Billgotten, String> IdCol =
                new TableColumn<>("类型");
        TableColumn<Billgotten, String> TypeCol =
                new TableColumn<>("编号");
        TableColumn<Billgotten, String> NameCol =
                new TableColumn<>("操作员");
        TableColumn<Billgotten, String> AccountCol =
                new TableColumn<>("审批状态");
        TableColumn<Billgotten, String> StockCol =
                new TableColumn<>("是否红冲");
        TableColumn<Billgotten, String> BillDetailCol =
                new TableColumn<>("查看详细信息并审批");



        BillDetailCol.setCellFactory((col) -> {
            TableCell<Billgotten, String> cell = new TableCell<Billgotten, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        Button detailBtn = new Button("审批");
                        this.setGraphic(detailBtn);
                        detailBtn.setOnMouseClicked((me) -> {
                            String keyno = data.get(this.getIndex()).getId();
                            int  kind =data.get(this.getIndex()).getPrecisetype();
                            int  index =this.getIndex();
                            try {
                                switch (kind){
                                    case 3:{
                                        buyinPO buying =  (buyinPO)link.getRemoteHelper().getBuyinBill().findbyNO(3,keyno).get(0);
                                        detail3(keyno,index);

                                        break;
                                    }
                                    case 4:{
                                        selloutPO sellout =  (selloutPO) link.getRemoteHelper().getSelloutBill().findbyNO(4,keyno).get(0);
                                        detail4(keyno,index);
                                    }
                                    case 5:{
                                        moneyPO money =  (moneyPO) link.getRemoteHelper().getMoneyBill().findbyNO(5,keyno).get(0);
                                        detail5(keyno,index);

                                    }
                                    case 6:{
                                        giftPO gift =  (giftPO) link.getRemoteHelper().getBuyinBill().findbyNO(6,keyno).get(0);
                                        detail6(keyno,index);

                                    }
                                    case 7:{
                                        //need to test
                                        stockexceptionPO stockexception =  (stockexceptionPO) link.getRemoteHelper().getStockwarningBill().findbyNO(7,keyno).get(0);
                                        detail7(keyno,index);

                                    }
                                    case 9:{
                                        WarningPO warning =  (WarningPO) link.getRemoteHelper().getStockwarningBill().findbyNO(9,keyno).get(0);
                                        detail9(keyno,index);

                                    }



                                }





                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        });
                    }
                }

            };
            return cell;
        });

        IdCol.setMinWidth(100);
        IdCol.setCellValueFactory(
                param -> param.getValue().Type);

        TypeCol.setMinWidth(100);
        TypeCol.setCellValueFactory(
                param -> param.getValue().Id);

        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().Operator);

        AccountCol.setMinWidth(100);
        AccountCol.setCellValueFactory(
                param -> param.getValue().State);

        StockCol.setMinWidth(100);
        StockCol.setCellValueFactory(
                param -> param.getValue().IsHongChong);

        try {
            List<selloutPO> list2 =controller.showselloutPO();
            for (int i=0;i<list2.size();i++){
                if(list2.get(i).getIscheck()==0)
                data.add(new Billgotten(4, "销售类单据",list2.get(i).getKeyno(),list2.get(i).getOper(),getState(list2.get(i).getIscheck()),getIsRed(list2.get(i).getIsred())));
            }
            List<buyinPO> list =controller.showbyingPO();
            for (int i=0;i<list.size();i++){
                if(list.get(i).getIscheck()==0)
                    data.add(new Billgotten(3, "进货类单据",list.get(i).getKeyno(),list.get(i).getOper(),getState(list.get(i).getIscheck()),getIsRed(list.get(i).getIsred())));
            }
            List<moneyPO> list3 =controller.showmoneyPO();
            for (int i=0;i<list3.size();i++){
                if(list3.get(i).getIscheck()==0)
                    data.add(new Billgotten(5, "财务类单据",list3.get(i).getKeyno(),list3.get(i).getOper(),getState(list3.get(i).getIscheck()),getIsRed(list3.get(i).getIsred())));
            }
            List<stockexceptionPO> list4 =controller.showstockexceptionPO();
            for (int i=0;i<list4.size();i++){
                if(list4.get(i).getIscheck()==0)
                data.add(new Billgotten(7, "库存类单据",list4.get(i).getKeyno(),list4.get(i).getOper(),getState(list4.get(i).getIscheck()),getIsRed(list4.get(i).getIsred())));
            }
            List<WarningPO> list5 =controller.showwarningPO();
            for (int i=0;i<list5.size();i++){
                if(list5.get(i).getIscheck()==0)
                data.add(new Billgotten(9, "库存类单据",list5.get(i).getKeyno(),list5.get(i).getOper(),getState(list5.get(i).getIscheck()),getIsRed(list5.get(i).getIsred())));
            }
            List<giftPO> list6 =controller.showgiftPO();
            for (int i=0;i<list6.size();i++){
                if(list6.get(i).getIscheck()==0)
                data.add(new Billgotten(6, "库存类单据",list6.get(i).getKeyno(),list6.get(i).getOper(),getState(list6.get(i).getIscheck()),getIsRed(list6.get(i).getIsred())));
            }


        } catch (RemoteException e) {
            e.printStackTrace();
        }

        table.setItems(data);
        table.getColumns().addAll(IdCol,TypeCol,NameCol,AccountCol,StockCol,BillDetailCol);


        gridTitlePane.setText("详细信息");



        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");

        checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(
                                        checkInDatePicker.getValue().plusDays(1))

                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label checkInlabel = new Label("开始时间");
        gridPane.add(checkInlabel, 0, 0);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(checkInDatePicker, 0, 1);
        Label checkOutlabel = new Label("结束时间");
        gridPane.add(checkOutlabel, 1, 0);
        GridPane.setHalignment(checkOutlabel, HPos.LEFT);
        gridPane.add(checkOutDatePicker, 1, 1);
        vbox.getChildren().add(gridPane);
//;lt

        button1.setOnAction((ActionEvent e) -> {

        });









        final TextField  client= new TextField();
        client.setPromptText("客户");
        client.setVisible(false);
        client.setOnAction((ActionEvent e) -> {
            kehu =client.getText();
            //System.out.println(kehu);
            if((!yewuyuan.equals(""))&&(!cangku.equals(""))&&(!kehu.equals(""))&&(!TimeBegin.equals(""))&&(!TimeEnd.equals(""))){
                kehu =client.getText();
                button4.setDisable(false);
            }

        });
        final TextField salesman = new TextField();
        salesman.setPromptText("业务员");
        yewuyuan =salesman.getText();
        salesman.setOnAction((ActionEvent e) -> {
            yewuyuan =salesman.getText();
            if((!yewuyuan.equals(""))&&(!cangku.equals(""))&&(!kehu.equals(""))&&(!TimeBegin.equals(""))&&(!TimeEnd.equals(""))){
                button4.setDisable(false);
            }

        });
        final TextField storehouse = new TextField();
        storehouse.setPromptText("仓库");
        storehouse.setVisible(false);
        cangku =storehouse.getText();
        storehouse.setOnAction((ActionEvent e) -> {
            cangku =storehouse.getText();
            if((!yewuyuan.equals(""))&&(!cangku.equals(""))&&(!kehu.equals(""))&&(!TimeBegin.equals(""))&&(!TimeEnd.equals(""))){
                button4.setDisable(false);
            }

        });
        checkInDatePicker.setOnAction((ActionEvent e) -> {
            TimeBegin =checkInDatePicker.getValue().toString();
            TimeBegin =TimeBegin.substring(0,4)+TimeBegin.substring(5,7)+TimeBegin.substring(8,10);
            System.out.println(TimeBegin);
            if((!yewuyuan.equals(""))&&(!cangku.equals(""))&&(!kehu.equals(""))&&(!TimeBegin.equals(""))&&(!TimeEnd.equals(""))){
                button4.setDisable(false);
            }


        });
        checkOutDatePicker.setOnAction((ActionEvent e) -> {
            TimeEnd =checkOutDatePicker.getValue().toString();
            TimeEnd =TimeEnd.substring(0,4)+TimeEnd.substring(5,7)+TimeEnd.substring(8,10);
            if((!yewuyuan.equals(""))&&(!cangku.equals(""))&&(!kehu.equals(""))&&(!TimeBegin.equals(""))&&(!TimeEnd.equals(""))){
                button4.setDisable(false);
            }


        });
        final ChoiceBox BillType= new ChoiceBox(FXCollections.observableArrayList("进货/进货退货单","销售/销售退货单","收款单/付款单","库存赠送单","库存报溢/损单","库存报警单"));
        BillType.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
            searchcode =newv.intValue();
            if(searchcode==0||searchcode==1){
                storehouse.setVisible(true);
            }else{
                storehouse.setVisible(false);
            }
            if(searchcode==2||searchcode==3){
                client.setVisible(true);
            }else{
                client.setVisible(false);
            }

        });



        button4.setOnAction((ActionEvent e) -> {
            try {
                data.clear();

                /**
                 *  根据searchco选用方法 返回相应的列表
                 *  再根据其他四个条件一一进行筛选
                 *  0,1含有仓库
                 *  2,3含有客户
                 *  其他均只可以查找operator
                 */
                switch (searchcode) {
                    case 1:
                        List<selloutPO> list2 = controller.showselloutPO();
                        if(list2.size()==0){break;}
                        for (int i = 0; i < list2.size(); i++) {
                            String key1 =list2.get(i).getKeyno();
                            String opertor1 =list2.get(i).getOper();
                            String base1 =list2.get(i).getBase();

                            Boolean IsInTime =checkInTime.checkIsInTime(TimeBegin,TimeEnd,key1);
                            if(opertor1.equals(kehu)&&base1.equals(cangku)&&IsInTime)
                                data.add(new Billgotten(4, "销售类单据", list2.get(i).getKeyno(), list2.get(i).getOper(), getState(list2.get(i).getIscheck()), getIsRed(list2.get(i).getIsred())));
                        }
                        break;
                    case 0:
                        List<buyinPO> list = controller.showbyingPO();
                        if(list.size()==0){break;}
                        for (int i = 0; i < list.size(); i++) {
                            String key1 =list.get(i).getKeyno();
                            String opertor1 =list.get(i).getOper();
                            String base1 =list.get(i).getBase();

                            Boolean IsInTime =checkInTime.checkIsInTime(TimeBegin,TimeEnd,key1);
                            if(opertor1.equals(kehu)&&base1.equals(cangku)&&IsInTime)
                                data.add(new Billgotten(3, "进货类单据", list.get(i).getKeyno(), list.get(i).getOper(), getState(list.get(i).getIscheck()), getIsRed(list.get(i).getIsred())));
                        }
                        break;
                    case 2:
                        List<moneyPO> list3 = controller.showmoneyPO();

                        for (int i = 0; i < list3.size(); i++) {
                            String key1 =list3.get(i).getKeyno();
                            String opertor1 =list3.get(i).getOper();
                            String consumer =list3.get(i).getConsumer();

                            Boolean IsInTime =checkInTime.checkIsInTime(TimeBegin,TimeEnd,key1);
                            if(opertor1.equals(opertor1)&&consumer.equals(kehu)&&IsInTime)
                                data.add(new Billgotten(5, "财务类单据", list3.get(i).getKeyno(), list3.get(i).getOper(), getState(list3.get(i).getIscheck()), getIsRed(list3.get(i).getIsred())));
                        }
                        break;
                    case 4:
                        List<stockexceptionPO> list4 = controller.showstockexceptionPO();
                        for (int i = 0; i < list4.size(); i++) {
                            String key1 =list4.get(i).getKeyno();
                            String opertor1 =list4.get(i).getOper();

                            Boolean IsInTime =checkInTime.checkIsInTime(TimeBegin,TimeEnd,key1);
                            if(opertor1.equals(opertor1)&&IsInTime)
                                data.add(new Billgotten(7, "库存类单据", list4.get(i).getKeyno(), list4.get(i).getOper(), getState(list4.get(i).getIscheck()), getIsRed(list4.get(i).getIsred())));
                        }
                        break;
                    case 5:
                        List<WarningPO> list5 = controller.showwarningPO();
                        for (int i = 0; i < list5.size(); i++) {
                            String key1 =list5.get(i).getKeyno();
                            String opertor1 =list5.get(i).getOper();

                            Boolean IsInTime =checkInTime.checkIsInTime(TimeBegin,TimeEnd,key1);
                            if(opertor1.equals(opertor1)&&IsInTime)
                                data.add(new Billgotten(9, "库存类单据", list5.get(i).getKeyno(), list5.get(i).getOper(), getState(list5.get(i).getIscheck()), getIsRed(list5.get(i).getIsred())));
                        }
                    case 3:
                        List<giftPO> list6 = controller.showgiftPO();
                        for (int i = 0; i < list6.size(); i++) {
                            String key1 =list6.get(i).getKeyno();
                            String opertor1 =list6.get(i).getOper();
                            String consumer =list6.get(i).getComsumername();

                            Boolean IsInTime =checkInTime.checkIsInTime(TimeBegin,TimeEnd,key1);
                            if(opertor1.equals(opertor1)&&consumer.equals(kehu)&&IsInTime)
                                data.add(new Billgotten(6, "库存类单据", list6.get(i).getKeyno(), list6.get(i).getOper(), getState(list6.get(i).getIscheck()), getIsRed(list6.get(i).getIsred())));
                        }
                        break;

                }
            } catch(RemoteException e1){
                e1.printStackTrace();
            }



        });

        hb.getChildren().addAll(button1,button4);
        hb.setSpacing(3);

        hb2.getChildren().addAll(vbox);

        final VBox vbox1 = new VBox();
        vbox1.setSpacing(5);
        vbox1.setPadding(new Insets(10, 0, 0, 10));
        vbox1.getChildren().addAll( table, hb,BillType,client,salesman,storehouse);
        hb2.getChildren().addAll(vbox1,gridTitlePane);
        return hb2;
    }


    class EditingCell extends TableCell<Billgotten,String>{
        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(
                    (ObservableValue<? extends Boolean> arg0,
                     Boolean arg1, Boolean arg2) -> {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                    });

        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }


    }

    public static String getState(double number){
        if(number == 0) {
            return "未审批";
        }
        else if(number ==1){
            return "已审批";
        }
        else{
            return "草稿";
        }
    }
    public static String getIsRed(double isred){

        if(isred ==0){
            return"非红冲账单";
        }
        else{
            return"红冲账单";
        }
    }
    public void detail3(String keyno,int index) {
        GridPane grid3 = new GridPane();
        grid3.setVgap(4);
        grid3.setHgap(10);
        System.out.println("get");
        try {
            /**
             * 进货/退货单(buyinPO/antibuyin)：供应商，仓库，入库商品列表（存储清单编号，用逗号隔开），总额合计。
             */
            System.out.println(keyno);
            buyinPO po = (buyinPO)link.getRemoteHelper().getMoneyBill().findbyNO(3,keyno).get(0);
            grid3.setPadding(new Insets(5, 5, 5, 5));
            grid3.add(new Label("单据类型："), 0, 0);
            if(po.getKind()==0){Type.setText("进货单");}else{Type.setText("退货单");}
            grid3.add(Type, 1, 0);
            grid3.add(new Label("单据编号："), 0, 1);
            Id.setText(po.getKeyno());
            grid3.add(Id, 1, 1);
            grid3.add(new Label("操作员："), 0, 2);
            Operator.setText(po.getOper());
            grid3.add(Operator, 1, 2);
            grid3.add(new Label("审批状态:"), 0, 3);
            state.setText(getState(po.getIscheck()));
            grid3.add(state, 1, 3);
            grid3.add(new Label("是否红冲:"), 0, 4);
            IsHongChong.setText(getIsRed(po.getIsred()));
            grid3.add(IsHongChong, 1, 4);
            grid3.add(new Label("总金额:"), 0, 5);
            sumall.setText(po.getSumall().toString());
            grid3.add(sumall,1,5);
            grid3.add(new Label("供应商"),0,6);
            grid3.add(new Label(po.getProvider()),1,6);
            grid3.add(new Label("仓库"),0,7);
            grid3.add(new Label(po.getBase()),1,7);
            grid3.add(new Label("入库商品列表"),0,8);
            grid3.add(new Label(po.getGoodsoutlist()),1,8);
            button1.setOnAction((ActionEvent e)->{
                po.setIscheck(1.0);
                data.remove(index);
                try {
                    link.getRemoteHelper().getBuyinBill().modifyObject(po,3);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            });

            gridTitlePane.setContent(grid3);

        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    /**
     * 销售/退货单（selloutPO/antiSellout）：单据客户（仅显示销售商），业务员（和这个客户打交道的公司员工，可以设置一个客户的默认业务员），仓库，出货商品清单（存储清单编号，用逗号隔开），折让前总额，折让，使用代金卷金额，折让后总额
     * @param keyno
     */
    public void detail4(String keyno,int index) {
        GridPane grid3 = new GridPane();
        grid3.setVgap(4);
        grid3.setHgap(10);
        try {

            selloutPO po = (selloutPO) link.getRemoteHelper().getMoneyBill().findbyNO(4,keyno).get(0);
            grid3.setPadding(new Insets(5, 5, 5, 5));
            grid3.add(new Label("单据类型："), 0, 0);
            if(po.getKind()==0){Type.setText("销售单");}else{Type.setText("销售退货单");}
            grid3.add(Type, 1, 0);
            grid3.add(new Label("单据编号："), 0, 1);
            Id.setText(po.getKeyno());
            grid3.add(Id, 1, 1);
            grid3.add(new Label("操作员："), 0, 2);
            Operator.setText(po.getOper());
            grid3.add(Operator, 1, 2);
            grid3.add(new Label("审批状态:"), 0, 3);
            state.setText(getState(po.getIscheck()));
            grid3.add(state, 1, 3);
            grid3.add(new Label("是否红冲:"), 0, 4);
            IsHongChong.setText(getIsRed(po.getIsred()));
            grid3.add(IsHongChong, 1, 4);
            grid3.add(new Label("单据客户"),0,5);
            grid3.add(new Label(po.getConsumer()),1,5);
            grid3.add(new Label("业务员"),0,6);
            grid3.add(new Label(po.getServer()),1,6);
            grid3.add(new Label("仓库"),0,7);
            grid3.add(new Label(po.getBase()),1,7);
            grid3.add(new Label("商品编号"),0,8);
            grid3.add(new Label(po.getGoodsoutlist()),1,8);
            grid3.add(new Label("折让前总额"),0,9);
            grid3.add(new Label(po.getSumall().toString()),1,9);
            grid3.add(new Label("折让"),0,10);
            grid3.add(new Label(po.getCut().toString()),1,10);
            grid3.add(new Label("代金券金额"),0,11);
            grid3.add(new Label(po.getVoucher().toString()),1,11);
            grid3.add(new Label("折让后总金额"),0,12);
            grid3.add(new Label(po.getFinalsum().toString()),1,12);

            gridTitlePane.setContent(grid3);
            button1.setOnAction((ActionEvent e)->{
                po.setIscheck(1.0);
                try {
                    link.getRemoteHelper().getSelloutBill().modifyObject(po,4);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }

                data.remove(index);
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     收/付款单（moneyPO/pay）：客户（同时包含供应商和销售商），银行账户，清单名称（moneylist），总额汇总。
     * @param keyno
     */
    public void detail5(String keyno,int index) {
        GridPane grid3 = new GridPane();
        grid3.setVgap(4);
        grid3.setHgap(10);
        try {

            moneyPO po = (moneyPO) link.getRemoteHelper().getMoneyBill().findbyNO(5,keyno).get(0);
            grid3.setPadding(new Insets(5, 5, 5, 5));
            grid3.add(new Label("单据类型："), 0, 0);
            if(po.getKind()==0){Type.setText("收款单");}else{Type.setText("付款单");}
            grid3.add(Type, 1, 0);
            grid3.add(new Label("单据编号："), 0, 1);
            Id.setText(po.getKeyno());
            grid3.add(Id, 1, 1);
            grid3.add(new Label("操作员："), 0, 2);
            Operator.setText(po.getOper());
            grid3.add(Operator, 1, 2);
            grid3.add(new Label("审批状态:"), 0, 3);
            state.setText(getState(po.getIscheck()));
            grid3.add(state, 1, 3);
            grid3.add(new Label("是否红冲:"), 0, 4);
            IsHongChong.setText(getIsRed(po.getIsred()));
            grid3.add(IsHongChong, 1, 4);
            grid3.add(new Label("总金额:"), 0, 5);
            sumall.setText(po.getSumall().toString());
            grid3.add(sumall,1,5);
            grid3.add(new Label("供应商:"),0,6);
            grid3.add(new Label(po.getConsumer()),1,6);
            grid3.add(new Label("银行账户"),0,7);
            grid3.add(new Label(po.getAccoun()),1,7);
            grid3.add(new Label("清单名称"),0,8);
            grid3.add(new Label(po.getMoneyList()),1,8);
            grid3.add(new Label("总额汇总"),0,9);
            grid3.add(new Label(po.getSumall().toString()),1,9);



            gridTitlePane.setContent(grid3);
            button1.setOnAction((ActionEvent e)->{
                po.setIscheck(1.0);
                try {
                    link.getRemoteHelper().getMoneyBill().modifyObject(po,5);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                data.remove(index);
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 库存赠送单（giftPO）：商品编号，商品名称，客户编号，客户名称，数量。
     * @param keyno
     */
    public void detail6(String keyno,int index) {
        GridPane grid3 = new GridPane();
        grid3.setVgap(4);
        grid3.setHgap(10);
        try {

            giftPO po = (giftPO) link.getRemoteHelper().getMoneyBill().findbyNO(6,keyno).get(0);
            grid3.setPadding(new Insets(5, 5, 5, 5));
            grid3.add(new Label("单据类型："), 0, 0);
            if(po.getKind()==0){Type.setText("库存赠送单");}else{Type.setText("库存赠送单");}
            grid3.add(Type, 1, 0);
            grid3.add(new Label("单据编号："), 0, 1);
            Id.setText(po.getKeyno());
            grid3.add(Id, 1, 1);
            grid3.add(new Label("操作员："), 0, 2);
            Operator.setText(po.getOper());
            grid3.add(Operator, 1, 2);
            grid3.add(new Label("审批状态:"), 0, 3);
            state.setText(getState(po.getIscheck()));
            grid3.add(state, 1, 3);
            grid3.add(new Label("是否红冲:"), 0, 4);
            IsHongChong.setText(getIsRed(po.getIsred()));
            grid3.add(IsHongChong, 1, 4);
            grid3.add(new Label("商品编号："),0,5);
            grid3.add(new Label(po.getGoodsno()),1,5);
            grid3.add(new Label("商品名称"),0,6);
            grid3.add(new Label(po.getGoodsname()),1,6);
            grid3.add(new Label("客户编号"),0,7);
            grid3.add(new Label(po.getConsumerno()),1,7);
            grid3.add(new Label("客户名称"),0,8);
            grid3.add(new Label(po.getGoodsname()),1,8);
            grid3.add(new Label("数量"),0,9);
            TextField numforit = new TextField(po.getNum().toString());
            numforit.setEditable(true);
            grid3.add(numforit,1,9);
            gridTitlePane.setContent(grid3);
            button1.setOnAction((ActionEvent e)->{
                po.setNum(Double.parseDouble(numforit.getText()));
                po.setIscheck(1.0); try {
                    link.getRemoteHelper().getMoneyBill().modifyObject(po,6);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                data.remove(index);
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 库存报溢/损单（stockexceptionPO/damage）：商品编号，商品名称，库房数量，系统数量
     * @param keyno
     */
    public void detail7(String keyno,int index) {
        GridPane grid3 = new GridPane();
        grid3.setVgap(4);
        grid3.setHgap(10);
        try {

            stockexceptionPO po = (stockexceptionPO) link.getRemoteHelper().getMoneyBill().findbyNO(7,keyno).get(0);
            grid3.setPadding(new Insets(5, 5, 5, 5));
            grid3.add(new Label("单据类型："), 0, 0);
            if(po.getKind()==0){Type.setText("库存报溢单");}else{Type.setText("库存报损单");}
            grid3.add(Type, 1, 0);
            grid3.add(new Label("单据编号："), 0, 1);
            Id.setText(po.getKeyno());
            grid3.add(Id, 1, 1);
            grid3.add(new Label("操作员："), 0, 2);
            Operator.setText(po.getOper());
            grid3.add(Operator, 1, 2);
            grid3.add(new Label("审批状态:"), 0, 3);
            state.setText(getState(po.getIscheck()));
            grid3.add(state, 1, 3);
            grid3.add(new Label("是否红冲:"), 0, 4);
            IsHongChong.setText(getIsRed(po.getIsred()));
            grid3.add(IsHongChong, 1, 4);
            grid3.add(new Label("商品编号"),0,5);
            grid3.add(new Label(po.getGoodsno()),1,5);
            grid3.add(new Label("商品名称"),0,6);
            grid3.add(new Label(po.getGoodsname()),1,6);
            grid3.add(new Label("库房数量"),0,7);
            grid3.add(new Label(po.getNuminbase().toString()),1,7);
            grid3.add(new Label("系统数量"),0,8);
            grid3.add(new Label(po.getNuminsys().toString()),1,8);
            gridTitlePane.setContent(grid3);
            button1.setOnAction((ActionEvent e)->{
                po.setIscheck(1.0);
                try {
                    link.getRemoteHelper().getStockOverflowBill().modifyObject(po,7);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                data.remove(index);
            });


        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 库存报警单（warningPO）：商品编号，商品名称，库存数量，警戒值。
     * @param keyno
     */
    public void detail9(String keyno,int index) {
        GridPane grid3 = new GridPane();
        grid3.setVgap(4);
        grid3.setHgap(10);
        try {

            WarningPO po = (WarningPO) link.getRemoteHelper().getMoneyBill().findbyNO(9,keyno).get(0);
            grid3.setPadding(new Insets(5, 5, 5, 5));
            grid3.add(new Label("单据类型："), 0, 0);
            if(po.getKind()==0){Type.setText("库存报警单");}else{Type.setText("库存报警单");}
            grid3.add(Type, 1, 0);
            grid3.add(new Label("单据编号："), 0, 1);
            Id.setText(po.getKeyno());
            grid3.add(Id, 1, 1);
            grid3.add(new Label("操作员："), 0, 2);
            Operator.setText(po.getOper());
            grid3.add(Operator, 1, 2);
            grid3.add(new Label("审批状态:"), 0, 3);
            state.setText(getState(po.getIscheck()));
            grid3.add(state, 1, 3);
            grid3.add(new Label("是否红冲:"), 0, 4);
            IsHongChong.setText(getIsRed(po.getIsred()));
            grid3.add(IsHongChong, 1, 4);
            grid3.add(new Label("商品编号"),0,5);
            grid3.add(new Label(po.getGoodsno()),1,5);
            grid3.add(new Label("商品名称"),0,6);
            grid3.add(new Label(po.getGoodsname()),1,6);
            grid3.add(new Label("库存数量"),0,7);
            grid3.add(new Label(po.getNum().toString()),1,7);
            grid3.add(new Label("警戒值"),0,8);
            TextField warning =new TextField(po.getWarningnum().toString());
            warning.setEditable(true);
            grid3.add(warning,1,8);
            gridTitlePane.setContent(grid3);
            button1.setOnAction((ActionEvent e)->{
                po.setWarningnum(Double.parseDouble(warning.getText()));
                po.setIscheck(1.0);
                try {
                    link.getRemoteHelper().getStockwarningBill().modifyObject(po,9);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                data.remove(index);

            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
