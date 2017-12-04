package client.Presentation.AccountantUI.BillFill;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialCashbl.FinancialCashController;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.RMI.link;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class CashBillUI extends Application {

    private final TableView<Account> accounttable = new TableView<>();
    private final ObservableList<Account> accountdata =
            FXCollections.observableArrayList(
                    new Account("A", "B", "C"),
                    new Account("Q", "W", "E"));
    private final TableView<Consumer> consumertable = new TableView<>();
    private final ObservableList<Consumer> consumerdata =
            FXCollections.observableArrayList(
                    new Consumer("A", "B", "C","A", "B", "C","B", "C"),
                    new Consumer("b", "B", "C","A", "B", "C","B", "C"));

    final HBox hb = new HBox();
    final VBox vb1 = new VBox();
    final VBox vb2 = new VBox();
    FinancialCashController cashController = new FinancialCashController();

    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("制定现金费用单");
        stage.setWidth(1300);
        stage.setHeight(850);

        final Label accountlabel = new Label("账户列表");
        accountlabel.setFont(new Font("Arial", 20));
        accounttable.setEditable(true);

        TableColumn<Account, String> IDCol =
                new TableColumn<>("账户编号");
        TableColumn<Account, String> NameCol =
                new TableColumn<>("账户名称");
        TableColumn<Account, String> MoneyCol =
                new TableColumn<>("账户余额");


        IDCol.setMinWidth(100);
        IDCol.setCellValueFactory(
                param -> param.getValue().accountID);



        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().accountName);


        MoneyCol.setMinWidth(200);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);

        try {
            ArrayList<Account> list =cashController.getAllAccount();
            accountdata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }



        accounttable.setItems(accountdata);
        accounttable.getColumns().addAll(IDCol, NameCol, MoneyCol);

        vb1.setSpacing(5);
        vb1.setPadding(new Insets(10, 0, 0, 10));
        vb1.getChildren().addAll(accountlabel,  accounttable);



        final Label consumerlabel = new Label("客户列表");
        consumerlabel.setFont(new Font("Arial", 20));

        TableColumn<Consumer, String> ConsumerIDCol =
                new TableColumn<>("客户编号");
        ConsumerIDCol.setMinWidth(100);
        ConsumerIDCol.setCellValueFactory(
                param -> param.getValue().consumerID);
        TableColumn<Consumer, String> ConsumerNameCol =
                new TableColumn<>("客户名称");
        ConsumerNameCol.setMinWidth(100);
        ConsumerNameCol.setCellValueFactory(
                param -> param.getValue().consumerName);
        TableColumn<Consumer, String> ConsumerLevelCol =
                new TableColumn<>("客户星级");
        ConsumerLevelCol.setMinWidth(100);
        ConsumerLevelCol.setCellValueFactory(
                param -> param.getValue().consumerLevel);
        TableColumn<Consumer, String> StaffCol =
                new TableColumn<>("业务员");
        StaffCol.setMinWidth(100);
        StaffCol.setCellValueFactory(
                param -> param.getValue().staff);
        TableColumn<Consumer, String> InOutGapCol =
                new TableColumn<>("收付差额");
        InOutGapCol.setMinWidth(100);
        InOutGapCol.setCellValueFactory(
                param -> param.getValue().inOutGap);
        TableColumn<Consumer, String> DueINCol =
                new TableColumn<>("应收差额");
        DueINCol.setMinWidth(100);
        DueINCol.setCellValueFactory(
                param -> param.getValue().dueIN);
        TableColumn<Consumer, String> ActualINCol =
                new TableColumn<>("实收金额");
        ActualINCol.setMinWidth(100);
        ActualINCol.setCellValueFactory(
                param -> param.getValue().actualIN);
        TableColumn<Consumer, String> DuePayCol =
                new TableColumn<>("应收额度");
        DuePayCol.setMinWidth(100);
        DuePayCol.setCellValueFactory(
                param -> param.getValue().duePay);

        try {
            ArrayList<Consumer> list =cashController.getAllConsumer();
            consumerdata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        consumertable.setItems(consumerdata);
        consumertable.getColumns().addAll(ConsumerIDCol,ConsumerNameCol,ConsumerLevelCol,StaffCol,InOutGapCol,DueINCol,ActualINCol,DuePayCol);


        final Button BillButton = new Button("生成收款单");
        BillButton.setOnAction((ActionEvent e) -> {

        });
        final Button OutputButton = new Button("导出单据");
        OutputButton.setOnAction((ActionEvent e) -> {

        });

        final HBox hb1= new HBox();
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(10, 0, 0, 10));
        hb1.getChildren().addAll(BillButton,OutputButton);


        vb2.setSpacing(5);
        vb2.setPadding(new Insets(10, 0, 0, 10));
        vb2.getChildren().addAll(consumerlabel,  consumertable,hb1);






        hb.setSpacing(5);
        hb.setPadding(new Insets(10, 0, 0, 10));
        hb.getChildren().addAll(vb1,  vb2);

        ((Group) scene.getRoot()).getChildren().addAll(hb);

        stage.setScene(scene);
        stage.show();
    }





}