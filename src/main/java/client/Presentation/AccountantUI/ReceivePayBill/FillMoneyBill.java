package client.Presentation.AccountantUI.ReceivePayBill;


import client.BL.Accountant.FinancialPaybl.FinancialPayController;
import client.BL.Accountant.FinancialReceivebl.FinancialBill;
import client.BL.Accountant.FinancialReceivebl.FinancialReceiveController;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.Presentation.tools.NOgenerator;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * @discription: UI for accountant, 制定收付款单
 * @author: yotta
 */
public class FillMoneyBill{


//填写收付款单的填写项
    private final TableView<MoneyList> table = new TableView<>();
    private final ObservableList<MoneyList> data =
            FXCollections.observableArrayList(            );
    final Button SummitButton = new Button ("提交单据");
    final Button DraftButton = new Button("保存草稿");
    final Label notification = new Label ();
    final Label billNum = new Label ();
    final TextField consumer = new TextField("");
    final TextField money = new TextField("");
    final TextArea text = new TextArea ("");
    private final NOgenerator nogenerater = new NOgenerator();

    final Tooltip tooltipForAccount = new Tooltip("输入账户编号");
    final Tooltip tooltipForConsumer = new Tooltip("输入客户编号");
    final Tooltip tooltipForMoney = new Tooltip("金额（数字）");
    FinancialReceiveController receiveController = new FinancialReceiveController();
    FinancialPayController payController = new FinancialPayController();
    private Alert warning = new Alert(Alert.AlertType.WARNING,"");

    //start函数
    public void start(String ID,String staff) {
        Stage stage = new Stage();
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 700, 850);
        table.setEditable(true);

        billNum.setText(ID);
        Callback<TableColumn<MoneyList, String>,
                TableCell<MoneyList, String>> cellFactory
                = (TableColumn<MoneyList, String> p) -> new EditingCell();
        consumer.setTooltip(tooltipForConsumer);
        money.setTooltip(tooltipForMoney);


//转账列表
        TableColumn<MoneyList,String> AccountCol = new TableColumn<>("银行账户");
        AccountCol.setMinWidth(100);
        AccountCol.setCellFactory(cellFactory);
        AccountCol.setCellValueFactory(
                param -> param.getValue().account);

        TableColumn<MoneyList,String> MoneyCol = new TableColumn<>("转账金额");
        MoneyCol.setMinWidth(100);
        MoneyCol.setCellFactory(cellFactory);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);

        TableColumn<MoneyList,String> CommentCol = new TableColumn<>("备注");
        CommentCol.setMinWidth(100);
        CommentCol.setCellFactory(cellFactory);
        CommentCol.setCellValueFactory(
                param -> param.getValue().comment);

        table.setItems(data);
        table.getColumns().addAll(AccountCol,MoneyCol,CommentCol);

//增加条目
        final TextField addID = new TextField();
        addID.setPromptText("账户编号");
        addID.setMaxWidth(AccountCol.getPrefWidth());
        final TextField addMoney = new TextField();
        addMoney.setMaxWidth(MoneyCol.getPrefWidth());
        addMoney.setPromptText("转账金额");
        final TextField addComment = new TextField();
        addComment.setMaxWidth(MoneyCol.getPrefWidth());
        addComment.setPromptText("备注");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            String acc = addID.getText();
            String money = addMoney.getText();
            String comment = addComment.getText();
            MoneyList list = new MoneyList("123",billNum.getText(),acc,money,comment);
            data.add(list);
            addID.clear();
            addMoney.clear();
            addComment.clear();
        });

        HBox hb = new HBox();
        hb.getChildren().addAll(addID, addMoney, addComment, addButton);
        hb.setSpacing(3);

        VBox vb = new VBox();
        vb.getChildren().addAll(table,hb);
        vb.setSpacing(3);


        final ComboBox<String> TypeComboBox = new ComboBox<String>();
        TypeComboBox.getItems().addAll(
                "收款单", "付款单"
        );
        TypeComboBox.setValue("收款单");
        TypeComboBox.setEditable(false);

        final ComboBox<String> StaffComboBox = new ComboBox<String>();
        StaffComboBox.setValue(staff);
        StaffComboBox.setEditable(false);


