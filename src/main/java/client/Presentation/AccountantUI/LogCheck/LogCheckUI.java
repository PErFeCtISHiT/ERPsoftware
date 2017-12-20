package client.Presentation.AccountantUI.LogCheck;

import client.BL.Logbl.Log;
import client.BL.Logbl.LogController;
import client.Vo.logVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class LogCheckUI {

    private final ObservableList<Log> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();

    LogController controller  = new LogController();


    public VBox start(String staff) throws Exception {
        TableView<Log> table = new TableView<>();
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("日志查看");
        stage.setWidth(750);
        stage.setHeight(550);

        final Label label = new Label("日志列表");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);

        TableColumn<Log, String> TimeCol =
                new TableColumn<>("时间");
        TableColumn<Log, String> StaffCol =
                new TableColumn<>("操作员");
        TableColumn<Log, String> OperationCol =
                new TableColumn<>("具体操作");

/////////////////////////////////////////////////////////////////////////////////修改传递
        TimeCol.setMinWidth(200);
        TimeCol.setCellValueFactory(
                param -> param.getValue().time);

/////////////////////////////////////////////////////////////////////////////////修改传递
        StaffCol.setMinWidth(200);
        StaffCol.setCellValueFactory(
                param -> param.getValue().staffno);

/////////////////////////////////////////////////////////////////////////////////修改传递
        OperationCol.setMinWidth(200);
        OperationCol.setCellValueFactory(
                param -> param.getValue().operation);

///////

//////////////////////////////////////////////////////////////////////////////////////开始获取数据
        try {
            ArrayList<Log> list =controller.show();
            data.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        table.setItems(data);
        table.getColumns().addAll(TimeCol, StaffCol, OperationCol);


        final Button refresh = new Button("刷新列表");
        refresh.setOnAction(e -> {
            refresh();
        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        vbox.setMaxSize(1000,800);
        return vbox;
    }


    public void refresh() {
        try {
            ArrayList<Log> list =controller.show();
            data.clear();
            data.addAll(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
