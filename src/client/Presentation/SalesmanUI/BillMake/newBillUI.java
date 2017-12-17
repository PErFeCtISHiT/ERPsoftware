package client.Presentation.SalesmanUI.BillMake;

import client.BL.Saleman.GoodsOutListManageblservice.GoodsOutListManageController;
import client.BL.Saleman.SalemanConsumerManageblservice.Consumer;
import client.BL.Saleman.SalemanConsumerManageblservice.ConsumerManageController;
import client.BL.Saleman.SalemanSaleblservice.SelloutBill;
import client.BL.Saleman.SalemanSaleblservice.SelloutBillMakeController;
import client.BL.Saleman.SalemanStockinblservice.StockinBill;
import client.BL.Saleman.SalemanStockinblservice.StockinBillMakeController;
import client.RMI.link;
import client.Vo.buyinVO;
import client.Vo.consumerVO;
import client.Vo.selloutVO;
import client.Vo.goodsOutListVO;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import server.Po.consumerPO;
import server.Po.buyinPO;
import server.Po.selloutPO;

import javax.security.auth.callback.LanguageCallback;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by Leonarda on 2017/12/6.
 */
public class newBillUI extends Application{

    TreeItem<String> rootNode;
    TreeItem<String> consumerNode;
    TreeItem<String> buyinNode;
    TreeItem<String> selloutNode;

    TabPane tabs=new TabPane();

    ConsumerManageController consumerManageController=new ConsumerManageController();
    StockinBillMakeController stockinBillMakeController=new StockinBillMakeController();
    SelloutBillMakeController selloutBillMakeController=new SelloutBillMakeController();

    ArrayList<Consumer> consumerList=new ArrayList<>();

    ArrayList<StockinBill> stockinList=new ArrayList<>();

    ArrayList<SelloutBill> selloutBillList=new ArrayList<>();


    HBox hb=new HBox();
    Scene scene=new Scene(hb,1400,650);

    public static void main(String[] args){
        link.linktoServer();
        launch(args);
    }

    public newBillUI(){
        this.rootNode=new TreeItem<>("工作目录");
        this.consumerNode=new TreeItem<>("客户列表");
        this.buyinNode=new TreeItem<>("进货单列表");
        this.selloutNode=new TreeItem<>("销售单列表");
    }