//提交按钮
        final ComboBox<String> ConsumerTypeComboBox = new ComboBox<String>();
        ConsumerTypeComboBox.getItems().addAll(
                "供应商", "销售商"
        );
        ConsumerTypeComboBox.setValue("供应商");
        ConsumerTypeComboBox.setEditable(false);

        SummitButton.setOnAction((ActionEvent e) -> {
            if (check())
            {
                String billtype = TypeComboBox.getValue();
                String billID = billNum.getText();
                String operater = StaffComboBox.getValue();
                String consumerType =ConsumerTypeComboBox.getValue();
                String consumerID = consumer.getText();
                double sum = Double.parseDouble(money.getText());
                ArrayList<MoneyList> moneylist = new ArrayList<>();
                for (int i=0;i<data.size();i++) {
                    data.get(i).setlistNO(billID);
                    moneylist.add(data.get(i));
                }
//断言
                assert !consumer.getText().isEmpty();
                assert !money.getText().isEmpty();
                FinancialBill financialBill = new FinancialBill(billID,billtype,operater,consumerType,consumerID,moneylist,sum);
                try {
                    if(billtype.equals("收款单")){
                        ResultMessage resultMessage = receiveController.summit(financialBill);
                    }
                    else{
                        ResultMessage resultMessage = payController.summit(financialBill);
                    }
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }


                notification.setText("The Bill was successfully sent");
                money.clear();
                text.clear();
            }
        });

//保存草稿按钮
        DraftButton.setOnAction((ActionEvent e) -> {
            String billtype = TypeComboBox.getValue().toString();
            String billID = billNum.getText();
            String operater = StaffComboBox.getValue().toString();
            String consumerType =ConsumerTypeComboBox.getValue().toString();
            String consumerID = consumer.getText();
            double sum = Double.parseDouble(money.getText());
            ArrayList<MoneyList> moneylist = new ArrayList<MoneyList>();


//            data.clear();
            for (int i=0;i<data.size();i++) {
                String listID = "ZZLB-" + i;
                data.get(i).setKeyid(listID);
                data.get(i).setlistNO(billID);
                moneylist.add(data.get(i));
            }


            FinancialBill financialBill = new FinancialBill(billID,billtype,operater,consumerType,consumerID,moneylist,sum);
            try {
                if(billtype=="收款单"){
                    ResultMessage resultMessage = receiveController.saveAsDraft(financialBill);
                }
                else{
                    ResultMessage resultMessage = payController.saveAsDraft(financialBill);
                }
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }

            money.clear();
            text.clear();


        });
//版面设置

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("单据类型："), 0, 0);
        grid.add(TypeComboBox, 1, 0);
        grid.add(new Label("单据编号："), 2, 0);
        grid.add(billNum, 3, 0);
        grid.add(new Label("操作员："), 4, 0);
        grid.add(StaffComboBox, 5, 0);

        grid.add(new Label("客户类型："), 0, 1);
        grid.add(ConsumerTypeComboBox, 1, 1);
        grid.add(new Label("客户编号:"), 2, 1);
        grid.add(consumer, 3, 1);

        grid.add(new Label("转账列表:"), 0, 2);
        grid.add(vb, 1, 2, 3, 1);
        grid.add(new Label("总金额:"), 0, 3);
        grid.add(money, 1, 3, 4, 1);
        grid.add(DraftButton, 1, 4);
        grid.add(SummitButton, 2, 4);
        grid.add (notification, 0, 6, 3, 1);


        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

//格式检查

    public boolean check(){
        boolean re = true;
        String moneytext = money.getText();
        if (!isNumeric(moneytext)){
            re = false;
            warning.setContentText("请检查输入金额的格式 !");
            warning.showAndWait();
        }
        else if(moneytext == null || moneytext.isEmpty()){
            re = false;
            warning.setContentText("请输入总金额 !");
            warning.showAndWait();
        }
        else if (data.size()==0){
            re = false;
            warning.setContentText("请输入条目列表 !");
            warning.showAndWait();
        }
        else if(consumer.getText()==null||consumer.getText().isEmpty()){
            re = false;
            warning.setContentText("请输入客户编号 !");
            warning.showAndWait();
        }

        else{
            for(int i=0;i<data.size();i++){
                if(data.get(i).getMoney()==null||data.get(i).getMoney().isEmpty()){
                    re = false;
                    warning.setContentText("请输入转账金额 !");
                    warning.showAndWait();
                }
                else if(data.get(i).getAccount()==null||data.get(i).getAccount().isEmpty()){
                    re = false;
                    warning.setContentText("请输入转账账户 !");
                    warning.showAndWait();
                }
                else if(!isNumeric(data.get(i).getMoney())||data.get(i).getMoney().isEmpty()){
                    re = false;
                    warning.setContentText("请检查转账金额格式 !");
                    warning.showAndWait();
                }

            }



        }

        return re;
    }
//是否是数字
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }



//设置可编辑

    class EditingCell extends TableCell<MoneyList, String> {

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
            this.setTextFill(Color.BLACK);
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