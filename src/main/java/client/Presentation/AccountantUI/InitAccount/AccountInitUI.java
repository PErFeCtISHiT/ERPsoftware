package client.Presentation.AccountantUI.InitAccount;

import client.BL.Accountant.FinancialBuildAccountbl.*;
import client.RMI.link;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * @discription: UI for accountant, 期初建账
 * @author: yotta
 */
public class AccountInitUI{


    final String[] imageNames = new String[]{"账户列表", "客户列表", "商品列表"};
    final TitledPane[] tps = new TitledPane[imageNames.length];
    final TableView[] tablelist = new TableView[3];
    TitledPane gridTitlePane = new TitledPane();

    private FinancialBuildController builder= new FinancialBuildController();
    final HBox hb = new HBox();

//start函数
    public VBox start(String staff) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("期初建账");
        stage.setWidth(800);
        stage.setHeight(550);

//期初建账表格
        TableView<AccountList> table = new TableView<>();
        ObservableList<AccountList> data =
                FXCollections.observableArrayList();
        final Label label = new Label("期初信息");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableView<AccountBuild_account> accounttable = new TableView<>();
        ObservableList<AccountBuild_account> accountdata =
                FXCollections.observableArrayList();
        TableView<AccountBuild_consumer> consumertable = new TableView<>();
        ObservableList<AccountBuild_consumer> consumerdata =
                FXCollections.observableArrayList();
        TableView<AccountBuild_good> goodstable = new TableView<>();
        ObservableList<AccountBuild_good> goodsdata =
                FXCollections.observableArrayList();


