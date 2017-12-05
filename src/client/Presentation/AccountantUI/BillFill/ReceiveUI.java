package client.Presentation.AccountantUI.BillFill;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialReceivebl.AccountBill;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.FinancialReceiveController;
import client.RMI.link;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ReceiveUI extends Application {

    final String[] imageNames = new String[]{"Apples", "Flowers", "Leaves"};
    final TitledPane[] tps = new TitledPane[imageNames.length];
    final TableView[] table = new TableView[4];



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

    private final TableView<AccountBill> draftbilltable = new TableView<>();
    private final ObservableList<AccountBill> draftbilldata =
            FXCollections.observableArrayList();

    private final TableView<AccountBill> underpromotedbilltable = new TableView<>();
    private final ObservableList<AccountBill> underpromotedbilldata =
            FXCollections.observableArrayList();



    final HBox hb = new HBox();
    final VBox vb1 = new VBox();
    final VBox vb2 = new VBox();

    FinancialReceiveController receiveController  = new FinancialReceiveController();

    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }

    @Override public void start(Stage stage) {
        stage.setTitle("TitledPane");
        Scene scene = new Scene(new Group(), 800, 250);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
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
            ArrayList<Account> list =receiveController.getAllAccount();
            accountdata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        accounttable.setItems(accountdata);
        accounttable.getColumns().addAll(IDCol, NameCol, MoneyCol);

///////////////////////////////////////////////////////////////////////////////////////////////////////
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
            ArrayList<Consumer> list =receiveController.getAllConsumer();
            consumerdata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        consumertable.setItems(consumerdata);
        consumertable.getColumns().addAll(ConsumerIDCol,ConsumerNameCol,ConsumerLevelCol,StaffCol,InOutGapCol,DueINCol,ActualINCol,DuePayCol);

////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<AccountBill, String> BillIDCol =
                new TableColumn<>("单据编号");
        TableColumn<AccountBill, String> BillTypeCol =
                new TableColumn<>("单据类型");
        TableColumn<AccountBill, String> BillEditCol =
                new TableColumn<>("");
        BillIDCol.setMinWidth(100);
        BillIDCol.setCellValueFactory(
                param -> param.getValue().keyno);
        BillTypeCol.setMinWidth(100);
        BillTypeCol.setCellValueFactory(
                param -> param.getValue().kind);
        BillEditCol.setMinWidth(200);
        BillEditCol.setCellFactory((col) -> {
            TableCell<AccountBill, String> cell = new TableCell<AccountBill, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        Button editBtn = new Button("编辑");
                        this.setGraphic(editBtn);
                        editBtn.setOnMouseClicked((me) -> {
                            String keyno = draftbilldata.get(this.getIndex()).getKeyno().toString();

                            /////////

                        });
                    }
                }

            };
            return cell;
        });



//////////////////////////////////////////////////////////////////////////////////////////////
        table[0] = accounttable;
        table[1] = consumertable;
        // --- Accordion
        final Accordion accordion = new Accordion ();
        for (int i = 0; i < imageNames.length; i++) {
            tps[i] = new TitledPane(imageNames[i],table[i]);
        }

        accordion.getPanes().addAll(tps);

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 0, 0, 20));
        hbox.getChildren().setAll(accordion);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }
}







// --- GridPane container
//        TitledPane gridTitlePane = new TitledPane();
//        GridPane grid = new GridPane();
//        grid.setVgap(4);
//        grid.setPadding(new Insets(5, 5, 5, 5));
//        grid.add(new Label("To: "), 0, 0);
//        grid.add(new TableView<>(), 1, 0);
//        grid.add(new TextField(), 1, 0);
//        grid.add(new Label("Attachment: "), 0, 3);
//        grid.add(label,1, 3);
//        gridTitlePane.setText("Grid");
//        gridTitlePane.setContent(grid);

//        accordion.expandedPaneProperty().addListener(
//                (ObservableValue<? extends TitledPane> ov, TitledPane old_val, TitledPane new_val) -> {
//                    if (new_val != null) {
//                        label.setText(accordion.getExpandedPane().getText() );
//                }
//        });


