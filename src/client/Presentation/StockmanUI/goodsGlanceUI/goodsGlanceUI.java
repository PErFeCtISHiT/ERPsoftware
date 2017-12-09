package client.Presentation.StockmanUI.goodsGlanceUI;

import client.BL.Stockman.StockmanGoodsbl.Goods;
import client.BL.Stockman.StockmanStockGlancebl.goodsinManager;
import client.BL.Stockman.StockmanStockGlancebl.stockGlanceController;
import client.Presentation.StockmanUI.goodsManageUI.goodsManageUI;
import client.RMI.link;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import server.Po.buyinPO;
import server.Po.selloutPO;

import java.rmi.RemoteException;
import java.util.List;

import static javafx.application.Application.launch;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:49 2017/12/2
 */
public class goodsGlanceUI extends Application{
    stockGlanceController stockGlanceController = new stockGlanceController();

    private final TableView<buyinPO> table1 = new TableView<>();
    private final ObservableList<buyinPO> data1 = FXCollections.observableArrayList();



    private final TableView<buyinPO> table2 = new TableView<>();
    private final ObservableList<selloutPO> data2 = FXCollections.observableArrayList();

    final HBox hb = new HBox();

    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }
    @Override
    public void start(Stage stage) throws RemoteException {
        Scene scene = new Scene(new Group());


        stage.setTitle("库存查看");
        stage.setWidth(1000);
        stage.setHeight(550);

        /**
         *todo:传入时间段参数，from，to
         */

        List temp = stockGlanceController.stockglance("1999","2000");
        List<buyinPO> buyinPOS = (List<buyinPO>) temp.get(0);
        List<selloutPO> selloutPOS = (List<selloutPO>) temp.get(1);
        data1.addAll(buyinPOS);
        data2.addAll(selloutPOS);

        final Label label1 = new Label("出入库清单");
        label1.setFont(new Font("Arial", 20));

        table1.setEditable(false);

        final Label label2 = new Label("销售进货清单");
        label2.setFont(new Font("Arial", 20));

        table2.setEditable(false);

        TableColumn<goodsinManager, String> nameCol1 =
                new TableColumn<>("名称");
        nameCol1.setMinWidth(100);
        //nameCol1.setCellValueFactory(param -> param.getValue());
        TableColumn<goodsinManager, String> outnumCol1 =
                new TableColumn<>("出库数量");
        outnumCol1.setMinWidth(100);
        TableColumn<goodsinManager, String> outsumCol1 =
                new TableColumn<>("出库金额");
        outsumCol1.setMinWidth(100);
        TableColumn<goodsinManager, String> innumCol1 =
                new TableColumn<>("入库数量");
        innumCol1.setMinWidth(100);
        TableColumn<goodsinManager, String> insumCol1 =
                new TableColumn<>("入库金额");
        insumCol1.setMinWidth(100);
        TableColumn<goodsinManager,String> allCol1 =
                new TableColumn<>("库存合计");
        allCol1.setMinWidth(100);

    }
}
