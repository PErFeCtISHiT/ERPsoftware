package client.Presentation.AccountantUI.CheckSell;

import client.BL.Accountant.FinancialCheckSellbl.FinancialCheckSellController;
import client.BL.Accountant.FinancialCheckSellbl.Sale;
import client.RMI.link;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckSellUI extends Application {

    private final TableView<Sale> table = new TableView<>();
    private final ObservableList<Sale> data =
            FXCollections.observableArrayList(
                    new Sale("2017-1-2", "木头", "A","Z", "S", "C","1","2","3"),
                    new Sale("2016-2-24", "Brown", "D","E", "V", "R","1","2","3"));
    final HBox hb = new HBox();
    TitledPane gridTitlePane = new TitledPane();
    public final String[] infor = new String[9];
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;
    FinancialCheckSellController controller = new FinancialCheckSellController();

    public static void main(String[] args) {
        link.linktoServer();
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
                            infor[6]=data.get(this.getIndex()).consumer.getValue().toString();
                            infor[7]=data.get(this.getIndex()).operater.getValue().toString();
                            infor[8]=data.get(this.getIndex()).base.getValue().toString();

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
                            grid.add(new Label("客户: "), 0, 6);
                            grid.add(new Label(infor[6]), 1, 6);
                            grid.add(new Label("操作员: "), 0, 7);
                            grid.add(new Label(infor[7]), 1, 7);
                            grid.add(new Label("仓库: "), 0, 8);
                            grid.add(new Label(infor[8]), 1, 8);


                            gridTitlePane.setText("详细信息");
                            gridTitlePane.setContent(grid);

                            System.out.println("查看详细信息");
                        });
                    }
                }

            };
            return cell;
        });


        checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(
                                        checkInDatePicker.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };




        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label checkInlabel = new Label("开始时间");
        gridPane.add(checkInlabel, 0, 0);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        checkInDatePicker.setMaxSize(100,20);
        gridPane.add(checkInDatePicker, 0, 1);
        Label checkOutlabel = new Label("结束时间");
        gridPane.add(checkOutlabel, 1, 0);
        GridPane.setHalignment(checkOutlabel, HPos.LEFT);
        checkOutDatePicker.setMaxSize(100,20);
        gridPane.add(checkOutDatePicker, 1, 1);
        Label good = new Label("商品名称");
        gridPane.add(good, 2, 0);
        GridPane.setHalignment(good, HPos.LEFT);
        TextField goodfield = new TextField();
        goodfield.setMaxSize(100,20);
        gridPane.add(goodfield, 2, 1);
        Label consumer = new Label("客户");
        gridPane.add(consumer, 3, 0);
        GridPane.setHalignment(consumer, HPos.LEFT);
        TextField consumerfield = new TextField();
        consumerfield.setMaxSize(100,20);
        gridPane.add(consumerfield, 3, 1);
        Label operater = new Label("业务员");
        gridPane.add(operater, 4, 0);
        GridPane.setHalignment(operater, HPos.LEFT);
        TextField operaterfield = new TextField();
        operaterfield.setMaxSize(100,20);
        gridPane.add(operaterfield, 4, 1);
        Label base = new Label("仓库");
        gridPane.add(base, 5, 0);
        GridPane.setHalignment(base, HPos.LEFT);
        TextField basefield = new TextField();
        basefield.setMaxSize(100,20);
        gridPane.add(basefield, 5, 1);
        Button search = new Button("搜索");
        gridPane.add(search, 6, 1);

        search.setOnAction((ActionEvent e) -> {
            String detail="";
            detail+=checkInDatePicker.getValue();
            detail+=",";
            detail+=checkOutDatePicker.getValue();
            detail+=",";
            detail+=goodfield.getText();
            detail+=",";
            detail+=consumerfield.getText();
            detail+=",";
            detail+=operaterfield.getText();
            detail+=",";
            detail+=basefield.getText();
            System.out.println(detail);

            ArrayList<Sale> list = null;
            try {
                list = controller.search(detail);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            data.clear();
            data.addAll(list);
        });

/////////////////////////////////////////////////////////////////////开始的数据获取

        try {
            System.out.println(0);
            ArrayList<Sale> list =controller.show();
            data.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        table.setItems(data);
        table.getColumns().addAll(TimeCol,NameCol,TypeCol,NumCol,PriceCol,SumCol,DetailCol);

        final Button OutputButton = new Button("导出表格");
        OutputButton.setOnAction((ActionEvent e) -> {

        });

        final Button RefreshButton = new Button("刷新列表");
        RefreshButton.setOnAction((ActionEvent e) -> {
            try {
                ArrayList<Sale> list =controller.show();
                data.clear();
                data.addAll(list);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }

        });



        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(gridPane,label, table, OutputButton);

        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().addAll(vbox,gridTitlePane);

        ((Group) scene.getRoot()).getChildren().addAll(hbox);

        stage.setScene(scene);
        stage.show();
    }

}
