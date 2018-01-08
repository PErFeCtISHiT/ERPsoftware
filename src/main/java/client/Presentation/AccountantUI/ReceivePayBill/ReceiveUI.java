package client.Presentation.AccountantUI.ReceivePayBill;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialReceivebl.*;
import client.Presentation.tools.NOgenerator;
import client.RMI.link;
import client.Vo.logVO;
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
/**
 * @discription: UI for accountant, 收款单
 * @author: yotta
 */
public class ReceiveUI {

    final String[] imageNames = new String[]{"账户列表", "客户列表", "收款单草稿","已审批","正在审批"};
    final TitledPane[] tps = new TitledPane[imageNames.length];
    final TableView[] tablelist = new TableView[5];
    TitledPane gridTitlePane = new TitledPane();

    final Label TypeComboBox = new Label ();
    final Label StaffComboBox = new Label ("");
    final Label ConsumerTypeComboBox = new Label("");
    final Button OutputButton = new Button("导出单据");
    final Label notification = new Label ();
    final Label billNum = new Label ("");
    final Label consumer = new Label("");
    final Label money = new Label("");

    private final NOgenerator nogenerater = new NOgenerator();




    final HBox hb = new HBox();
    final VBox vb1 = new VBox();
    final VBox vb2 = new VBox();

    FinancialReceiveController receiveController  = new FinancialReceiveController();
//start函数
    public VBox start(String staff) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        Stage stage = new Stage();
        stage.setTitle("制定收款单");
        Scene scene = new Scene(new Group(), 1350, 750);
//转账列表
        TableView<MoneyList> table = new TableView<>();
        ObservableList<MoneyList> data =
                FXCollections.observableArrayList();
//账户列表
        TableView<Account> accounttable = new TableView<>();
        ObservableList<Account> accountdata =
                FXCollections.observableArrayList(
                        new Account("A", "B", "C"),
                        new Account("Q", "W", "E"));
//客户列表
        TableView<Consumer> consumertable = new TableView<>();
        ObservableList<Consumer> consumerdata =
                FXCollections.observableArrayList(
                        new Consumer("A", "B", "C","A", "B", "C","B", "C"),
                        new Consumer("b", "B", "C","A", "B", "C","B", "C"));
//草稿列表
        TableView<AccountBill> draftbilltable = new TableView<>();
        ObservableList<AccountBill> draftbilldata =
                FXCollections.observableArrayList();
//正在审批列表
        TableView<AccountBill> UnderPromotionbilltable = new TableView<>();
        ObservableList<AccountBill> UnderPromotionbilldata =
                FXCollections.observableArrayList();
//已经审批列表
        TableView<AccountBill> AlreadyPromotionbilltable = new TableView<>();
        ObservableList<AccountBill> AlreadyPromotionbilldata =
                FXCollections.observableArrayList();
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        //账户列表
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
            accountdata.clear();
            accountdata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        accounttable.setItems(accountdata);
        accounttable.getColumns().addAll(IDCol, NameCol, MoneyCol);

///////////////////////////////////////////////////////////////////////////////////////////////////////

