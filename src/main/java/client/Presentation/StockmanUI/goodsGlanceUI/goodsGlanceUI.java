package client.Presentation.StockmanUI.goodsGlanceUI;

import client.BL.Stockman.StockmanStockGlancebl.BaseGoods;
import client.BL.Stockman.StockmanStockGlancebl.ConsumerGoods;
import client.BL.Stockman.StockmanStockGlancebl.stockGlanceController;
import client.RMI.link;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import server.Po.goodsOutListPO;
import server.Po.goodsPO;
import server.Po.stockGoodsPO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:49 2017/12/2
 */
public class goodsGlanceUI {
    private stockGlanceController stockGlanceController = new stockGlanceController();

    private final ObservableList<BaseGoods> data1 = FXCollections.observableArrayList();


    private final ObservableList<ConsumerGoods> data2 = FXCollections.observableArrayList();


    public HBox start() throws RemoteException, ParseException {
        data1.clear();
        data2.clear();
        TableView<BaseGoods> table1 = new TableView<>();
        TableView<ConsumerGoods> table2 = new TableView<>();


        VBox vbox = new VBox();
        HBox hbox = new HBox();
        HBox hbox1 = new HBox();


        DatePicker fromDate = new DatePicker();
        fromDate.setPromptText("始");

        DatePicker toDate = new DatePicker();
        toDate.setPromptText("末");

        Button glance = new Button("查看");
        glance.setStyle("-fx-border-color: black;-fx-background-color: transparent");
        hbox.getChildren().addAll(fromDate, toDate, glance);

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));

        hbox1.setSpacing(5);
        hbox1.setPadding(new Insets(10, 0, 0, 10));

        glance.setOnAction((ActionEvent e) -> {
            data1.clear();
            data2.clear();
            if (fromDate.getValue() != null && toDate.getValue() != null) {
                List temp = null;
                try {
                    temp = stockGlanceController.stockglance(fromDate.getValue(), toDate.getValue());
                } catch (RemoteException | ParseException e1) {
                    e1.printStackTrace();
                }
                List<stockGoodsPO> stockGoodsPOS = (List<stockGoodsPO>) temp.get(0);

                List<goodsOutListPO> goodsOutListPOS = (List<goodsOutListPO>) temp.get(1);
                if (stockGoodsPOS.size() != 0) {
                    for (stockGoodsPO i : stockGoodsPOS) {
                        List<goodsPO> goods = new ArrayList<>();
                        if (i.getKeynum() >= 0) {
                            try {
                                goods = (List<goodsPO>) link.getRemoteHelper().getGoods().goodsfindGoods(i.getGoodsname());
                            } catch (RemoteException e1) {
                                e1.printStackTrace();
                            }
                            String sum;
                            if (goods.size() != 0) {
                                sum = String.valueOf(goods.get(0).getNum());
                            } else {
                                sum = "0";
                            }
                            BaseGoods baseGoods = new BaseGoods(i.getGoodsname(),
                                    "0",
                                    String.valueOf(i.getKeynum()),
                                    String.valueOf(i.getSumall()),
                                    "0",
                                    sum);
                            data1.add(baseGoods);
                        } else {
                            try {
                                goods = (List<goodsPO>) link.getRemoteHelper().getGoods().goodsfindGoods(i.getGoodsname());
                            } catch (RemoteException e1) {
                                e1.printStackTrace();
                            }
                            String sum;
                            if (goods.size() != 0) {
                                sum = String.valueOf(goods.get(0).getNum());
                            } else {
                                sum = "0";
                            }
                            BaseGoods baseGoods = new BaseGoods(i.getGoodsname(),
                                    String.valueOf(-i.getKeynum()),
                                    "0",
                                    "0",
                                    String.valueOf(i.getSumall()),
                                    sum);
                            data1.add(baseGoods);
                        }
                    }
                }
                if (goodsOutListPOS.size() != 0) {
                    for (goodsOutListPO i : goodsOutListPOS) {
                        List<goodsPO> goods = new ArrayList<>();
                        if (i.getNum() >= 0) {
                            try {
                                goods = link.getRemoteHelper().getGoods().goodsfindGoods(i.getGoodsname());
                            } catch (RemoteException e1) {
                                e1.printStackTrace();
                            }
                            String sum;
                            if (goods.size() != 0) {
                                sum = String.valueOf(goods.get(0).getNum());
                            } else {
                                sum = "0";
                            }
                            ConsumerGoods consumerGoods = new ConsumerGoods(i.getGoodsname(),
                                    "0",
                                    String.valueOf(i.getNum()),
                                    String.valueOf(i.getSumall()),
                                    "0",
                                    sum);
                            data2.add(consumerGoods);
                        } else {
                            try {
                                goods = (List<goodsPO>) link.getRemoteHelper().getGoods().goodsfindGoods(i.getGoodsname());
                            } catch (RemoteException e1) {
                                e1.printStackTrace();
                            }
                            String sum;
                            if (goods.size() != 0) {
                                sum = String.valueOf(goods.get(0).getNum());
                            } else {
                                sum = "0";
                            }
                            ConsumerGoods consumerGoods = new ConsumerGoods(i.getGoodsname(),
                                    String.valueOf(-i.getNum()),
                                    "0",
                                    "0",
                                    String.valueOf(i.getSumall()),
                                    sum);
                            data2.add(consumerGoods);
                        }

                    }
                }
            }
        });

        final Label label1 = new Label("出入库清单");
        label1.setFont(new Font("Arial", 20));

        table1.setEditable(false);

        final Label label2 = new Label("销售进货清单");
        label2.setFont(new Font("Arial", 20));

        table2.setEditable(false);

        TableColumn<BaseGoods, String> nameCol1 =
                new TableColumn<>("名称");
        nameCol1.setMinWidth(100);
        nameCol1.setCellValueFactory(param -> param.getValue().goodsName);

        TableColumn<BaseGoods, String> outnumCol1 =
                new TableColumn<>("出库数量");
        outnumCol1.setMinWidth(100);
        outnumCol1.setCellValueFactory(param -> param.getValue().outNum);

        TableColumn<BaseGoods, String> outsumCol1 =
                new TableColumn<>("出库金额");
        outsumCol1.setMinWidth(100);
        outsumCol1.setCellValueFactory(param -> param.getValue().outSum);

        TableColumn<BaseGoods, String> innumCol1 =
                new TableColumn<>("入库数量");
        innumCol1.setMinWidth(100);
        innumCol1.setCellValueFactory(param -> param.getValue().inNum);

        TableColumn<BaseGoods, String> insumCol1 =
                new TableColumn<>("入库金额");
        insumCol1.setMinWidth(100);
        insumCol1.setCellValueFactory(param -> param.getValue().inSum);

        TableColumn<BaseGoods, String> allCol1 =
                new TableColumn<>("库存合计");
        allCol1.setMinWidth(100);
        allCol1.setCellValueFactory(param -> param.getValue().numAll);

        TableColumn<ConsumerGoods, String> nameCol2 =
                new TableColumn<>("名称");
        nameCol2.setMinWidth(100);
        nameCol2.setCellValueFactory(param -> param.getValue().goodsName);

        TableColumn<ConsumerGoods, String> outnumCol2 =
                new TableColumn<>("出库数量");
        outnumCol2.setMinWidth(100);
        outnumCol2.setCellValueFactory(param -> param.getValue().outNum);

        TableColumn<ConsumerGoods, String> outsumCol2 =
                new TableColumn<>("出库金额");
        outsumCol2.setMinWidth(100);
        outsumCol2.setCellValueFactory(param -> param.getValue().outSum);

        TableColumn<ConsumerGoods, String> innumCol2 =
                new TableColumn<>("入库数量");
        innumCol2.setMinWidth(100);
        innumCol2.setCellValueFactory(param -> param.getValue().inNum);

        TableColumn<ConsumerGoods, String> insumCol2 =
                new TableColumn<>("入库金额");
        insumCol2.setMinWidth(100);
        insumCol2.setCellValueFactory(param -> param.getValue().inSum);

        TableColumn<ConsumerGoods, String> allCol2 =
                new TableColumn<>("库存合计");
        allCol2.setMinWidth(100);
        allCol2.setCellValueFactory(param -> param.getValue().numAll);

        table1.setItems(data1);
        table1.getColumns().addAll(nameCol1, outnumCol1, outsumCol1, innumCol1, insumCol1, allCol1);

        table2.setItems(data2);
        table2.getColumns().addAll(nameCol2, outnumCol2, outsumCol2, innumCol2, insumCol2, allCol2);

        VBox t1 = new VBox();
        t1.setSpacing(5);
        t1.setPadding(new Insets(10, 0, 0, 10));
        t1.getChildren().addAll(label1, table1);

        VBox t2 = new VBox();
        t2.setSpacing(5);
        t2.setPadding(new Insets(10, 0, 0, 10));
        t2.getChildren().addAll(label2, table2);

        hbox1.getChildren().addAll(t1, t2);

        vbox.getChildren().addAll(hbox, hbox1);

        HBox ret = new HBox();
        ret.setSpacing(5);
        ret.setPadding(new Insets(10, 0, 0, 10));
        ret.getChildren().add(vbox);

        ret.getStylesheets().add("table.css");
        table1.getStyleClass().add("table-view");
        table2.getStyleClass().add("table-view");

        return ret;


    }
}
