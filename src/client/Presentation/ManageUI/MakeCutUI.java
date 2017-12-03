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

public class MakeCutUI extends Application{
    private final TableView<Cut> table = new TableView<>();

    private final ObservableList<Cut> data =
            FXCollections.observableArrayList(
                    new Cut("1","记不得了","已更新","2010","2012","3")
            );

    final HBox hb = new HBox();

    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("制定促销策略");
        stage.setWidth(1250);
        stage.setHeight(850);

        final Label label = new Label("促销策略列表");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn<Cut, String> vipCol =
                new TableColumn<>("VIP最低等级");
        TableColumn<Cut, String> strategyCol =
                new TableColumn<>("促销策略选择");
        TableColumn<Cut, String> commodityCol =
                new TableColumn<>("促销商品具体信息");
        TableColumn<Cut, String> begintimeCol =
                new TableColumn<>("开始时间");
        TableColumn<Cut, String> endtimeCol =
                new TableColumn<>("结束时间");
        TableColumn<Cut, String> packinCol =
                new TableColumn<>("从属特价包");


        vipCol.setMinWidth(100);
        vipCol.setCellValueFactory(
                param -> param.getValue().vip);

        strategyCol.setMinWidth(100);
        strategyCol.setCellValueFactory(
                param -> param.getValue().strategy);

        commodityCol.setMinWidth(100);
        commodityCol.setCellValueFactory(
                param -> param.getValue().commodity);

        begintimeCol.setMinWidth(100);
        begintimeCol.setCellValueFactory(
                param -> param.getValue().begintime);

        endtimeCol.setMinWidth(100);
        endtimeCol.setCellValueFactory(
                param -> param.getValue().endtime);

        packinCol.setMinWidth(100);
        packinCol.setCellValueFactory(
                param -> param.getValue().packin);
        table.setItems(data);
        table.getColumns().addAll(vipCol,strategyCol,commodityCol,begintimeCol,endtimeCol,packinCol);


        final Button button1 = new Button("添加");
        button1.setOnAction((ActionEvent e) -> {


        });
        final Button button2 = new Button("确认");
        button2.setOnAction((ActionEvent e) -> {


        });


        hb.getChildren().addAll(button1,button2);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Cut{
        private final SimpleStringProperty vip;
        private final SimpleStringProperty strategy;
        private final SimpleStringProperty commodity;
        private final SimpleStringProperty begintime;
        private final SimpleStringProperty endtime;
        private final SimpleStringProperty packin;


        private Cut(String vip, String strategy, String commodity, String begintime,String endtime,String packin){
            this.vip = new SimpleStringProperty(vip);
            this.strategy =new SimpleStringProperty(strategy);
            this.commodity =new SimpleStringProperty(commodity);
            this.begintime =new SimpleStringProperty(begintime);
            this.endtime =new SimpleStringProperty(endtime);
            this.packin =new SimpleStringProperty(packin);

        }

        public String getVip() {
            return vip.get();
        }
        public void setvip(String VIP){
            vip.set(VIP);
        }

        public String getStrategy() {
            return strategy.get();
        }

        public void setStrategy(String strategy1){
           strategy.set(strategy1);
        }

        public String getCommodity() {
            return commodity.get();
        }

        public void setCommodity(String commodity1){
            commodity.set(commodity1);
        }

        public String getBegintime() {
            return begintime.get();
        }
        public void setBegintime(String begintime1){
            begintime.set(begintime1);
        }
        public String getEndtime() {
            return endtime.get();
        }
        public void setEndtime(String endtime1){
            endtime.set(endtime1);
        }

        public String getPackin() {
            return packin.get();
        }
        public void setPackin(String packin1){
            packin.set(packin1);
        }

    }



}
