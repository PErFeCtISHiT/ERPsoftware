package client.Presentation.AccountantUI.CashBill;


import client.BL.Accountant.FinancialCashbl.FinancialCash;
import client.BL.Accountant.FinancialCashbl.FinancialCashController;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.Presentation.NOgenerator.NOgenerator;
import client.RMI.link;
import javafx.application.Application;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import shared.ResultMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class FillCashBillUI {


    private final TableView<MoneyList> table = new TableView<>();
    private final ObservableList<MoneyList> data =
            FXCollections.observableArrayList();
    final Button SummitButton = new Button ("提交单据");
    final Button DraftButton = new Button("保存草稿");
    final Button OutputButton = new Button("导出单据");
    final Label notification = new Label ();
    final Label billNum = new Label ();
    final TextField account = new TextField("");
    final TextField money = new TextField("");
    final TextArea text = new TextArea ("");
    private final NOgenerator nogenerater = new NOgenerator();

    final Tooltip tooltipForAccount = new Tooltip("输入账户编号");
    final Tooltip tooltipForConsumer = new Tooltip("输入客户编号");
    final Tooltip tooltipForMoney = new Tooltip("金额（数字）");
    FinancialCashController cashController = new FinancialCashController();

    public void start(String ID) {
        Stage stage = new Stage();
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 700, 850);
        table.setEditable(true);

        Callback<TableColumn<MoneyList, String>,
                        TableCell<MoneyList, String>> cellFactory
                = (TableColumn<MoneyList, String> p) -> new EditingCell();
        account.setTooltip(tooltipForConsumer);
        money.setTooltip(tooltipForMoney);
        billNum.setText(ID);




        TableColumn<MoneyList,String> ItemCol = new TableColumn<>("条目名");
        ItemCol.setMinWidth(100);
        ItemCol.setCellFactory(cellFactory);
        ItemCol.setCellValueFactory(
                param -> param.getValue().account);

        TableColumn<MoneyList,String> MoneyCol = new TableColumn<>("金额");
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
        table.getColumns().addAll(ItemCol,MoneyCol,CommentCol);


        final TextField addID = new TextField();
        addID.setPromptText("条目名");
        addID.setMaxWidth(ItemCol.getPrefWidth());
        final TextField addMoney = new TextField();
        addMoney.setMaxWidth(MoneyCol.getPrefWidth());
        addMoney.setPromptText("金额");
        final TextField addComment = new TextField();
        addComment.setMaxWidth(MoneyCol.getPrefWidth());
        addComment.setPromptText("备注");

        final Button addButton = new Button("新建");
        addButton.setOnAction((ActionEvent e) -> {
            String acc = addID.getText();
            String money = addMoney.getText();
            String comment = addComment.getText();
            MoneyList list = new MoneyList("","",acc,money,comment);
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
                "现金费用单"
        );
        TypeComboBox.setValue("现金费用单");
        TypeComboBox.setEditable(false);

        final ComboBox<String> StaffComboBox = new ComboBox<String>();
        StaffComboBox.getItems().addAll(
                "A员工", "B员工"
        );
        StaffComboBox.setValue("A员工");


        SummitButton.setOnAction((ActionEvent e) -> {
            if (check())//checkMoney(money.getText())
            {
                System.out.println(TypeComboBox.getValue());

                String billtype = TypeComboBox.getValue();
                String billID = ID;
                String operater = StaffComboBox.getValue();
                String Account = account.getText();

                System.out.println(money.getText());
                double sum = Double.parseDouble(money.getText());
                System.out.println(sum);

//                data.clear();
                ArrayList<MoneyList> moneylist = new ArrayList<MoneyList>();
                for (int i=0;i<data.size();i++) {
                    data.get(i).setlistNO(billID);
                    moneylist.add(data.get(i));
                }

//                System.out.println("Step 1");
                FinancialCash financialCash = new FinancialCash(billID,billtype,operater,Account,moneylist,sum);
                try {
//                    System.out.println("Step 2");
                    if(billtype=="现金费用单"){
                        ResultMessage resultMessage = cashController.summit(financialCash);
                    }

                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }

//                System.out.println("Step 3");
                notification.setText("The Bill was successfully sent" + " to " );
                money.clear();
                text.clear();
            }
        });

        DraftButton.setOnAction((ActionEvent e) -> {

            System.out.println(TypeComboBox.getValue());

            String billtype = TypeComboBox.getValue();
            String billID = ID;
            String operater = StaffComboBox.getValue();
            String Account = account.getText();

            System.out.println(money.getText());
            double sum = Double.parseDouble(money.getText());
            System.out.println(sum);

//            data.clear();
            ArrayList<MoneyList> moneylist = new ArrayList<MoneyList>();
            for (int i=0;i<data.size();i++) {
                data.get(i).setlistNO(billID);
                moneylist.add(data.get(i));
            }

//                System.out.println("Step 1");
            FinancialCash financialCash = new FinancialCash(billID,billtype,operater,Account,moneylist,sum);
            try {
//                    System.out.println("Step 2");
                if(billtype=="现金费用单"){
                    ResultMessage resultMessage = cashController.saveAsDraft(financialCash);
                }

            } catch (RemoteException e1) {
                e1.printStackTrace();
            }

//                System.out.println("Step 3");
//                notification.setText("The Bill was successfully sent" + " to " );

                money.clear();
                text.clear();

        });

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

        grid.add(new Label("账户编号:"), 0, 1);
        grid.add(account, 1, 1);


        grid.add(new Label("条目列表:"), 0, 2);
        grid.add(vb, 1, 2, 3, 1);
        grid.add(new Label("总金额:"), 0, 3);
        grid.add(money, 1, 3, 4, 1);
        grid.add(DraftButton, 1, 4);
        grid.add(SummitButton, 2, 4);
        grid.add(OutputButton, 3, 4);
        grid.add (notification, 0, 6, 3, 1);


        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }


    public boolean check(){
        boolean re = true;
        String moneytext = money.getText();
        if(moneytext == null || moneytext.isEmpty()){
            re = false;
            notification.setText("请输入总金额 !");
        }
        if (!isNumeric(moneytext)){
            re = false;
            notification.setText("请检查输入金额的格式 !");
        }
        if(account.getText()==null){
            re = false;
            notification.setText("请输入客户类型 !");
        }

        for(int i=0;i<data.size();i++){
            if(data.get(i).getAccount()==null){
                re = false;
                notification.setText("请输入转账账户 !");
            }
            if(data.get(i).getMoney()==null){
                re = false;
                notification.setText("请输入转账金额 !");
            }
            if(!isNumeric(data.get(i).getMoney())){
                re = false;
                notification.setText("请检查转账金额格式 !");
            }
        }

        return re;
    }

    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
//            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }





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