package client.Presentation.AccountantUI.CashBill;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialCashbl.FinancialCash;
import client.BL.Accountant.FinancialCashbl.FinancialCashController;
import client.BL.Accountant.FinancialReceivebl.AccountBill;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.Presentation.AccountantUI.ReceivePayBill.FillMoneyBill;
import client.Presentation.NOgenerator.NOgenerator;
import client.RMI.link;
import client.Vo.logVO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class CashUI {
    final String[] imageNames = new String[]{"账户列表", "客户列表", "现金费用单草稿","已审批","正在审批"};
    final TitledPane[] tps = new TitledPane[imageNames.length];
    final TableView[] tablelist = new TableView[5];
    TitledPane gridTitlePane = new TitledPane();
    private final NOgenerator nogenerater = new NOgenerator();

    final Label TypeComboBox = new Label ();
    final Label StaffComboBox = new Label ("");
    final Button OutputButton = new Button("导出单据");
    final Label notification = new Label ();
    final Label billNum = new Label ("");
    final Label consumer = new Label("");
    final Label money = new Label("");



    final HBox hb = new HBox();
    final VBox vb1 = new VBox();
    final VBox vb2 = new VBox();

    FinancialCashController cashController  = new FinancialCashController();

    public VBox start(String staff) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        Stage stage = new Stage();
        stage.setTitle("制定现金费用单");
        Scene scene = new Scene(new Group(), 1350, 850);


        TableView<MoneyList> table = new TableView<>();
        ObservableList<MoneyList> data =
                FXCollections.observableArrayList();
        TableView<Account> accounttable = new TableView<>();
        ObservableList<Account> accountdata =
                FXCollections.observableArrayList(
                        new Account("A", "B", "C"),
                        new Account("Q", "W", "E"));
        TableView<Consumer> consumertable = new TableView<>();
        ObservableList<Consumer> consumerdata =
                FXCollections.observableArrayList(
                        new Consumer("A", "B", "C","A", "B", "C","B", "C"),
                        new Consumer("b", "B", "C","A", "B", "C","B", "C"));

        TableView<AccountBill> draftbilltable = new TableView<>();
        ObservableList<AccountBill> draftbilldata =
                FXCollections.observableArrayList();

        TableView<AccountBill> UnderPromotionbilltable = new TableView<>();
        ObservableList<AccountBill> UnderPromotionbilldata =
                FXCollections.observableArrayList();

        TableView<AccountBill> AlreadyPromotionbilltable = new TableView<>();
        ObservableList<AccountBill> AlreadyPromotionbilldata =
                FXCollections.observableArrayList();
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        accounttable.setEditable(true);
        TableColumn<Account, String> IDCol =
                new TableColumn<>("账户编号");
        TableColumn<Account, String> NameCol =
                new TableColumn<>("账户名称");
        TableColumn<Account, String> MoneyCol =
                new TableColumn<>("账户余额");
        IDCol.setMinWidth(200);
        IDCol.setCellValueFactory(
                param -> param.getValue().accountID);
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                param -> param.getValue().accountName);
        MoneyCol.setMinWidth(200);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);
        try {
            ArrayList<Account> list = cashController.getAllAccount();
            accountdata.clear();
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
            ArrayList<Consumer> list = cashController.getAllConsumer();
            consumerdata.clear();
            consumerdata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        consumertable.setItems(consumerdata);
        consumertable.getColumns().addAll(ConsumerIDCol, ConsumerNameCol, ConsumerLevelCol, StaffCol, InOutGapCol, DueINCol, ActualINCol, DuePayCol);

////////////////////////////////////////////////////////////////////////////////////////////

        TableColumn<AccountBill, String> BillIDCol =
                new TableColumn<>("单据编号");
        TableColumn<AccountBill, String> BillTypeCol =
                new TableColumn<>("单据类型");
        TableColumn<AccountBill, String> BillEditCol =
                new TableColumn<>("编辑单据");
        BillIDCol.setMinWidth(200);
        BillIDCol.setCellValueFactory(
                param -> param.getValue().keyno);
        BillTypeCol.setMinWidth(200);
        BillTypeCol.setCellValueFactory(
                param -> param.getValue().kind);
        BillEditCol.setMinWidth(200);
        BillEditCol.setCellFactory((col) -> {
            TableCell<AccountBill, String> cell = new TableCell<AccountBill, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        Button editBtn = new Button("编辑现金费用单");
                        this.setGraphic(editBtn);
                        editBtn.setOnMouseClicked((me) -> {
                            ReEditCashBill reEditCashBill = new ReEditCashBill();
                            String keyno = draftbilldata.get(this.getIndex()).getKeyno().toString();
                            try {
                                FinancialCash bill = cashController.ReEditBill(keyno);
                                reEditCashBill.start(bill);
                            } catch (RemoteException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
                                e.printStackTrace();
                            }


                        });
                    }
                }

            };
            return cell;
        });


        try {
            ArrayList<AccountBill> list = cashController.getAllDraftCash();
//            System.out.println("Draft "+list.size()+" "+list.get(0).getKeyno());
            draftbilldata.clear();
            draftbilldata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        draftbilltable.setItems(draftbilldata);
        draftbilltable.getColumns().addAll(BillIDCol, BillTypeCol, BillEditCol);


//////////////////////////////////////////////////////////////////////////////////////////////


        TableColumn<AccountBill, String> BillIDCol1 =
                new TableColumn<>("单据编号");
        TableColumn<AccountBill, String> BillTypeCol1 =
                new TableColumn<>("单据类型");
        TableColumn<AccountBill, String> BillDetailCol1 =
                new TableColumn<>("详细内容");
        BillIDCol1.setMinWidth(200);
        BillIDCol1.setCellValueFactory(
                param -> param.getValue().keyno);
        BillTypeCol1.setMinWidth(200);
        BillTypeCol1.setCellValueFactory(
                param -> param.getValue().kind);
        BillDetailCol1.setMinWidth(200);
        BillDetailCol1.setCellFactory((col) -> {
            TableCell<AccountBill, String> cell = new TableCell<AccountBill, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        Button detailBtn = new Button("详细信息");
                        this.setGraphic(detailBtn);
                        detailBtn.setOnMouseClicked((me) -> {
                            String keyno = AlreadyPromotionbilldata.get(this.getIndex()).getKeyno().toString();
                            try {
                                FinancialCash bill = cashController.ReEditBill(keyno);
                                TypeComboBox.setText(bill.getBillType());
                                billNum.setText(bill.getID());
                                StaffComboBox.setText(bill.getOperater());
                                consumer.setText(bill.getAccount());
                                data.clear();
                                data.addAll(bill.getMoneyList());
                                money.setText(String.valueOf(bill.getSum()));
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }

                        });
                    }
                }

            };
            return cell;
        });

        try {
            ArrayList<AccountBill> list = cashController.getAllPromotedCash();
            AlreadyPromotionbilldata.clear();
            AlreadyPromotionbilldata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        AlreadyPromotionbilltable.setItems(AlreadyPromotionbilldata);
        AlreadyPromotionbilltable.getColumns().addAll(BillIDCol1, BillTypeCol1, BillDetailCol1);

/////////////////////////////////////////////////////////////////////////////////////////////


        TableColumn<AccountBill, String> BillIDCol2 =
                new TableColumn<>("单据编号");
        TableColumn<AccountBill, String> BillTypeCol2 =
                new TableColumn<>("单据类型");
        TableColumn<AccountBill, String> BillDetailCol2 =
                new TableColumn<>("详细内容");
        BillIDCol2.setMinWidth(200);
        BillIDCol2.setCellValueFactory(
                param -> param.getValue().keyno);
        BillTypeCol2.setMinWidth(200);
        BillTypeCol2.setCellValueFactory(
                param -> param.getValue().kind);
        BillDetailCol2.setMinWidth(200);
        BillDetailCol2.setCellFactory((col) -> {
            TableCell<AccountBill, String> cell = new TableCell<AccountBill, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        Button detailBtn = new Button("详细信息");
                        this.setGraphic(detailBtn);
                        detailBtn.setOnMouseClicked((me) -> {
                            String keyno = UnderPromotionbilldata.get(this.getIndex()).getKeyno().toString();
                            try {
                                FinancialCash bill = cashController.ReEditBill(keyno);
                                System.out.println("size: "+bill.getMoneyList().size());
                                TypeComboBox.setText(bill.getBillType());
                                billNum.setText(bill.getID());
                                StaffComboBox.setText(bill.getOperater());
                                consumer.setText(bill.getAccount());
                                data.clear();
                                data.addAll(bill.getMoneyList());
                                money.setText(String.valueOf(bill.getSum()));
                            } catch (RemoteException  e) {
                                e.printStackTrace();
                            }

                        });
                    }
                }

            };
            return cell;
        });

        try {
            ArrayList<AccountBill> list = cashController.getAllUnderPromotedCash();
//            System.out.println("Under "+list.size()+" "+list.get(0).getKeyno());
            UnderPromotionbilldata.clear();
            UnderPromotionbilldata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        UnderPromotionbilltable.setItems(UnderPromotionbilldata);
        UnderPromotionbilltable.getColumns().addAll(BillIDCol2, BillTypeCol2,BillDetailCol2);


//////////////////////////////////////////////////////////////////////////////////////////////
        tablelist[0] = accounttable;
        tablelist[1] = consumertable;
        tablelist[2] = draftbilltable;
        tablelist[3] = AlreadyPromotionbilltable;
        tablelist[4] = UnderPromotionbilltable;
        // --- Accordion
        final Accordion accordion = new Accordion();
        for (int i = 0; i < imageNames.length; i++) {
            tps[i] = new TitledPane(imageNames[i], tablelist[i]);
        }
        accordion.getPanes().addAll(tps);


        hb.getChildren().setAll(accordion,gridTitlePane);
        table.setEditable(true);
        TableColumn<MoneyList,String> AccountCol = new TableColumn<>("条目名称");
        AccountCol.setMinWidth(200);
        AccountCol.setCellValueFactory(
                param -> param.getValue().account);

        TableColumn<MoneyList,String> MoneyListCol = new TableColumn<>("金额");
        MoneyListCol.setMinWidth(200);
        MoneyListCol.setCellValueFactory(
                param -> param.getValue().money);

        TableColumn<MoneyList,String> CommentCol = new TableColumn<>("备注");
        CommentCol.setMinWidth(200);
        CommentCol.setCellValueFactory(
                param -> param.getValue().comment);

        table.setItems(data);
        table.getColumns().addAll(AccountCol,MoneyListCol,CommentCol);



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
        grid.add(new Label("银行账号:"), 2, 1);
        grid.add(consumer, 3, 1);
        grid.add(new Label("条目列表:"), 0, 2);
        grid.add(table, 1, 2, 3, 1);
        grid.add(new Label("总金额:"), 0, 3);
        grid.add(money, 1, 3, 4, 1);
        grid.add(OutputButton, 3, 4);
        gridTitlePane.setText("详细信息");
        gridTitlePane.setContent(grid);




        final Button refresh = new Button("刷新列表");
        refresh.setOnAction(e -> {
            try {
                ArrayList<Account> list1 =cashController.getAllAccount();
                accountdata.clear();
                accountdata.addAll(list1);
                ArrayList<Consumer> list2 =cashController.getAllConsumer();
                consumerdata.clear();
                consumerdata.addAll(list2);
                ArrayList<AccountBill> list3 =cashController.getAllDraftCash();
                draftbilldata.clear();
                draftbilldata.addAll(list3);
                ArrayList<AccountBill> list4 =cashController.getAllPromotedCash();
                AlreadyPromotionbilldata.clear();
                AlreadyPromotionbilldata.addAll(list4);
                ArrayList<AccountBill> list5 =cashController.getAllUnderPromotedCash();
                UnderPromotionbilldata.clear();
                UnderPromotionbilldata.addAll(list5);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });

        final Button newBill = new Button("新建现金费用单");
        newBill.setOnAction(e -> {
            FillCashBillUI fillbill = new FillCashBillUI();
            try {
                String ID = "XJFYD-"+nogenerater.generate(5);
                fillbill.start(ID);
                logVO log = new logVO();
                log.setOperatorno(staff);
                log.setKeyjob("新建现金费用单");
                link.getRemoteHelper().getLog().addObject(log,13);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            } catch (IntrospectionException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }

        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 0, 0, 20));
        hbox.getChildren().setAll(refresh, newBill);

        VBox vb = new VBox();
        vb.getChildren().setAll(hb, hbox);
        vb.setMaxSize(1200,800);
        vb.getStylesheets().add(CashUI.class.getResource("CashBillCss.css").toExternalForm());
        accounttable.getStyleClass().add("table-view");
        consumertable.getStyleClass().add("table-view");
        draftbilltable.getStyleClass().add("table-view");
        AlreadyPromotionbilltable.getStyleClass().add("table-view");
        UnderPromotionbilltable.getStyleClass().add("table-view");
        return vb;

//        Group root = (Group) scene.getRoot();
//        root.getChildren().add(vb);
//        stage.setScene(scene);
//        stage.show();

    }


}
