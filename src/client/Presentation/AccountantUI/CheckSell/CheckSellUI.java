package client.Presentation.AccountantUI.CheckSell;

import client.BL.Accountant.FinancialCheckSellbl.FinancialCheckSellController;
import client.BL.Accountant.FinancialCheckSellbl.Sale;
import client.RMI.link;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.rmi.RemoteException;
import java.util.List;

public class CheckSellUI extends Application {

    private final TableView<Sale> table = new TableView<>();
    private final ObservableList<Sale> data =
            FXCollections.observableArrayList(
                    new Sale("2017-1-2", "木头", "A","Z", "S", "C","1","2","3"),
                    new Sale("2016-2-24", "Brown", "D","E", "V", "R","1","2","3"));
    final HBox hb = new HBox();
    TitledPane gridTitlePane = new TitledPane();
    public final String[] infor = new String[6];
    FinancialCheckSellController controller = new FinancialCheckSellController();

    public static void main(String[] args) {
        //link.getRemoteHelper();
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
        TableColumn<Sale, String> DetailCol =
                new TableColumn<>("详细信息");

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

        DetailCol.setCellFactory((col) -> {
            TableCell<Sale, String> cell = new TableCell<Sale, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button DetailBtn = new Button("详细信息");
                        this.setGraphic(DetailBtn);
                        DetailBtn.setOnMouseClicked((me) -> {
                            //跳转详细信息
                            infor[0]=data.get(this.getIndex()).saleTime.getValue().toString();
                            infor[1]=data.get(this.getIndex()).goodsName.getValue().toString();
                            infor[2]=data.get(this.getIndex()).goodsNum.getValue().toString();
                            infor[3]=data.get(this.getIndex()).goodsPrice.getValue().toString();
                            infor[4]=data.get(this.getIndex()).goodsType.getValue().toString();
                            infor[5]=data.get(this.getIndex()).totalSum.getValue().toString();
                            GridPane grid = new GridPane();
                            grid.setVgap(4);
                            grid.setPadding(new Insets(5, 5, 5, 5));
                            grid.add(new Label("操作时间: "), 0, 0);
                            grid.add(new Label(infor[0]), 1, 0);
                            grid.add(new Label("商品名称: "), 0, 1);
                            grid.add(new Label(infor[1]), 1, 1);
                            grid.add(new Label("商品型号: "), 0, 2);
                            grid.add(new Label(infor[2]), 1, 2);
                            grid.add(new Label("商品数目: "), 0, 3);
                            grid.add(new Label(infor[3]), 1, 3);
                            grid.add(new Label("商品单价: "), 0, 4);
                            grid.add(new Label(infor[4]), 1, 4);
                            grid.add(new Label("商品总价: "), 0, 5);
                            grid.add(new Label(infor[5]), 1, 5);
                            gridTitlePane.setText("详细信息");
                            gridTitlePane.setContent(grid);

                            System.out.println("查看详细信息");
                        });
                    }
                }

            };
            return cell;
        });


/////////////////////////////////////////////////////////////////////开始的数据获取

        try {
            List<Sale> list =controller.show();
            for (int i=0;i<list.size();i++){
                data.add(list.get(i));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }




        table.setItems(data);
        table.getColumns().addAll(TimeCol,NameCol,TypeCol,NumCol,PriceCol,SumCol,DetailCol);

        final Button OutputButton = new Button("导出表格");
        OutputButton.setOnAction((ActionEvent e) -> {

        });



        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, OutputButton);

        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().addAll(vbox,gridTitlePane);

        ((Group) scene.getRoot()).getChildren().addAll(hbox);

        stage.setScene(scene);
        stage.show();
    }


}