        TableColumn<AccountList,String> YearCol = new TableColumn<>("账单年份");
        YearCol.setMinWidth(100);
        YearCol.setCellValueFactory(
                param -> param.getValue().year);
//查看详细信息
        TableColumn<AccountList, String> DetailCol =
                new TableColumn<>("详细内容");
        DetailCol.setMinWidth(200);
        DetailCol.setCellFactory((col) -> {
            TableCell<AccountList, String> cell = new TableCell<AccountList, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        Button detailBtn = new Button("查看详细信息");
                        this.setGraphic(detailBtn);
                        detailBtn.setOnMouseClicked((me) -> {
                            String year = data.get(this.getIndex()).getYear();
                            try {
                                AccountBuild accountBuild = builder.getPast(year);
                                accountdata.addAll(accountBuild.getAccountlist());
                                consumerdata.addAll(accountBuild.getConsumerlist());
                                goodsdata.addAll(accountBuild.getGoodslist());

                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }

            };
            return cell;
        });


        ArrayList<AccountList> list = builder.show();
        data.clear();
        data.addAll(list);

        table.setItems(data);
        table.getColumns().addAll(YearCol, DetailCol);

//账户表格
        accounttable.setEditable(true);
        TableColumn<AccountBuild_account, String> IDCol =
                new TableColumn<>("账户编号");
        TableColumn<AccountBuild_account, String> NameCol =
                new TableColumn<>("账户名称");
        TableColumn<AccountBuild_account, String> MoneyCol =
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
//        try {
//            ArrayList<AccountBuild_account> list =accountbuildController.getAllAccount();
//            accountdata.clear();
//            accountdata.addAll(list);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        accounttable.setItems(accountdata);
        accounttable.getColumns().addAll(IDCol, NameCol, MoneyCol);

//客户表格
        TableColumn<AccountBuild_consumer, String> ConsumerIDCol =
                new TableColumn<>("客户编号");
        ConsumerIDCol.setMinWidth(100);
        ConsumerIDCol.setCellValueFactory(
                param -> param.getValue().consumerID);
        TableColumn<AccountBuild_consumer, String> ConsumerNameCol =
                new TableColumn<>("客户名称");
        ConsumerNameCol.setMinWidth(100);
        ConsumerNameCol.setCellValueFactory(
                param -> param.getValue().consumerName);
        TableColumn<AccountBuild_consumer, String> ConsumerTypeCol =
                new TableColumn<>("客户类型");
        ConsumerTypeCol.setMinWidth(100);
        ConsumerTypeCol.setCellValueFactory(
                param -> param.getValue().consumerType);
        TableColumn<AccountBuild_consumer, String> InOutGapCol =
                new TableColumn<>("收付差额");
        InOutGapCol.setMinWidth(100);
        InOutGapCol.setCellValueFactory(
                param -> param.getValue().inOutGap);
        TableColumn<AccountBuild_consumer, String> DueINCol =
                new TableColumn<>("应收差额");
        DueINCol.setMinWidth(100);
        DueINCol.setCellValueFactory(
                param -> param.getValue().dueIN);
        TableColumn<AccountBuild_consumer, String> DuePayCol =
                new TableColumn<>("应收额度");
        DuePayCol.setMinWidth(100);
        DuePayCol.setCellValueFactory(
                param -> param.getValue().duePay);
//        try {
//            ArrayList<AccountBuild_consumer> list =receiveController.getAllConsumer();
//            consumerdata.clear();
//            consumerdata.addAll(list);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        consumertable.setItems(consumerdata);
        consumertable.getColumns().addAll(ConsumerIDCol,ConsumerNameCol,ConsumerTypeCol,InOutGapCol,DueINCol,DuePayCol);

//商品表格
        TableColumn<AccountBuild_good, String> GoodsIDCol =
                new TableColumn<>("编号");
        GoodsIDCol.setMinWidth(200);
        GoodsIDCol.setCellValueFactory(
                param -> param.getValue().goodsID);
        TableColumn<AccountBuild_good, String> GoodsNameCol =
                new TableColumn<>("名称");
        GoodsNameCol.setMinWidth(100);
        GoodsNameCol.setCellValueFactory(
                param -> param.getValue().goodsName);
        TableColumn<AccountBuild_good, String> GoodsModelCol =
                new TableColumn<>("型号");
        GoodsModelCol.setMinWidth(50);
        GoodsModelCol.setCellValueFactory(
                param -> param.getValue().goodsModel);
        TableColumn<AccountBuild_good,String> GoodsTypeCol =
                new TableColumn<>("类型");
        GoodsTypeCol.setMinWidth(50);
        GoodsTypeCol.setCellValueFactory(
                param -> param.getValue().goodsType);

        TableColumn<AccountBuild_good,String> GoodsinpriceCol =
                new TableColumn<>("进价");
        GoodsinpriceCol.setMinWidth(50);
        GoodsinpriceCol.setCellValueFactory(
                param -> param.getValue().goodsInprice);

        TableColumn<AccountBuild_good,String> GoodsoutpriceCol =
                new TableColumn<>("零售价");
        GoodsoutpriceCol.setMinWidth(50);
        GoodsoutpriceCol.setCellValueFactory(
                param -> param.getValue().goodsInprice);

        TableColumn<AccountBuild_good,String> GoodsreceinpriceCol =
                new TableColumn<>("最近进价");
        GoodsreceinpriceCol.setMinWidth(50);
        GoodsreceinpriceCol.setCellValueFactory(
                param -> param.getValue().goodsInprice);

        TableColumn<AccountBuild_good,String> GoodsreceoutpriceCol =
                new TableColumn<>("最近零售价");
        GoodsreceoutpriceCol.setMinWidth(50);
        GoodsreceoutpriceCol.setCellValueFactory(
                param -> param.getValue().goodsOutprice);

        goodstable.setItems(goodsdata);
        goodstable.getColumns().addAll(GoodsIDCol,GoodsNameCol,GoodsModelCol,GoodsTypeCol,GoodsinpriceCol,GoodsoutpriceCol,GoodsreceinpriceCol,GoodsreceoutpriceCol);


        tablelist[0] = accounttable;
        tablelist[1] = consumertable;
        tablelist[2] = goodstable;

        final Accordion accordion = new Accordion ();
        for (int i = 0; i < imageNames.length; i++) {
            tps[i] = new TitledPane(imageNames[i],tablelist[i]);
        }
        accordion.getPanes().addAll(tps);

        Label detaillabel = new Label("详细信息");

        VBox vbx = new VBox();
        vbx.setSpacing(5);
        vbx.getChildren().addAll(detaillabel,accordion);

        final Button RefreshButton = new Button("刷新列表");
        RefreshButton.setOnAction((ActionEvent e) -> {
            try {
                ArrayList<AccountList> list1 =builder.show();
                data.clear();
                data.addAll(list1);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }

        });



        final Button InitButton = new Button("期初建账");
        InitButton.setOnAction((ActionEvent e) -> {
            try {

//                Calendar c = Calendar.getInstance();
//                int yearint = c.get(Calendar.YEAR);
//                String year=yearint+"";
//                System.out.println(year);
//                link.getRemoteHelper().getaccountInit().Build(year);
                AccountBuild accountBuild = builder.accountbuild();
                accountdata.addAll(accountBuild.getAccountlist());
                consumerdata.addAll(accountBuild.getConsumerlist());
                goodsdata.addAll(accountBuild.getGoodslist());
            } catch (RemoteException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (IntrospectionException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }
        });

        final HBox hb1 = new HBox();
        hb1.setSpacing(10);
        hb1.setPadding(new Insets(10, 0, 0, 10));
        hb1.getChildren().addAll(RefreshButton,InitButton);



        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb1);
        hb.getChildren().setAll(vbox,vbx);



        final VBox fvbox = new VBox();
        fvbox.setSpacing(5);
        fvbox.setPadding(new Insets(10,0,0,10));
        fvbox.getChildren().addAll(hb);
        fvbox.setMaxSize(1200,800);
        fvbox.getStylesheets().add("table.css");
        accounttable.getStyleClass().add("table-view");
        consumertable.getStyleClass().add("table-view");
        goodstable.getStyleClass().add("table-view");
        return fvbox;

    }


}
