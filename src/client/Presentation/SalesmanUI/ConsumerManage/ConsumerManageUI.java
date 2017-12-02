package client.Presentation.SalesmanUI.ConsumerManage;

import client.BL.Saleman.SalemanConsumerManageblservice.Consumer;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import client.Vo.consumerVO;

import java.rmi.RemoteException;

/**
 * Created by Leonarda on 2017/11/29.
 */
public class ConsumerManageUI extends Application {

    private final TableView<Consumer> table=new TableView<>();
    private final ObservableList<Consumer> data=
            FXCollections.observableArrayList(
                    new Consumer("a","b","c","d","e","f","g","h","i","j","k","l","m"),
                    new Consumer("A","B","C","D","E","F","G","H","I","J","K","L","M")
            );
    final HBox hb=new HBox();

    public static void main(String[] args){launch(args);}


    public void start(Stage stage){
        Scene scene=new Scene(new Group());
        stage.setTitle("客户管理");
        stage.setWidth(650);
        stage.setHeight(500);

        final Label label=new Label("客户列表");
        label.setFont(new Font("Arial",20));

        table.setEditable(true);

        Callback<TableColumn<Consumer,String>,
                TableCell<Consumer,String>> cellFactory
                =(TableColumn<Consumer,String> p)->new EditingCell();

        TableColumn<Consumer,String> IDcol= new TableColumn<>("客户ID");
        TableColumn<Consumer,String> jinhuoshang=new TableColumn<>("进货商");
        TableColumn<Consumer,String> xiaoshoushang=new TableColumn<>("销售商");
        TableColumn<Consumer,String> level=new TableColumn<>("级别");
        TableColumn<Consumer,String> name=new TableColumn<>("姓名");
        TableColumn<Consumer,String> phone=new TableColumn<>("电话");
        TableColumn<Consumer,String> address=new TableColumn<>("地址");
        TableColumn<Consumer,String> youbian=new TableColumn<>("邮编");
        TableColumn<Consumer,String> email=new TableColumn<>("电子邮箱");
        TableColumn<Consumer,String> yingshouedu=new TableColumn<>("应收额度");
        TableColumn<Consumer,String> yingshou=new TableColumn<>("应收");
        TableColumn<Consumer,String> yingfu=new TableColumn<>("应付");
        TableColumn<Consumer,String> yewuyuan=new TableColumn<>("业务员");
        TableColumn<Consumer,String> candelete=new TableColumn<>("是否删除");

        IDcol.setMinWidth(30);
        IDcol.setCellValueFactory(param -> param.getValue().ConsumerID);
        IDcol.setCellFactory(cellFactory);
        IDcol.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerID(t.getNewValue());
        });

        jinhuoshang.setMinWidth(30);
        jinhuoshang.setCellValueFactory(param -> param.getValue().ConsumerStockin);
        jinhuoshang.setCellFactory(cellFactory);
        jinhuoshang.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerStockin(t.getNewValue());
                });
        xiaoshoushang.setMinWidth(30);
        xiaoshoushang.setCellValueFactory(param -> param.getValue().ConsumerSell);
        xiaoshoushang.setCellFactory(cellFactory);
        xiaoshoushang.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerSell(t.getNewValue());
                });

        level.setMinWidth(30);
        level.setCellValueFactory(param -> param.getValue().ConsumerLevel);
        level.setCellFactory(cellFactory);
        level.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerLevel(t.getNewValue());
                });

        phone.setMinWidth(30);
        phone.setCellValueFactory(param -> param.getValue().ConsumerName);
        phone.setCellFactory(cellFactory);
        phone.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerPhone(t.getNewValue());
                });

        name.setMinWidth(30);
        name.setCellValueFactory(param -> param.getValue().ConsumerID);
        name.setCellFactory(cellFactory);
        name.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerName(t.getNewValue());
                });

        address.setMinWidth(30);
        address.setCellValueFactory(param -> param.getValue().ConsumerID);
        address.setCellFactory(cellFactory);
        address.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerAddress(t.getNewValue());
                });

        youbian.setMinWidth(30);
        youbian.setCellValueFactory(param -> param.getValue().ConsumerID);
        youbian.setCellFactory(cellFactory);
        youbian.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerMail(t.getNewValue());
                });

        email.setMinWidth(30);
        email.setCellValueFactory(param -> param.getValue().ConsumerID);
        email.setCellFactory(cellFactory);
        email.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerEmail(t.getNewValue());
                });

        yingshouedu.setMinWidth(30);
        yingshouedu.setCellValueFactory(param -> param.getValue().ConsumerID);
        yingshouedu.setCellFactory(cellFactory);
        yingshouedu.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerReveiveMoney(t.getNewValue());
                });

        yingshou.setMinWidth(30);
        yingshou.setCellValueFactory(param -> param.getValue().ConsumerID);
        yingshou.setCellFactory(cellFactory);
        yingshou.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerReceive(t.getNewValue());
                });

        yingfu.setMinWidth(30);
        yingfu.setCellValueFactory(param -> param.getValue().ConsumerID);
        yingfu.setCellFactory(cellFactory);
        yingfu.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setConsumerPay(t.getNewValue());
                });

        yewuyuan.setMinWidth(30);
        yewuyuan.setCellValueFactory(param -> param.getValue().ConsumerID);
        yewuyuan.setCellFactory(cellFactory);
        yewuyuan.setOnEditCommit(
                (CellEditEvent<Consumer, String> t) -> {
                    ((Consumer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSalesman(t.getNewValue());
                });

        candelete.setCellFactory((col) -> {
            TableCell<Consumer, String> cell = new TableCell<Consumer, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            consumerVO consumer= new consumerVO();

                        });
                    }
                }

            };
            return cell;
        });

    }


    class EditingCell extends TableCell<Consumer,String>{
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

            setText((String) getItem());
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


