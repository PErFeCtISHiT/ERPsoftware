package client.Presentation.AdminUI;
import client.BL.Administrator.Userblservice.UserMsg;
import client.Presentation.NOgenerator.NOgenerator;
import client.RMI.link;
import client.Vo.logVO;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import server.Po.userPO;




import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.List;

public class SetUI {

    private final ObservableList<UserMsg> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();

    private NOgenerator nogenerator = new NOgenerator();


    public VBox start(String staff) throws Exception {
        TableView<UserMsg> table = new TableView<>();
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("用户管理");
        stage.setWidth(750);
        stage.setHeight(550);

        final Label label = new Label("用户列表");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);

        Callback<TableColumn<UserMsg, String>,
                TableCell<UserMsg, String>> cellFactory
                = (TableColumn<UserMsg, String> p) -> new SetUI.EditingCell();

        TableColumn<UserMsg, String> name =
                new TableColumn<>("用户名");
        TableColumn<UserMsg, String> job =
                new TableColumn<>("职位");
        TableColumn<UserMsg, String> ID =
                new TableColumn<>("工号");
        TableColumn<UserMsg, String> Passwards =
                new TableColumn<>("密码");
        TableColumn<UserMsg, String> delete =
                new TableColumn<>("删除");

        name.setMinWidth(200);
        name.setCellValueFactory(
                param -> param.getValue().Name);

        job.setMinWidth(200);
        job.setCellValueFactory(
                param -> param.getValue().Job);
        job.setCellFactory(cellFactory);
        job.setOnEditCommit(
                (TableColumn.CellEditEvent<UserMsg, String> t) -> {
                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setName(t.getNewValue());
                    UserMsg acc = t.getTableView().getItems().get(t.getTablePosition().getRow());

                });


        ID.setMinWidth(200);
        ID.setCellValueFactory(
                param -> param.getValue().No);
        ID.setCellFactory(cellFactory);
        ID.setOnEditCommit(
                (TableColumn.CellEditEvent<UserMsg, String> t) -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setJob(t.getNewValue());
                    UserMsg acc = t.getTableView().getItems().get(t.getTablePosition().getRow());

                    try {
                        logVO log = new logVO();
                        log.setOperatorno(staff);
                        log.setKeyjob("修改职位");
                        link.getRemoteHelper().getLog().addObject(log,13);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IntrospectionException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                });

        Passwards.setMinWidth(200);
        Passwards.setCellValueFactory(
                param -> param.getValue().No);
        Passwards.setCellFactory(cellFactory);
        Passwards.setOnEditCommit(
                (TableColumn.CellEditEvent<UserMsg, String> t) -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setJob(t.getNewValue());
                    UserMsg acc = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    try {
                        link.getRemoteHelper().getUser().modifyObject(acc,15);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    try {
                        logVO log = new logVO();
                        log.setOperatorno(staff);
                        log.setKeyjob("修改职位");
                        link.getRemoteHelper().getLog().addObject(log,13);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IntrospectionException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                });

        delete.setCellFactory((col) -> {
            TableCell<UserMsg, String> cell = new TableCell<UserMsg, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            String delid = data.get(this.getIndex()).getNO();
                            UserMsg msg =new UserMsg("liuyitong",delid,"haha","boss");
                            try {
                                link.getRemoteHelper().getUser().deleteObject(msg,15);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                            data.remove(this.getIndex());


                        });
                    }
                }

            };
            return cell;
        });

//////////////////////////////////////////////////////////////////////////////////////开始获取数据
        try {
            List<userPO> list = link.getRemoteHelper().getUser().findAll(15);
            for (int i=0;i<list.size();i++){

                UserMsg newco = new UserMsg(list.get(i).getKeyname(),list.get(i).getKeyjob(),list.get(i).getKeyno(),list.get(i).getPasswor());
                data.add(newco);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }



        table.setItems(data);
        table.getColumns().addAll(name,job,ID,Passwards,delete);

        GridPane grid3 = new GridPane();
        grid3.setVgap(4);
        grid3.setHgap(10);
        grid3.setPadding(new Insets(5, 5, 5, 5));

        TextField addName = new TextField();
        addName.setPromptText("用户名");
        grid3.add(addName,0,0);
        TextField addJob = new TextField();
        addJob.setPromptText("用户职位");
        grid3.add(addName,0,1);
        TextField pass = new TextField();
        pass.setPromptText("登录密码");
        grid3.add(pass,0,2);


        HBox newhb = new HBox();
        newhb.setSpacing(5);
        newhb.setPadding(new Insets(10, 0, 0, 10));
        newhb.getChildren().addAll(label);


        final Button addButton = new Button("添加用户");
        addButton.setOnAction((ActionEvent e) -> {
            try {
                String iD = "YH-"+nogenerator.generate(15);
                UserMsg msg = new UserMsg(
                        addName.getText(),iD,pass.getText(),
                        pass.getText());
                data.add(msg);


                logVO log = new logVO();
                log.setOperatorno(staff);
                log.setOpno("增加账户");
                link.getRemoteHelper().getLog().addObject(log,13);


            } catch (RemoteException e1) {
                e1.printStackTrace();
            } catch (IntrospectionException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }

            addName.clear();
            addJob.clear();
            pass.clear();
        });

        Button refresh = new Button("刷新列表");
        refresh.setOnAction(e -> {
            refresh();
        });

        hb.getChildren().addAll(grid3, addButton,refresh);//addID,
        hb.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(newhb, table, hb);
        vbox.setMaxSize(1000,800);
        return vbox;

//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
//
//        stage.setScene(scene);
//        stage.show();
    }


    public void refresh() {
        try {data.clear();
            List<userPO> list = link.getRemoteHelper().getUser().findAll(15);
            for (int i=0;i<list.size();i++){

                UserMsg newco = new UserMsg(list.get(i).getKeyname(),list.get(i).getKeyjob(),list.get(i).getKeyno(),list.get(i).getPasswor());
                data.add(newco);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    class EditingCell extends TableCell<UserMsg, String> {

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
