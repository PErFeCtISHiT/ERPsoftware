package client.Presentation.ManageUI;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import client.BL.Manager.ManagerCheckProcessService.Billgotten;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.Locale;

public class CheckProgressUI extends Application {

    private final TableView<Billgotten> table = new TableView<>();
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;


    private final ObservableList<Billgotten> data =
            FXCollections.observableArrayList(
                    new Billgotten("1","销售类单据","ferry","10000"),
                    new Billgotten("2","销售类单据","ferry","10000")
                    );

    final HBox hb = new HBox();
    final HBox hb2 =new HBox();
    Callback<TableColumn<Billgotten,String>,
            TableCell<Billgotten,String>> cellFactory
            =(TableColumn<Billgotten,String> p)->new CheckProgressUI.EditingCell();
    @Override
    public void start(Stage stage) {
        Locale.setDefault(Locale.CHINA);
        Scene scene = new Scene(new Group());
        stage.setTitle("经营历程表");

        stage.setWidth(1250);
        stage.setHeight(850);

        final Label label = new Label("单据列表");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn<Billgotten, String> IdCol =
                new TableColumn<>("序号");
        TableColumn<Billgotten, String> TypeCol =
                new TableColumn<>("类型");
        TableColumn<Billgotten, String> NameCol =
                new TableColumn<>("名称");
        TableColumn<Billgotten, String> AccountCol =
                new TableColumn<>("金额");

        IdCol.setMinWidth(100);
        IdCol.setCellValueFactory(
                param -> param.getValue().Id);

        TypeCol.setMinWidth(100);
        TypeCol.setCellValueFactory(
                param -> param.getValue().BillType);

        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().BillName);

        AccountCol.setMinWidth(100);
        AccountCol.setCellValueFactory(
                param -> param.getValue().BIllAccount);


        table.setItems(data);
        table.getColumns().addAll(IdCol,TypeCol,NameCol,AccountCol);

        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");

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
        gridPane.add(checkInDatePicker, 0, 1);
        Label checkOutlabel = new Label("结束时间");
        gridPane.add(checkOutlabel, 1, 0);
        GridPane.setHalignment(checkOutlabel, HPos.LEFT);
        gridPane.add(checkOutDatePicker, 1, 1);
        vbox.getChildren().add(gridPane);


        final Button button1 = new Button("红冲操作");
        button1.setOnAction((ActionEvent e) -> {


        });
        final Button button2 = new Button("红冲复制");
        button2.setOnAction((ActionEvent e) -> {


        });
        final Button button3 = new Button("导出经营情况表");
        button3.setOnAction((ActionEvent e) -> {


        });

        final Button button4 = new Button("查询");
        button4.setOnAction((ActionEvent e) -> {


        });

        final TextField BillType= new TextField();
        BillType.setPromptText("单据类型");

        final TextField  client= new TextField();
        client.setPromptText("客户");
        final TextField salesman = new TextField();

        salesman.setPromptText("业务员");
        final TextField storehouse = new TextField();
        storehouse.setPromptText("仓库");


        hb.getChildren().addAll(button1,button2,button3,button4);
        hb.setSpacing(3);

        hb2.getChildren().addAll(vbox);

        final VBox vbox1 = new VBox();
        vbox1.setSpacing(5);
        vbox1.setPadding(new Insets(10, 0, 0, 10));
        vbox1.getChildren().addAll(label, table, hb,hb2,BillType,client,salesman,storehouse);

        ((Group) scene.getRoot()).getChildren().addAll(vbox1);

        stage.setScene(scene);
        stage.show();
    }


    class EditingCell extends TableCell<Billgotten,String>{
        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(
                    (ObservableValue<? extends Boolean> arg0,
                     Boolean arg1, Boolean arg2) -> {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                    });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }


}
