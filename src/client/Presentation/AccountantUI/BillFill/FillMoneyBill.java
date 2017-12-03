package client.Presentation.AccountantUI.BillFill;


import client.BL.Accountant.FinancialReceivebl.TransferList;
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

public class FillMoneyBill extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private final TableView<TransferList> table = new TableView<>();
    private final ObservableList<TransferList> data =
            FXCollections.observableArrayList(
                    new TransferList("A", "B", "C"),
                    new TransferList("Q", "W", "E")
            );
    final Button SummitButton = new Button ("提交单据");
    final Button DraftButton = new Button("保存草稿");
    final Label notification = new Label ();
    final Label billNum = new Label ();
    final TextField consumer = new TextField("");
    final TextField money = new TextField("");
    final TextArea text = new TextArea ("");

    final Tooltip tooltipForAccount = new Tooltip("输入账户编号");
    final Tooltip tooltipForConsumer = new Tooltip("输入客户编号");
    final Tooltip tooltipForMoney = new Tooltip("金额（数字）");


    @Override public void start(Stage stage) {
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 750, 450);
        table.setEditable(true);

        Callback<TableColumn<TransferList, String>,
                TableCell<TransferList, String>> cellFactory
                = (TableColumn<TransferList, String> p) -> new EditingCell();
        consumer.setTooltip(tooltipForConsumer);
        money.setTooltip(tooltipForMoney);





        TableColumn<TransferList,String> AccountCol = new TableColumn<>("银行账户");
        AccountCol.setMinWidth(100);
        AccountCol.setCellFactory(cellFactory);
        AccountCol.setCellValueFactory(
                param -> param.getValue().account);

        TableColumn<TransferList,String> MoneyCol = new TableColumn<>("转账金额");
        MoneyCol.setMinWidth(100);
        MoneyCol.setCellFactory(cellFactory);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);

        TableColumn<TransferList,String> CommentCol = new TableColumn<>("备注");
        CommentCol.setMinWidth(100);
        CommentCol.setCellFactory(cellFactory);
        CommentCol.setCellValueFactory(
                param -> param.getValue().comment);

        table.setItems(data);
        table.getColumns().addAll(AccountCol,MoneyCol,CommentCol);


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
            TransferList list = new TransferList(acc,money,comment);
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


        final ComboBox TypeComboBox = new ComboBox();
        TypeComboBox.getItems().addAll(
                "收款单", "付款单"
        );
        TypeComboBox.setPromptText("收款单");
        TypeComboBox.setEditable(false);

        final ComboBox StaffComboBox = new ComboBox();
        StaffComboBox.getItems().addAll(
                "A员工", "B员工"
        );
        StaffComboBox.setValue("A员工");


        final ComboBox ConsumerTypeComboBox = new ComboBox();
        ConsumerTypeComboBox.getItems().addAll(
                "供应商", "销售商"
        );
        ConsumerTypeComboBox.setPromptText("供应商");
        ConsumerTypeComboBox.setEditable(false);

        SummitButton.setOnAction((ActionEvent e) -> {
            if (    TypeComboBox.getValue() != null &&
                    !TypeComboBox.getValue().toString().isEmpty()&&
                    consumer.getText() != null &&
                    !consumer.getText().isEmpty()&&
                    checkMoney(money.getText()))
            {
                notification.setText("The Bill was successfully sent"
                        + " to " );
                TypeComboBox.setValue(null);
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
                        + " to " );
                TypeComboBox.setValue(null);
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

        grid.add(new Label("客户类型："), 0, 1);
        grid.add(ConsumerTypeComboBox, 1, 1);
        grid.add(new Label("客户:"), 2, 1);
        grid.add(consumer, 3, 1);


        grid.add(new Label("转账列表:"), 0, 2);
        grid.add(vb, 1, 2, 3, 1);
        grid.add(new Label("总金额:"), 0, 3);
        grid.add(money, 1, 3, 4, 1);
        grid.add(DraftButton, 0, 4);
        grid.add(SummitButton, 2, 4);
        grid.add (notification, 0, 6, 3, 1);


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





    class EditingCell extends TableCell<TransferList, String> {

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

}