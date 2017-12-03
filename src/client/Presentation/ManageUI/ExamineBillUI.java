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

public class ExamineBillUI extends Application{

    private final TableView<Billgotten> table = new TableView<>();

    private final ObservableList<Billgotten> data =
            FXCollections.observableArrayList(
                    new Billgotten("1","单据信息","已更新","10000")
            );

    final HBox hb = new HBox();

    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("审批单据");
        stage.setWidth(1250);
        stage.setHeight(850);

        final Label label = new Label("单据列表");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn<Billgotten, String> IdCol =
                new TableColumn<>("单据编号");
        TableColumn<Billgotten, String> MessageCol =
                new TableColumn<>("单据信息");
        TableColumn<Billgotten, String> SituationCol =
                new TableColumn<>("单据状态");
        TableColumn<Billgotten, String> ExamineCol =
                new TableColumn<>("单据信息");

        IdCol.setMinWidth(100);
        IdCol.setCellValueFactory(
                param -> param.getValue().Id);

        MessageCol.setMinWidth(100);
        MessageCol.setCellValueFactory(
                param -> param.getValue().BillMessage);

        SituationCol.setMinWidth(100);
        SituationCol.setCellValueFactory(
                param -> param.getValue().BillState);

        ExamineCol.setMinWidth(100);
        ExamineCol.setCellValueFactory(
                param -> param.getValue().BIllExamineMessage);


        table.setItems(data);
        table.getColumns().addAll(IdCol,MessageCol,SituationCol,ExamineCol);


        final Button button1 = new Button("获取单据");
        button1.setOnAction((ActionEvent e) -> {


        });
        final Button button2 = new Button("更新单据信息");
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

    public static class Billgotten{
        private final SimpleStringProperty Id;
        private final SimpleStringProperty BillMessage;
        private final SimpleStringProperty BillState;
        private final SimpleStringProperty BIllExamineMessage;

        private Billgotten(String id, String billmessage, String billstate, String billexaminemessage){
            this.Id = new SimpleStringProperty(id);
            this.BillMessage =new SimpleStringProperty(billmessage);
            this.BillState =new SimpleStringProperty(billstate);
            this.BIllExamineMessage =new SimpleStringProperty(billexaminemessage);
        }

        public String getId() {
            return Id.get();
        }
        public void setId(String id){
            Id.set(id);
        }

        public String getBillMessage() {
            return BillMessage.get();
        }
        public void setBillMessage(String billmess){
            BillMessage.set(billmess);
        }

        public String getBillState() {
            return BillState.get();}

        public void setBillState(String Billstate){
            BillState.set(Billstate);
        }

        public String getBIllExamineMessage() {
            return BIllExamineMessage.get();
        }
        public void setBIllExamineMessage(String billExamineMessage){
            BIllExamineMessage.set(billExamineMessage);
        }

    }

}
