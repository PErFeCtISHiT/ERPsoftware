package client.Presentation.ManageUI;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
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

public class CheckProgressUI extends Application {

    private final TableView<Billgotten> table = new TableView<>();

    private final ObservableList<Billgotten> data =
            FXCollections.observableArrayList(
                    new Billgotten("1","销售类单据","ferry","10000"),
                    new Billgotten("2","销售类单据","ferry","10000")
                    );

    final HBox hb = new HBox();
    @Override
    public void start(Stage stage) {
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


        final Button button1 = new Button("红冲操作");
        button1.setOnAction((ActionEvent e) -> {


        });
        final Button button2 = new Button("红冲复制");
        button2.setOnAction((ActionEvent e) -> {


        });
        final Button button3 = new Button("查看单据详细信息");
        button3.setOnAction((ActionEvent e) -> {


        });

        final Button button4 = new Button("导出经营情况表");
        button4.setOnAction((ActionEvent e) -> {


        });

        hb.getChildren().addAll(button1,button2,button3,button4);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Billgotten{
        private final SimpleStringProperty Id;
        private final SimpleStringProperty BillType;
        private final SimpleStringProperty BillName;
        private final SimpleStringProperty BIllAccount;

        private Billgotten(String id, String billType, String billName, String bIllAccount){
            this.Id = new SimpleStringProperty(id);
            this.BillType =new SimpleStringProperty(billType);
            this.BillName =new SimpleStringProperty(billName);
            this.BIllAccount =new SimpleStringProperty(bIllAccount);
        }

        public String getId() {
            return Id.get();
        }
        public void setId(String id){
            Id.set(id);
        }

        public String getBillType() {
            return BillType.get();
        }
        public void setBillType(String billType){
            BillType.set(billType);
        }

        public String getBillName() {
            return BillName.get();}
        public void setBillName(String billName){
           BillName.set(billName);
        }

        public String getBIllAccount() {
            return BIllAccount.get();
        }
        public void setBIllAccount(String bIllAccount){
            BIllAccount.set(bIllAccount);
        }

    }

}
