package client.Presentation.SalesmanUI.BillMake;

import client.BL.Saleman.SalemanStockinblservice.StockinBill;
import javafx.application.Application;
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



/**
 * Created by Leonarda on 2017/12/2.
 */
public class StockinBillUI extends Application{
    private final TableView<StockinBill> table=new TableView<>();
    private final ObservableList<StockinBill> tableData=
            FXCollections.observableArrayList(
                    new StockinBill("A","B","C","D","E","F","G"),
                    new StockinBill("a","b","c","d","e","f","g")
            );
    final HBox hb=new HBox();
    final VBox vb=new VBox();

    public void start(Stage stage){
        Scene scene=new Scene(new Group());
        stage.setTitle("制定进货单");
        stage.setWidth(700);
        stage.setHeight(450);

        final Label label=new Label("进货单列表");
        label.setFont(new Font("Arial",20));

        table.setEditable(true);

        TableColumn<StockinBill,String> IDcol=new TableColumn<>("单据编号");
        TableColumn<StockinBill,String> Offer=new TableColumn<>(" 供应商");
        TableColumn<StockinBill,String> warehouse=new TableColumn<>("仓库");
        TableColumn<StockinBill,String> operater=new TableColumn<>("操作员");
        TableColumn<StockinBill,String> goodslist=new TableColumn<>("商品列表");
        TableColumn<StockinBill,String> tip=new TableColumn<>("备注");
        TableColumn<StockinBill,String> sum=new TableColumn<>("总额");

        IDcol.setMinWidth(100);
        IDcol.setCellValueFactory(param -> param.getValue().BuyinID);

        Offer.setMinWidth(100);
        Offer.setCellValueFactory(param -> param.getValue().BuyinOffer);

        warehouse.setMinWidth(100);
        warehouse.setCellValueFactory(param -> param.getValue().BuyinStoreHouse);

        operater.setMinWidth(100);
        operater.setCellValueFactory(param -> param.getValue().BuyinOperater);

        goodslist.setMinWidth(100);
        goodslist.setCellValueFactory(param -> param.getValue().BuyinGoodsList);

        tip.setMinWidth(100);
        tip.setCellValueFactory(param -> param.getValue().BuyinTips);

        sum.setMinWidth(100);
        sum.setCellValueFactory(param -> param.getValue().BuyinSum);

        table.setItems(tableData);
        table.getColumns().addAll(IDcol,Offer,warehouse,operater,goodslist,tip,sum);

        vb.setSpacing(5);
        vb.setPadding(new Insets(10,0,0,10));

        final Button BillButton = new Button("生成进货单");
        BillButton.setOnAction((ActionEvent e) -> {

        });
        final Button OutputButton = new Button("导出单据");
        OutputButton.setOnAction((ActionEvent e) -> {

        });

        final HBox hb1= new HBox();
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(10, 0, 0, 10));
        hb1.getChildren().addAll(BillButton,OutputButton);

        vb.getChildren().addAll(label,table,hb1);

        ((Group)scene.getRoot()).getChildren().addAll(vb);

        stage.setScene(scene);
        stage.show();


    }
}