    public void start(Stage stage) throws RemoteException {

        List<consumerVO> consumervolist=consumerManageController.show();
        for(consumerVO vo:consumervolist){
            Consumer a=consumerManageController.VOtoconsumer(vo);
            consumerList.add(a);
        }

        List<buyinVO> buyinvolist=stockinBillMakeController.show();
        for(buyinVO vo:buyinvolist){
            StockinBill a=stockinBillMakeController.votoBill(vo);
            stockinList.add(a);
        }

        List<selloutVO> selloutvoList=selloutBillMakeController.show();
        for(selloutVO vo:selloutvoList){
            SelloutBill a=selloutBillMakeController.VoTosellout(vo);
            selloutBillList.add(a);
        }

        MenuBar menuBar=new MenuBar();
        Menu menu1=new Menu("菜单");
        Menu menu2=new Menu("新建");
        Menu menu3=new Menu("帮助");
        menuBar.getMenus().addAll(menu1,menu2,menu3);



        consumerNode.setExpanded(true);
        for(Consumer consumer:consumerList){
            TreeItem<String> empleaf=new TreeItem<>(consumer.getConsumerID());
            consumerNode.getChildren().add(empleaf);
        }


        ContextMenu consumerMenu=new ContextMenu();
        MenuItem newMenuitem=new MenuItem("新建客户");
        consumerMenu.getItems().add(newMenuitem);

        stage.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent me)->{
            if(me.getButton()== MouseButton.SECONDARY||me.isControlDown()){
                consumerMenu.show(hb,me.getScreenX(),me.getScreenY());
            }
            else{
                consumerMenu.hide();
            }
        });

        newMenuitem.setOnAction((ActionEvent e)->{
            TreeItem<String> a=new TreeItem<>("consumer"+String.valueOf(consumerNode.getChildren().size()+1));
            consumerNode.getChildren().add(a);
            Tab newTab=new Tab();
            newTab.setText(a.getValue());
            newTab.setContent(newConsumerPane(a));
            tabs.getTabs().add(newTab);
        });



        buyinNode.setExpanded(true);
        TreeItem<String> in=new TreeItem<>("进货单");;
        TreeItem<String> cancel=new TreeItem<>("进货退货单");;
        for(StockinBill stockin:stockinList){
            TreeItem<String> empleaf=new TreeItem<>(stockin.getBuyinID());
            if((stockin.getBuyinKind()).equals("0")){
                in.getChildren().add(empleaf);
            }
            else{
                cancel.getChildren().add(empleaf);
            }
        }
        buyinNode.getChildren().addAll(in,cancel);


        selloutNode.setExpanded(true);
        TreeItem<String> selloutin=new TreeItem<String>("销售单");
        TreeItem<String> selloutCancel=new TreeItem<>("销售退货单");
        for(SelloutBill sellout:selloutBillList){
            TreeItem<String> empleaf=new TreeItem<>(sellout.getSelloutID());
            if(sellout.getSelloutID().equals("0")){
                selloutin.getChildren().add(empleaf);
            }
            else{
                selloutCancel.getChildren().add(empleaf);
            }
        }
        selloutNode.getChildren().addAll(selloutin,selloutCancel);



        rootNode.getChildren().addAll(consumerNode,buyinNode,selloutNode);


        stage.setTitle("进货销售人员");
        stage.setWidth(1400);
        stage.setHeight(650);
        scene.setFill(Color.WHITE);

        TreeView<String> treeView=new TreeView<>(rootNode);
        hb.getChildren().add(treeView);


        TreeView<String> contree=new TreeView<>(consumerNode);
        TreeView<String> buytree=new TreeView<>(buyinNode);
        TreeView<String> selltree=new TreeView<>(selloutNode);

        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
            if(newValue.isLeaf()){
                if(newValue.getParent().getValue().equals("进货单")||newValue.getParent().getValue().equals("进货退货单")){
                    Tab newTab=new Tab();
                    newTab.setText(newValue.getValue());
                    try {
                        newTab.setContent(BuyinBillPane(newValue.getValue()));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    tabs.getTabs().add(newTab);
                }
                else if(newValue.getParent().getValue().equals("销售单")||newValue.getParent().getValue().equals("销售退货单")){
                    Tab newTab=new Tab();
                    newTab.setText(newValue.getValue());
                    newTab.setContent(SelloutPane(newValue.getValue()));
                    tabs.getTabs().add(newTab);
                }
                else if(newValue.getParent().getValue().equals("客户列表")){
                    Tab newTab=new Tab();
                    newTab.setText(newValue.getValue());
                    try {
                        newTab.setContent(ConsumerPane(newValue.getValue()));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    tabs.getTabs().add(newTab);
                }else{
                }
            }
        });



        tabs.setTabMinHeight(30);
        tabs.setTabMinWidth(70);
        hb.getChildren().add(tabs);

        stage.setScene(scene);
        stage.show();
    }




    private Pane ConsumerPane(String name) throws RemoteException {
        List<consumerVO> list=consumerManageController.show();
        Consumer thisconsumer=new Consumer();
        for(consumerVO consumer:list){
            if(consumer.getKeyno().equals(name)){
                thisconsumer=consumerManageController.VOtoconsumer(consumer);
                break;
            }
        }

        consumerVO vo = consumerManageController.consumerToVO(thisconsumer);

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(12);
        gridPane.setMinHeight(450);
        gridPane.setMinWidth(1050);


        Label idlabel=new Label("客户ID：");
        Text id=new Text();
        id.setText(thisconsumer.getConsumerID());

        Label kindlabel=new Label("类型：");
        Text kind=new Text();
        if(Double.parseDouble(thisconsumer.getConsumerKind())==0){
            kind.setText("进货商");
        }else{
            kind.setText("销售商");
        }

        Label levelLabel=new Label("客户级别：");
        Text level=new Text();
        level.setText("VIP"+thisconsumer.getConsumerLevel());

        Label nameLabel=new Label("姓名：");
        Text coname=new Text();
        coname.setText(thisconsumer.getConsumerName());

        Label phoneLabel=new Label("联系方式：");
        Text phone=new Text();
        phone.setText(thisconsumer.getConsumerPhone());

        Label mailLabel=new Label("邮编：");
        Text mail=new Text();
        mail.setText(thisconsumer.getConsumerMail());

        Label emailLabel=new Label("电子邮箱：");
        Text email=new Text();
        email.setText(thisconsumer.getConsumerEmail());

        Label moneyLabel=new Label("应收额度：");
        Text receivemoney=new Text();
        receivemoney.setText(thisconsumer.getConsumerReveiveMoney());

        Label receiveLabel=new Label("应收：");
        Text receive=new Text();
        receive.setText(thisconsumer.getConsumerReceive());

        Label payLabel=new Label("应付：");
        Text pay=new Text();
        pay.setText(thisconsumer.getConsumerPay());

        Label accoutLabel=new Label("客户账号：");
        Text account=new Text();
        account.setText(thisconsumer.getAccout());

        Label salemanLabel=new Label("销售员：");
        Text saleman=new Text();
        saleman.setText(thisconsumer.getSalesman());

        gridPane.add(idlabel,0,0);
        gridPane.add(id,1,0);
        gridPane.add(kindlabel,0,1);
        gridPane.add(kind,1,1);
        gridPane.add(levelLabel,0,2);
        gridPane.add(level,1,2);
        gridPane.add(nameLabel,0,3);
        gridPane.add(coname,1,3);
        gridPane.add(phoneLabel,0,4);
        gridPane.add(phone,1,4);
        gridPane.add(mailLabel,0,5);
        gridPane.add(mail,1,5);
        gridPane.add(emailLabel,0,6);
        gridPane.add(email,1,6);
        gridPane.add(moneyLabel,0,7);
        gridPane.add(receivemoney,1,7);
        gridPane.add(receiveLabel,0,8);
        gridPane.add(receive,1,8);
        gridPane.add(payLabel,0,9);
        gridPane.add(pay,1,9);
        gridPane.add(accoutLabel,0,10);
        gridPane.add(account,1,10);
        gridPane.add(salemanLabel,0,11);
        gridPane.add(saleman,1,11);

        Button edit=new Button("编辑");
        Button delete=new Button("删除");

        gridPane.add(edit,3,12);
        gridPane.add(delete,4,12);

        edit.setOnAction((ActionEvent a1)->{
            String conkind=kind.getText();
            String conlevel=level.getText();
            String conname=coname.getText();
            String conphone=phone.getText();
            String conmail=mail.getText();
            String conemail=email.getText();
            String conreceivemoney=receivemoney.getText();
            String conaccount=account.getText();
            String consaleman=saleman.getText();

            gridPane.getChildren().removeAll(kind,level,coname,phone,mail,email,receivemoney,account,saleman,edit,delete);

            TextField kind1=new TextField();
            kind1.setPromptText(conkind);
            gridPane.add(kind1,1,1);

            TextField level1=new TextField();
            level1.setPromptText(conlevel);
            gridPane.add(level1,1,2);

            TextField name1=new TextField();
            name1.setPromptText(conname);
            gridPane.add(name1,1,3);

            TextField phone1=new TextField();
            phone1.setPromptText(conphone);
            gridPane.add(phone1,1,4);

            TextField mail1=new TextField();
            mail1.setPromptText(conmail);
            gridPane.add(mail1,1,5);

            TextField email1=new TextField();
            email1.setPromptText(conemail);
            gridPane.add(email1,1,6);

            TextField receivemoney1=new TextField();
            receivemoney1.setPromptText(conreceivemoney);
            gridPane.add(receivemoney1,1,7);

            TextField account1=new TextField();
            account1.setPromptText(conaccount);
            gridPane.add(account1,1,10);

            TextField salesman1=new TextField();
            salesman1.setPromptText(consaleman);
            gridPane.add(salesman1,1,11);

            Button confirm=new Button("确认修改");
            Button cancel=new Button("取消");

            gridPane.add(confirm,3,12);
            gridPane.add(cancel,4,12);

            confirm.setOnAction((ActionEvent e1)->{
                double finalKinds;
                if(kind1.getText().equals("进货商")){
                    finalKinds=0;
                }else{
                    finalKinds=1;
                }
                consumerVO newvo =new consumerVO(
                        id.getText(),
                        finalKinds,
                        Double.parseDouble(level1.getText()),
                        name1.getText(),
                        phone1.getText(),
                        mail1.getText(),
                        email1.getText(),
                        Double.parseDouble(receivemoney1.getText()),
                        Double.parseDouble(receive.getText()),
                        Double.parseDouble(pay.getText()),
                        salesman1.getText(),
                        account1.getText()
                        );
                try {
                    consumerManageController.modifyConsumer(newvo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                kind.setText(kind1.getText());
                level.setText(level1.getText());
                coname.setText(name1.getText());
                phone.setText(phone1.getText());
                mail.setText(mail1.getText());
                email.setText(email1.getText());
                receivemoney.setText(receivemoney1.getText());
                account.setText(account1.getText());
                saleman.setText(salesman1.getText());

                gridPane.getChildren().removeAll(kind1,level1,name1,phone1,mail1,email1,receivemoney1,account1,salesman1,confirm,cancel);

                gridPane.add(kind,1,1);

                gridPane.add(level,1,2);

                gridPane.add(coname,1,3);

                gridPane.add(phone,1,4);

                gridPane.add(mail,1,5);

                gridPane.add(email,1,6);

                gridPane.add(receivemoney,1,7);

                gridPane.add(account,1,10);

                gridPane.add(saleman,1,11);

                gridPane.add(edit,3,12);

                gridPane.add(delete,4,12);

            });

            cancel.setOnAction((ActionEvent e2)->{

                gridPane.getChildren().removeAll(kind1,level1,name1,phone1,mail1,email1,receivemoney1,account1,salesman1,confirm,cancel);

                gridPane.add(kind,1,1);

                gridPane.add(level,1,2);

                gridPane.add(coname,1,3);

                gridPane.add(phone,1,4);

                gridPane.add(mail,1,5);

                gridPane.add(email,1,6);

                gridPane.add(receivemoney,1,7);

                gridPane.add(account,1,10);

                gridPane.add(saleman,1,11);

                gridPane.add(edit,3,12);

                gridPane.add(delete,4,12);

            });
        });

        delete.setOnAction((ActionEvent a2)->{
            try {
                consumerManageController.deleteConsumer(vo);
                for(int i=0;i<consumerNode.getChildren().size();i++){
                    if(consumerNode.getChildren().get(i).getValue().equals(name)){
                        consumerNode.getChildren().remove(i);
                    }
                }
                for(int i=0;i<tabs.getTabs().size();i++){
                    if(tabs.getTabs().get(i).getText().equals(name)){
                        tabs.getTabs().remove(i);
                    }
                }

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        return gridPane;
    }





    private Pane newConsumerPane(TreeItem<String> a) {

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(12);
        gridPane.setMinHeight(450);
        gridPane.setMinWidth(1050);

        Label idlabel=new Label("客户ID：");
        Text id=new Text();
        id.setText(a.getValue());

        Label kindlabel=new Label("类型：");
        TextField kind=new TextField();

        Label levelLabel=new Label("客户级别：");
        TextField level=new TextField();

        Label nameLabel=new Label("姓名：");
        TextField coname=new TextField();

        Label phoneLabel=new Label("联系方式：");
        TextField phone=new TextField();

        Label mailLabel=new Label("邮编：");
        TextField mail=new TextField();

        Label emailLabel=new Label("电子邮箱：");
        TextField email=new TextField();

        Label moneyLabel=new Label("应收额度：");
        TextField receivemoney=new TextField();

        Label receiveLabel=new Label("应收：");
        Text receive=new Text();
        receive.setText("0");

        Label payLabel=new Label("应付：");
        Text pay=new Text();
        pay.setText("0");

        Label accoutLabel=new Label("客户账号：");
        TextField account=new TextField();

        Label salesmanLabel=new Label("销售员：");
        TextField salesman=new TextField();

        gridPane.add(idlabel,0,0);
        gridPane.add(id,1,0);
        gridPane.add(kindlabel,0,1);
        gridPane.add(kind,1,1);
        gridPane.add(levelLabel,0,2);
        gridPane.add(level,1,2);
        gridPane.add(nameLabel,0,3);
        gridPane.add(coname,1,3);
        gridPane.add(phoneLabel,0,4);
        gridPane.add(phone,1,4);
        gridPane.add(mailLabel,0,5);
        gridPane.add(mail,1,5);
        gridPane.add(emailLabel,0,6);
        gridPane.add(email,1,6);
        gridPane.add(moneyLabel,0,7);
        gridPane.add(receivemoney,1,7);
        gridPane.add(receiveLabel,0,8);
        gridPane.add(receive,1,8);
        gridPane.add(payLabel,0,9);
        gridPane.add(pay,1,9);
        gridPane.add(accoutLabel,0,10);
        gridPane.add(account,1,10);
        gridPane.add(salesmanLabel,0,11);
        gridPane.add(salesman,1,11);

        Button build=new Button("新建");
        Button cancel=new Button("取消");

        gridPane.add(build,3,12);
        gridPane.add(cancel,4,12);

        build.setOnAction((ActionEvent e)->{
            double kindnum;
            if(kind.getText().equals("进货商")){
                kindnum=0;
            }else{
                kindnum=1;
            }
            consumerVO vo=new consumerVO(
                    id.getText(),
                    kindnum,
                    Double.parseDouble(level.getText()),
                    coname.getText(),
                    phone.getText(),
                    mail.getText(),
                    email.getText(),
                    Double.parseDouble(receivemoney.getText()),
                    Double.parseDouble(receive.getText()),
                    Double.parseDouble(pay.getText()),
                    salesman.getText(),
                    account.getText()
            );

            try {
                consumerManageController.addConsumer(vo);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }

        });

        cancel.setOnAction((ActionEvent e)->{
            String name=a.getValue();
            for(int i=0;i<tabs.getTabs().size();i++){
                if(tabs.getTabs().get(i).getText().equals(name)){
                    tabs.getTabs().remove(i);
                }
            }
            for(int i=0;i<consumerNode.getChildren().size();i++){
                if(consumerNode.getChildren().get(i).getValue().equals(name)){
                    consumerNode.getChildren().remove(i);
                }
            }
        });

        return gridPane;
    }





    private Pane BuyinBillPane(String name) throws RemoteException {
        List<buyinVO> list=stockinBillMakeController.show();
        StockinBill thisstockinbill=new StockinBill();
        for(buyinVO vo:list){
            if(vo.getKeyno().equals(name)){
                thisstockinbill=stockinBillMakeController.votoBill(vo);
                break;
            }
        }

        buyinVO vo=stockinBillMakeController.billtovo(thisstockinbill);

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(12);
        gridPane.setMinHeight(450);
        gridPane.setMinWidth(1050);

        Label kindlabel=new Label("单据类型：");
        Text kind=new Text();
        if(Double.parseDouble(thisstockinbill.getBuyinKind())==0){
            kind.setText("进货单");
        }
        else{
            kind.setText("进货退货单");
        }

        gridPane.add(kindlabel,0,0);
        gridPane.add(kind,1,0);

        Label idLabel=new Label("单据ID：");
        Text id=new Text();
        id.setText(thisstockinbill.getBuyinID());

        gridPane.add(idLabel,0,1);
        gridPane.add(id,1,1);

        Label operaterLabel=new Label("操作员：");
        Text operater=new Text();
        operater.setText(thisstockinbill.getBuyinOperater());

        gridPane.add(operaterLabel,0,2);
        gridPane.add(operater,1,2);

        Label offerLabel=new Label("供应商：");
        Text offer=new Text();
        offer.setText(thisstockinbill.getBuyinOffer());

        gridPane.add(offerLabel,0,3);
        gridPane.add(offer,1,3);

        Label StorehouseLabel=new Label("仓库：");
        Text storehouse=new Text();
        storehouse.setText(thisstockinbill.getBuyinStoreHouse());

        gridPane.add(StorehouseLabel,0,4);
        gridPane.add(storehouse,1,4);

        Label GoodsList=new Label("出货商品清单");
        String outid=thisstockinbill.getBuyinGoodsList();

        GoodsOutListManageController goodsOutListManageController=new GoodsOutListManageController();
//        List<goodsOutListVO> outList=goodsOutListManageController.findbyNo(outid);
        ObservableList<goodsOutListVO> realOutList=FXCollections.observableArrayList(goodsOutListManageController.findbyNo(outid));
        TableView table=new TableView();
        table.setEditable(true);
        TableColumn<goodsOutListVO,String> keynoCol=new TableColumn<>("清单编号");
        keynoCol.setMinWidth(100);
        keynoCol.setCellValueFactory(new PropertyValueFactory<>("keyno"));
        TableColumn<goodsOutListVO,String> goodsnoCol=new TableColumn<>("商品编号");
        goodsnoCol.setMinWidth(100);
        goodsnoCol.setCellValueFactory(new PropertyValueFactory<>("goodsno"));
        TableColumn<goodsOutListVO,String> goodsnameCol=new TableColumn<>("名称");
        goodsnameCol.setMinWidth(100);
        goodsnameCol.setCellValueFactory(new PropertyValueFactory<>("goodsname"));
        TableColumn<goodsOutListVO,String> keymodelCol=new TableColumn<>("型号");
        keymodelCol.setMinWidth(100);
        keymodelCol.setCellValueFactory(new PropertyValueFactory<>("keymodel"));
        TableColumn<goodsOutListVO,Double> numCol=new TableColumn<>("数量");
        numCol.setMinWidth(100);
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        TableColumn<goodsOutListVO,Double> priceCol=new TableColumn<>("单价");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<goodsOutListVO,Double> sumCol=new TableColumn<>("总额");
        sumCol.setMinWidth(100);
        sumCol.setCellValueFactory(new PropertyValueFactory<>("sumall"));
        table.setItems(realOutList);
        table.getColumns().addAll(goodsnoCol,goodsnameCol,keymodelCol,numCol,priceCol,sumCol);

        gridPane.add(GoodsList,0,5);
        gridPane.add(table,0,6);

        Label tipLabel=new Label("备注");
        TextArea tip=new TextArea();
        tip.setWrapText(true);
        tip.setText(thisstockinbill.getBuyinTips());

        gridPane.add(tipLabel,0,7);
        gridPane.add(tip,0,8);

        Label sumLabel=new Label("总额");
        Text sum=new Text();
        sum.setText(thisstockinbill.getBuyinSum());

        gridPane.add(sumLabel,0,8);
        gridPane.add(sum,1,8);

        if(thisstockinbill.getBuyinisDraft().equals("1")){
            Button improve=new Button("修改");
            gridPane.add(improve,2,10);
            improve.setOnAction((ActionEvent e)->{
                String buyinOperater=operater.getText();
                String buyinOffer=offer.getText();
                String buyinWarehouse=storehouse.getText();

                gridPane.getChildren().removeAll(operater,offer,storehouse);

                TextField newOpe=new TextField();
                newOpe.setPromptText(buyinOperater);
                gridPane.add(newOpe,1,2);

                TextField newOff=new TextField();
                newOff.setPromptText(buyinOffer);
                gridPane.add(newOff,1,3);

                TextField newStore=new TextField();
                newStore.setPromptText(buyinWarehouse);
                gridPane.add(newStore,1,4);

                Callback<TableColumn<goodsOutListVO,String>,
                 TableCell<goodsOutListVO,String>> cellFactory
                 =(TableColumn<goodsOutListVO,String> p)->new EditingCell();



            });
        }

        return gridPane;
    }




    private Pane SelloutPane(String name){
        SelloutBill thisselloutBill=new SelloutBill();
        for(SelloutBill bill:selloutBillList){
            if(bill.getSelloutID().equals(name)){
                thisselloutBill=bill;
                break;
            }
        }

        selloutVO vo=selloutBillMakeController.selloutToVo(thisselloutBill);

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(12);
        gridPane.setMinHeight(450);
        gridPane.setMinWidth(1050);

        Label kindlabel=new Label("单据类型");
        Text kind=new Text();
        if(thisselloutBill.getSelloutkinds().equals("0")){
            kind.setText("销售单");
        }else{
            kind.setText("销售退货单");
        }

        Label idLabel=new Label("单据ID");
        Text id=new Text();
        id.setText(thisselloutBill.getSelloutID());


        return gridPane;
    }



    class EditingCell extends TableCell<goodsOutListVO,String>{
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

            setText(getItem());
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
}
