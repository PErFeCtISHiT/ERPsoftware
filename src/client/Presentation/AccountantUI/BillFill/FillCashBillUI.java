package client.Presentation.AccountantUI.BillFill;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FillCashBillUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    final Button SummitButton = new Button ("提交单据");
    final Button DraftButton = new Button("保存草稿");
    final Label notification = new Label ();
    final Label billNum = new Label ();
    final TextField account = new TextField("");
    final TextField worker = new TextField("");
    final TextField money = new TextField("");
    final TextArea text = new TextArea ("");

    final Tooltip tooltipForAccount = new Tooltip("输入账户编号");
    final Tooltip tooltipForConsumer = new Tooltip("输入客户编号");
    final Tooltip tooltipForMoney = new Tooltip("金额（数字）");

    String address = " ";

    @Override public void start(Stage stage) {
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 750, 450);

        final ComboBox TypeComboBox = new ComboBox();
        TypeComboBox.getItems().addAll(
                "现金费用单"
        );
        TypeComboBox.setPromptText("现金费用单");
        TypeComboBox.setEditable(false);


        final ComboBox AccountComboBox = new ComboBox();
        AccountComboBox.getItems().addAll(
                "A账户",
                "B账户"
        );
        AccountComboBox.setValue("A账户");


        final ComboBox StaffComboBox = new ComboBox();
        StaffComboBox.getItems().addAll(
                "A员工",
                "B员工"
        );
        StaffComboBox.setValue("A员工");

        account.setTooltip(tooltipForAccount);
        worker.setTooltip(tooltipForConsumer);
        money.setTooltip(tooltipForMoney);

        SummitButton.setOnAction((ActionEvent e) -> {
            if (TypeComboBox.getValue() != null &&
                    !TypeComboBox.getValue().toString().isEmpty()){
                notification.setText("Your message was successfully sent"
                        + " to " + address);
                TypeComboBox.setValue(null);
                if (AccountComboBox.getValue() != null &&
                        !AccountComboBox.getValue().toString().isEmpty()){
                    AccountComboBox.setValue(null);
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
        grid.add(new Label("职工:"), 2, 1);
        grid.add(worker, 3, 1);
        grid.add(new Label("金额:"), 0, 2);
        grid.add(money, 1, 2, 3, 1);
        grid.add(new Label("备注:"), 0, 3);
        grid.add(text, 1, 3, 4, 1);
        grid.add(DraftButton, 0, 4);
        grid.add(SummitButton, 2, 4);
        grid.add (notification, 0, 6, 3, 1);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
}