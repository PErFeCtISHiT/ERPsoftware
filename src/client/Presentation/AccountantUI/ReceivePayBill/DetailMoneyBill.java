package client.Presentation.AccountantUI.ReceivePayBill;

import client.BL.Accountant.FinancialPaybl.FinancialPayController;
import client.BL.Accountant.FinancialReceivebl.FinancialBill;
import client.BL.Accountant.FinancialReceivebl.FinancialReceiveController;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
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

import java.rmi.RemoteException;
import java.util.ArrayList;

public class DetailMoneyBill extends Application{
    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }

    private final TableView<MoneyList> table = new TableView<>();
    private final ObservableList<MoneyList> data =
            FXCollections.observableArrayList();

    final Label TypeComboBox = new Label ();
    final Label StaffComboBox = new Label ("");
    final Label ConsumerTypeComboBox = new Label("");
    final Button OutputButton = new Button("导出单据");
    final Label notification = new Label ();
    final Label billNum = new Label ("");
    final Label consumer = new Label("");
    final Label money = new Label("");

    FinancialReceiveController receiveController = new FinancialReceiveController();
    FinancialPayController payController = new FinancialPayController();
    @Override public void start(Stage stage) {
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 700, 850);




        table.setEditable(true);
        TableColumn<MoneyList,String> AccountCol = new TableColumn<>("银行账户");
        AccountCol.setMinWidth(100);
        AccountCol.setCellValueFactory(
                param -> param.getValue().account);

        TableColumn<MoneyList,String> MoneyCol = new TableColumn<>("转账金额");
        MoneyCol.setMinWidth(100);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);

        TableColumn<MoneyList,String> CommentCol = new TableColumn<>("备注");
        CommentCol.setMinWidth(100);
        CommentCol.setCellValueFactory(
                param -> param.getValue().comment);

        table.setItems(data);
        table.getColumns().addAll(AccountCol,MoneyCol,CommentCol);


        try {
            FinancialBill bill= receiveController.getDetailInfor();
            System.out.println(bill.getID());
            //TypeComboBox.setValue(bill.getBillType());
            billNum.setText(bill.getID());
            StaffComboBox.setText(bill.getOperater());
            ConsumerTypeComboBox.setText(bill.getConsumerType());
            consumer.setText(bill.getConsumerID());
            data.clear();
            data.addAll(bill.getMoneyList());
            money.setText(String.valueOf(bill.getSum()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }


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
        grid.add(table, 1, 2, 3, 1);
        grid.add(new Label("总金额:"), 0, 3);
        grid.add(money, 1, 3, 4, 1);
        grid.add(OutputButton, 3, 4);


        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }


}
