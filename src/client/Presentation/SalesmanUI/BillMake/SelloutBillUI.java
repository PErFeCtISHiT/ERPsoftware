package client.Presentation.SalesmanUI.BillMake;

import client.BL.Saleman.SalemanSaleblservice.SelloutBill;
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
 * Created by Leonarda on 2017/12/3.
 */
public class SelloutBillUI extends Application{
    private final TableView<SelloutBill> table=new TableView<>();
    private final ObservableList<SelloutBill> tableData=
            FXCollections.observableArrayList(
                    new SelloutBill("A","B","C","D","E","F","G","H","I","J","K"),
                    new SelloutBill("a","b","c","d","e","f","g","h","i","j","k")
            );
    final HBox hb=new HBox();
    final VBox vb=new VBox();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage){
        Scene scene=new Scene(new Group());
        stage.setTitle("制定进货单");
        stage.setWidth(900);
        stage.setHeight(600);

        final Label label=new Label("进货单列表");
        label.setFont(new Font("Arial",20));

        table.setEditable(true);

        TableColumn<SelloutBill,String> IDcol=new TableColumn<>("单据编号");
        TableColumn<SelloutBill,String> consumer=new TableColumn<>(" 客户");
        TableColumn<SelloutBill,String> server=new TableColumn<>("业务员");
        TableColumn<SelloutBill,String> operater=new TableColumn<>("操作员");
        TableColumn<SelloutBill,String> warehouse=new TableColumn<>("仓库");
        TableColumn<SelloutBill,String> goodslist=new TableColumn<>("出货商品清单");
        TableColumn<SelloutBill,String> beforemoney=new TableColumn<>("折让前金额");
        TableColumn<SelloutBill,String> cut=new TableColumn<>("折让");
        TableColumn<SelloutBill,String> card=new TableColumn<>("代金券金额");
        TableColumn<SelloutBill,String> sum=new TableColumn<>("折让后总额");
        TableColumn<SelloutBill,String> tip=new TableColumn<>("备注");

        IDcol.setMinWidth(100);
        IDcol.setCellValueFactory(param -> param.getValue().selloutID);

        consumer.setMinWidth(100);
        consumer.setCellValueFactory(param -> param.getValue().selloutConsumer);

        server.setMinWidth(100);
        server.setCellValueFactory(param -> param.getValue().selloutServer);

        operater.setMinWidth(100);
        operater.setCellValueFactory(param -> param.getValue().selloutOperater);

        goodslist.setMinWidth(100);
        goodslist.setCellValueFactory(param -> param.getValue().selloutGoodslist);

        warehouse.setMinWidth(100);
        warehouse.setCellValueFactory(param -> param.getValue().selloutWarehouse);

        beforemoney.setMinWidth(100);
        beforemoney.setCellValueFactory(param -> param.getValue().selloutBeforeMoney);

        cut.setMinWidth(100);
        cut.setCellValueFactory(param -> param.getValue().selloutDiscount);

        card.setMinWidth(100);
        card.setCellValueFactory(param -> param.getValue().selloutCard);

        sum.setMinWidth(100);
        sum.setCellValueFactory(param -> param.getValue().selloutSum);

        tip.setMinWidth(100);
        tip.setCellValueFactory(param -> param.getValue().selloutTip);

        table.setItems(tableData);
        table.getColumns().addAll(IDcol,consumer,server,operater,warehouse,goodslist,beforemoney,cut,card,sum,tip);

        vb.setSpacing(5);
        vb.setPadding(new Insets(10,0,0,10));

        final Button BillButton = new Button("生成销售单");
        BillButton.setOnAction((ActionEvent e) -> {

        });
        final Button OutputButton = new Button("导出单据");
        OutputButton.setOnAction((ActionEvent e) -> {
            System.out.println("提交成功");
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
