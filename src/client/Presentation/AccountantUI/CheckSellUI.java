package client.Presentation.AccountantUI;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CheckSellUI extends Application {

    private final TableView<Sale> table = new TableView<>();
    private final ObservableList<Sale> data =
            FXCollections.observableArrayList(
                    new Sale("2017-1-2", "木头", "A","Z", "S", "C"),
                    new Sale("2016-2-24", "Brown", "D","E", "V", "R"));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("销售明细表");
        stage.setWidth(1250);
        stage.setHeight(850);

        final Label label = new Label("销售列表");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn<Sale, String> TimeCol =
                new TableColumn<>("操作时间");
        TableColumn<Sale, String> NameCol =
                new TableColumn<>("商品名称");
        TableColumn<Sale, String> TypeCol =
                new TableColumn<>("商品型号");
        TableColumn<Sale, String> NumCol =
                new TableColumn<>("商品数目");
        TableColumn<Sale, String> PriceCol =
                new TableColumn<>("商品单价");
        TableColumn<Sale, String> SumCol =
                new TableColumn<>("商品总价");

        TimeCol.setMinWidth(100);
        TimeCol.setCellValueFactory(
                param -> param.getValue().saleTime);

        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().goodsName);

        TypeCol.setMinWidth(100);
        TypeCol.setCellValueFactory(
                param -> param.getValue().goodsType);

        NumCol.setMinWidth(100);
        NumCol.setCellValueFactory(
                param -> param.getValue().goodsNum);

        PriceCol.setMinWidth(100);
        PriceCol.setCellValueFactory(
                param -> param.getValue().goodsPrice);

        SumCol.setMinWidth(100);
        SumCol.setCellValueFactory(
                param -> param.getValue().totalSum);


        table.setItems(data);
        table.getColumns().addAll(TimeCol,NameCol,TypeCol,NumCol,PriceCol,SumCol);


        final Button DetailButton = new Button("查看详细信息");
        DetailButton.setOnAction((ActionEvent e) -> {


        });
        final Button OutputButton = new Button("导出表格");
        OutputButton.setOnAction((ActionEvent e) -> {


        });

        hb.getChildren().addAll(DetailButton,OutputButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Sale {

        private final SimpleStringProperty saleTime;
        private final SimpleStringProperty goodsName;
        private final SimpleStringProperty goodsType;
        private final SimpleStringProperty goodsNum;
        private final SimpleStringProperty goodsPrice;
        private final SimpleStringProperty totalSum;


        private Sale(String saleTime, String goodsName, String goodsType,String goodsNum, String goodsPrice, String totalSum) {
            this.saleTime = new SimpleStringProperty(saleTime);
            this.goodsName = new SimpleStringProperty(goodsName);
            this.goodsType = new SimpleStringProperty(goodsType);
            this.goodsNum = new SimpleStringProperty(goodsNum);
            this.goodsPrice = new SimpleStringProperty(goodsPrice);
            this.totalSum = new SimpleStringProperty(totalSum);
        }

        public String getSaleTime() {
            return saleTime.get();
        }

        public void setSaleTime(String fName) {
            saleTime.set(fName);
        }

        public String getGoodsName() {
            return goodsName.get();
        }

        public void setGoodsName(String fName) {
            goodsName.set(fName);
        }

        public String getGoodsType() {
            return goodsType.get();
        }

        public void setGoodsType(String fName) {
            goodsType.set(fName);
        }

        public String getGoodsNum() {
            return goodsNum.get();
        }

        public void setGoodsNum(String fName) {
            goodsNum.set(fName);
        }

        public String getGoodsPrice() {
            return goodsPrice.get();
        }

        public void setGoodsPrice(String fName) {
            goodsPrice.set(fName);
        }

        public String getTotalSum() {
            return totalSum.get();
        }

        public void setTotalSum(String fName) {
            totalSum.set(fName);
        }
    }


}