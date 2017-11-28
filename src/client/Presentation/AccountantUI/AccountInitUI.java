package client.Presentation.AccountantUI;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AccountInitUI extends Application {

    private final TableView<AccountList> table = new TableView<>();
    private final ObservableList<AccountList> data =
            FXCollections.observableArrayList(
                    new AccountList("2017", "2017-1-1", "2017-12-30"),
                    new AccountList("2016", "2016-1-1", "2016-12-30"),
                    new AccountList("2015", "2015-1-1", "2015-12-30"));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("期初建账");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("历史账单");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<AccountList,String> YearCol = new TableColumn<>("账单年份");
        YearCol.setMinWidth(100);
        YearCol.setCellValueFactory(
                param -> param.getValue().year);

        TableColumn<AccountList,String> StartCol = new TableColumn<>("开始时间");
        StartCol.setMinWidth(100);
        StartCol.setCellValueFactory(
                param -> param.getValue().start);

        TableColumn<AccountList,String> EndCol = new TableColumn<>("结束时间");
        EndCol.setMinWidth(100);
        EndCol.setCellValueFactory(
                param -> param.getValue().end);

        table.setItems(data);
        table.getColumns().addAll(YearCol, StartCol, EndCol);


        final Button InitButton = new Button("期初建账");
        InitButton.setOnAction((ActionEvent e) -> {

        });
        final Button HistoryButton = new Button("查看详细信息");
        HistoryButton.setOnAction((ActionEvent e) -> {

        });


        hb.getChildren().addAll( InitButton,HistoryButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class AccountList {

        private final SimpleStringProperty year;
        private final SimpleStringProperty start;
        private final SimpleStringProperty end;

        private AccountList(String fName, String lName, String email) {
            this.year = new SimpleStringProperty(fName);
            this.start = new SimpleStringProperty(lName);
            this.end = new SimpleStringProperty(email);
        }

        public String getYear() {
            return year.get();
        }

        public void setYear(String fName) {
            year.set(fName);
        }

        public String getStartTime() {
            return start.get();
        }

        public void setStartTime(String fName) {
            start.set(fName);
        }

        public String getEndTime() {
            return end.get();
        }

        public void setEndTime(String fName) {
            end.set(fName);
        }
    }
}
