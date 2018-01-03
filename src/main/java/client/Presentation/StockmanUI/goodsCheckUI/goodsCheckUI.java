package client.Presentation.StockmanUI.goodsCheckUI;

import client.BL.Stockman.StockmanGoodsbl.Goods;
import client.BL.Stockman.StockmanStockCheckbl.stockCheckController;
import client.Presentation.StockmanUI.goodsManageUI.goodsManageUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import server.Po.goodsPO;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:52 2017/12/2
 */
public class goodsCheckUI {


    private stockCheckController stockCheckController = new stockCheckController();


    public HBox start() throws RemoteException {

        ObservableList<Goods> data = FXCollections.observableArrayList();

        Callback<TableColumn<Goods, String>,
                TableCell<Goods, String>> cellFactory
                = (TableColumn<Goods, String> p) -> new goodsManageUI.EditingCell();

        List<goodsPO> originGoods = (List<goodsPO>) stockCheckController.StockCheck();
        for (goodsPO i : originGoods) {
            Goods newgoods;
            if (i.getDat() != null) {
                newgoods = new Goods(i.getKeyno(),
                        i.getKeyname(),
                        i.getKeymodel(),
                        String.valueOf(i.getNum()),
                        String.valueOf(i.getInprice()),
                        String.valueOf(i.getOutprice()),
                        String.valueOf(i.getReceprice()),
                        String.valueOf(i.getReceoutprice()),
                        String.valueOf(i.getWarningnum()),
                        i.getKeybatch(),
                        i.getBatchno(),
                        i.getDat().toString());
            } else {
                newgoods = new Goods(i.getKeyno(),
                        i.getKeyname(),
                        i.getKeymodel(),
                        String.valueOf(i.getNum()),
                        String.valueOf(i.getInprice()),
                        String.valueOf(i.getOutprice()),
                        String.valueOf(i.getReceprice()),
                        String.valueOf(i.getReceoutprice()),
                        String.valueOf(i.getWarningnum()),
                        i.getKeybatch(),
                        i.getBatchno(),
                        null);
            }
            data.add(newgoods);

        }


        Label label = new Label();
        label.setText("当前库存");


        TableColumn<Goods, String> IDCol =
                new TableColumn<>("编号");
        TableColumn<Goods, String> NameCol =
                new TableColumn<>("名称");
        TableColumn<Goods, String> ModelCol =
                new TableColumn<>("型号");
        TableColumn<Goods, String> NumCol =
                new TableColumn<>("数量");
        TableColumn<Goods, String> priceCol =
                new TableColumn<>("均价");
        TableColumn<Goods, String> barchcol =
                new TableColumn<>("批次");
        TableColumn<Goods, String> batchnocol =
                new TableColumn<>("批号");
        TableColumn<Goods, String> datecol =
                new TableColumn<>("出厂日期");

        IDCol.setMinWidth(200);
        IDCol.setCellFactory(cellFactory);
        IDCol.setCellValueFactory(
                param -> param.getValue().goodsID);
        NameCol.setMaxWidth(100);
        NameCol.setCellFactory(cellFactory);
        NameCol.setCellValueFactory(
                param -> param.getValue().goodsName);
        ModelCol.setMinWidth(100);
        ModelCol.setCellFactory(cellFactory);
        ModelCol.setCellValueFactory(
                param -> param.getValue().goodsModel);
        NumCol.setMinWidth(100);
        NumCol.setCellFactory(cellFactory);
        NumCol.setCellValueFactory(
                param -> param.getValue().goodsNum);
        priceCol.setMinWidth(100);
        priceCol.setCellFactory(cellFactory);
        priceCol.setCellValueFactory(
                param -> param.getValue().goodsReceinpriceProperty());
        barchcol.setMinWidth(100);
        barchcol.setCellFactory(cellFactory);
        barchcol.setCellValueFactory(
                param -> param.getValue().batch);
        batchnocol.setMinWidth(100);
        batchnocol.setCellFactory(cellFactory);
        batchnocol.setCellValueFactory(
                param -> param.getValue().batchno);
        datecol.setMinWidth(100);
        datecol.setCellFactory(cellFactory);
        datecol.setCellValueFactory(
                param -> param.getValue().outdate);
        Button exportButton = new Button("导出到excel");

        exportButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("EXCEL files (*.xls)", "*.xls");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(new Stage());
            try {
                if (file != null)
                    stockCheckController.exportToExcel(0, file.toString());
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        TableView<Goods> table = new TableView<>();
        table.setEditable(false);
        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol, ModelCol, NumCol, priceCol, barchcol, batchnocol, datecol);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, exportButton);
        HBox ret = new HBox();
        ret.setSpacing(5);
        ret.setPadding(new Insets(10, 0, 0, 10));
        ret.getChildren().add(vbox);

        ret.getStylesheets().add(goodsCheckUI.class.getResource("goodscheck.css").toExternalForm());
        table.getStyleClass().add("table-view");

        return ret;
    }

}
