package client.Presentation.AccountantUI.BillFill;


import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FillMoneyBill extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private final TableView table = new TableView();
    final Button SummitButton = new Button ("提交单据");
    final Button DraftButton = new Button("保存草稿");
    final Label notification = new Label ();
    final Label billNum = new Label ();
    final TextField account = new TextField("");
    final TextField consumer = new TextField("");
    final TextField money = new TextField("");
    final TextArea text = new TextArea ("");

    final Tooltip tooltipForAccount = new Tooltip("输入账户编号");
    final Tooltip tooltipForConsumer = new Tooltip("输入客户编号");
    final Tooltip tooltipForMoney = new Tooltip("金额（数字）");


    String address = " ";

    @Override public void start(Stage stage) {
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 750, 450);
        table.setEditable(true);

        Callback<TableColumn, TableCell> cellFactory
                = (TableColumn p) -> new EditingCell();
        account.setTooltip(tooltipForAccount);
        consumer.setTooltip(tooltipForConsumer);
        money.setTooltip(tooltipForMoney);

//        TableColumn AccountCol = new TableColumn("银行账户");
//        AccountCol.setMinWidth(100);
//        AccountCol.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        TableColumn MoneyCol = new TableColumn("转账金额");
//        MoneyCol.setMinWidth(100);
//        MoneyCol.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        TableColumn CommentCol = new TableColumn("备注");
//        CommentCol.setMinWidth(100);
//        CommentCol.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        table.getColumns().addAll(AccountCol,MoneyCol,CommentCol);



        final ComboBox TypeComboBox = new ComboBox();
        TypeComboBox.getItems().addAll(
                "收款单",
                "付款单"
        );
        TypeComboBox.setPromptText("收款单");
        TypeComboBox.setEditable(false);

        final ComboBox StaffComboBox = new ComboBox();
        StaffComboBox.getItems().addAll(
                "A员工",
                "B员工"
        );
        StaffComboBox.setValue("A员工");



        SummitButton.setOnAction((ActionEvent e) -> {
            if (    TypeComboBox.getValue() != null &&
                    !TypeComboBox.getValue().toString().isEmpty()&&
                    account.getText() != null &&
                    !account.getText().isEmpty()&&
                    consumer.getText() != null &&
                    !consumer.getText().isEmpty()&&
                    checkMoney(money.getText()))
            {
                notification.setText("The Bill was successfully sent"
                        + " to " + address);
                TypeComboBox.setValue(null);
                if (account.getText() != null &&
                        !account.getText().isEmpty()){
                    account.setText(null);
                }
                money.clear();
                text.clear();
            }
            else {
                notification.setText("You have not selected a recipient!");
            }
        });

        DraftButton.setOnAction((ActionEvent e) -> {
            if (TypeComboBox.getValue() != null &&
                    !TypeComboBox.getValue().toString().isEmpty()){
                notification.setText("Your message was successfully sent"
                        + " to " + address);
                TypeComboBox.setValue(null);
                if (account.getText() != null &&
                        !account.getText().isEmpty()){
                    account.setText(null);
                }
                money.clear();
                text.clear();
            }
            else {
                notification.setText("You have not selected a recipient!");
            }
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
        grid.add(new Label("账户:"), 0, 1);
        grid.add(account, 1, 1);
        grid.add(new Label("客户:"), 2, 1);
        grid.add(consumer, 3, 1);
        grid.add(new Label("金额:"), 0, 2);
        grid.add(money, 1, 2, 3, 1);
        grid.add(new Label("备注:"), 0, 3);
        grid.add(text, 1, 3, 4, 1);
        grid.add(DraftButton, 0, 4);
        grid.add(SummitButton, 2, 4);
        grid.add (notification, 0, 6, 3, 1);

        grid.add(table,0,7);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }


    public boolean checkMoney(String moneytext){
        boolean re = false;
        if(moneytext != null || moneytext.isEmpty()){
            notification.setText("Please enter the Money !");
        }
        else if (isNumeric(moneytext)){
            re = true;
        }
        return re;
    }

    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }





    class EditingCell extends TableCell {

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

//        @Override
//        public void updateItem(String item, boolean empty) {
//            super.updateItem(item, empty);
//
//            if (empty) {
//                setText(null);
//                setGraphic(null);
//            } else {
//                if (isEditing()) {
//                    if (textField != null) {
//                        textField.setText(getString());
//                    }
//                    setText(null);
//                    setGraphic(textField);
//                } else {
//                    setText(getString());
//                    setGraphic(null);
//                }
//            }
//        }

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