        //客户列表
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
            consumerdata.clear();
            consumerdata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        consumertable.setItems(consumerdata);
        consumertable.getColumns().addAll(ConsumerIDCol,ConsumerNameCol,ConsumerLevelCol,StaffCol,InOutGapCol,DueINCol,ActualINCol,DuePayCol);

////////////////////////////////////////////////////////////////////////////////////////////
        //草稿列表

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
                        Button editBtn = new Button("编辑收款单");
                        editBtn.setStyle("-fx-border-color: black;-fx-background-color: transparent");
                        this.setGraphic(editBtn);
                        editBtn.setOnMouseClicked((me) -> {
                            ReEditMoneyBill reeditmoneybill= new ReEditMoneyBill();
                            String keyno = draftbilldata.get(this.getIndex()).getKeyno().toString();
                            try {

                                FinancialBill bill = receiveController.ReEditBill(keyno);
                                reeditmoneybill.start(bill,staff);
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
            ArrayList<AccountBill> list =receiveController.getAllDraftReceive();
//            System.out.println("Draft "+list.size()+" "+list.get(0).getKeyno());
            draftbilldata.clear();
            draftbilldata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        draftbilltable.setItems(draftbilldata);
        draftbilltable.getColumns().addAll(BillIDCol,BillTypeCol,BillEditCol);


//////////////////////////////////////////////////////////////////////////////////////////////
        //已经审批列表



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
                        detailBtn.setStyle("-fx-border-color: black;-fx-background-color: transparent");
                        this.setGraphic(detailBtn);
                        detailBtn.setOnMouseClicked((me) -> {
                            String keyno = AlreadyPromotionbilldata.get(this.getIndex()).getKeyno().toString();
                            try {
                                FinancialBill bill = receiveController.ReEditBill(keyno);
                                TypeComboBox.setText(bill.getBillType());
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

                        });
                    }
                }

            };
            return cell;
        });


        try {
            ArrayList<AccountBill> list =receiveController.getAllPromotedReceive();
//            System.out.println("AlR "+list.size()+" "+list.get(0).getKeyno());
            AlreadyPromotionbilldata.clear();
            AlreadyPromotionbilldata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        AlreadyPromotionbilltable.setItems(AlreadyPromotionbilldata);
        AlreadyPromotionbilltable.getColumns().addAll(BillIDCol1,BillTypeCol1,BillDetailCol1);

/////////////////////////////////////////////////////////////////////////////////////////////

        //正在审批列表

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
                                FinancialBill bill = receiveController.ReEditBill(keyno);
                                System.out.println("size: "+bill.getMoneyList().size());
                                TypeComboBox.setText(bill.getBillType());
                                billNum.setText(bill.getID());
                                StaffComboBox.setText(bill.getOperater());
                                ConsumerTypeComboBox.setText(bill.getConsumerType());
                                consumer.setText(bill.getConsumerID());
                                data.clear();
                                data.addAll(bill.getMoneyList());
                                money.setText(String.valueOf(bill.getSum()));

                                logVO log = new logVO();
                                log.setOperatorno(staff);
                                log.setKeyjob("查看详细信息");
                                link.getRemoteHelper().getLog().addObject(log,13);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (IntrospectionException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }

                        });
                    }
                }

            };
            return cell;
        });

        try {
            ArrayList<AccountBill> list =receiveController.getAllUnderPromotedReceive();
//            System.out.println("Under "+list.size()+" "+list.get(0).getKeyno());
            UnderPromotionbilldata.clear();
            UnderPromotionbilldata.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        UnderPromotionbilltable.setItems(UnderPromotionbilldata);
        UnderPromotionbilltable.getColumns().addAll(BillIDCol2,BillTypeCol2,BillDetailCol2);


//////////////////////////////////////////////////////////////////////////////////////////////
        tablelist[0] = accounttable;
        tablelist[1] = consumertable;
        tablelist[2] = draftbilltable;
        tablelist[3] = AlreadyPromotionbilltable;
        tablelist[4] = UnderPromotionbilltable;
        // --- Accordion
        final Accordion accordion = new Accordion ();
        for (int i = 0; i < imageNames.length; i++) {
            tps[i] = new TitledPane(imageNames[i],tablelist[i]);
        }
        accordion.getPanes().addAll(tps);


        hb.getChildren().setAll(accordion,gridTitlePane);
        table.setEditable(true);
        TableColumn<MoneyList,String> AccountCol = new TableColumn<>("银行账户");
        AccountCol.setMinWidth(100);
        AccountCol.setCellValueFactory(
                param -> param.getValue().account);

        TableColumn<MoneyList,String> MoneyListCol = new TableColumn<>("转账金额");
        MoneyListCol.setMinWidth(100);
        MoneyListCol.setCellValueFactory(
                param -> param.getValue().money);

        TableColumn<MoneyList,String> CommentCol = new TableColumn<>("备注");
        CommentCol.setMinWidth(100);
        CommentCol.setCellValueFactory(
                param -> param.getValue().comment);

        table.setItems(data);
        table.getColumns().addAll(AccountCol,MoneyListCol,CommentCol);


//        try {
//            FinancialBill bill= receiveController.getDetailInfor();
//            System.out.println(bill.getID());
//            //TypeComboBox.setValue(bill.getBillType());
//            billNum.setText(bill.getID());
//            StaffComboBox.setText(bill.getOperater());
//            ConsumerTypeComboBox.setText(bill.getConsumerType());
//            consumer.setText(bill.getConsumerID());
//            data.clear();
//            data.addAll(bill.getMoneyList());
//            money.setText(String.valueOf(bill.getSum()));
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }


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
//        grid.add(OutputButton, 3, 4);
        gridTitlePane.setText("详细信息");
        gridTitlePane.setContent(grid);

//刷新列表
        final Button refresh = new Button("刷新列表");
        refresh.setStyle("-fx-border-color: black;-fx-background-color: transparent");
        refresh.setOnAction(e -> {
            try {
                ArrayList<Account> list1 =receiveController.getAllAccount();
                accountdata.clear();
                accountdata.addAll(list1);
                ArrayList<Consumer> list2 =receiveController.getAllConsumer();
                consumerdata.clear();
                consumerdata.addAll(list2);
                ArrayList<AccountBill> list3 =receiveController.getAllDraftReceive();
                draftbilldata.clear();
                draftbilldata.addAll(list3);
                ArrayList<AccountBill> list4 =receiveController.getAllPromotedReceive();
                AlreadyPromotionbilldata.clear();
                AlreadyPromotionbilldata.addAll(list4);
                ArrayList<AccountBill> list5 =receiveController.getAllUnderPromotedReceive();
                UnderPromotionbilldata.clear();
                UnderPromotionbilldata.addAll(list5);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });
//新建收款单
        final Button newBill = new Button("新建收款单");
        newBill.setStyle("-fx-border-color: black;-fx-background-color: transparent");
        newBill.setOnAction(e -> {
            FillMoneyBill fillbill = new FillMoneyBill();
            try {
                String ID = "SFKD-"+nogenerater.generate(5);
                fillbill.start(ID,staff);

                logVO log = new logVO();
                log.setOperatorno(staff);
                log.setKeyjob("新建收款单");
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
        hbox.getChildren().setAll(refresh,newBill);

        VBox vb = new VBox();
        vb.getChildren().setAll(hb,hbox);
        vb.setMaxSize(1200,800);

        vb.getStylesheets().clear();

        vb.getStylesheets().add("table.css");
        accounttable.getStyleClass().add("table-view");
        consumertable.getStyleClass().add("table-view");
        draftbilltable.getStyleClass().add("table-view");
        AlreadyPromotionbilltable.getStyleClass().add("table-view");
        UnderPromotionbilltable.getStyleClass().add("table-view");


        return vb;

//        Group root = (Group)scene.getRoot();
//        root.getChildren().add(vb);
//        stage.setScene(scene);
//        stage.show();
    }

}
