package client.Presentation.SalesmanUI.ConsumerManage;

import client.BL.Saleman.SalemanConsumerManageblservice.Consumer;
import client.BL.Saleman.SalemanConsumerManageblservice.ConsumerManageController;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.event.ActionEvent;

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
        stage.setWidth(1200);
        stage.setHeight(600);

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
                            consumer.setAccoun("a");
                            data.remove(this.getIndex());
                            System.out.println("删除成功");
                            ConsumerManageController consumerManageController=new ConsumerManageController();
                            try{
                                consumerManageController.deleteConsumer(consumer);
                            }catch(RemoteException e){
                                e.printStackTrace();
                            }
                        });
                    }
                }

            };
            return cell;
        });

        table.setItems(data);
        table.getColumns().addAll(IDcol,jinhuoshang,xiaoshoushang,level,name,phone,address,youbian,email,yingshouedu,yingfu,yingshou,yewuyuan,candelete);

        final TextField field1=new TextField();
        field1.setPromptText("客户ID");
        field1.setMaxWidth(IDcol.getPrefWidth());
        final TextField field2=new TextField();
        field2.setPromptText("进货商");
        field2.setMaxWidth(jinhuoshang.getPrefWidth());
        final TextField field3=new TextField();
        field3.setPromptText("销售商");
        field3.setMaxWidth(xiaoshoushang.getPrefWidth());
        final TextField field4=new TextField();
        field4.setPromptText("级别");
        field4.setMaxWidth(level.getPrefWidth());
        final TextField field5=new TextField();
        field5.setPromptText("姓名");
        field5.setMaxWidth(level.getPrefWidth());
        final TextField field6=new TextField();
        field6.setPromptText("电话");
        field6.setMaxWidth(level.getPrefWidth());
        final TextField field7=new TextField();
        field7.setPromptText("地址");
        field7.setMaxWidth(level.getPrefWidth());
        final TextField field8=new TextField();
        field8.setPromptText("邮编");
        field8.setMaxWidth(level.getPrefWidth());
        final TextField field9=new TextField();
        field9.setPromptText("电子邮箱");
        field9.setMaxWidth(level.getPrefWidth());
        final TextField field10=new TextField();
        field10.setPromptText("应收额度");
        field10.setMaxWidth(level.getPrefWidth());
        final TextField field11=new TextField();
        field11.setPromptText("应收");
        field11.setMaxWidth(level.getPrefWidth());
        final TextField field12=new TextField();
        field12.setPromptText("应付");
        field12.setMaxWidth(level.getPrefWidth());
        final TextField field13=new TextField();
        field13.setPromptText("业务员");
        field13.setMaxWidth(level.getPrefWidth());

        final Button button=new Button("添加");
        button.setOnAction((ActionEvent e)->{
            Consumer consumer=new Consumer(
                    field1.getText(),
                    field2.getText(),
                    field3.getText(),
                    field4.getText(),
                    field5.getText(),
                    field6.getText(),
                    field7.getText(),
                    field8.getText(),
                    field9.getText(),
                    field10.getText(),
                    field11.getText(),
                    field12.getText(),
                    field13.getText());
            data.add(consumer);
            consumerVO vo=new consumerVO(
                    field1.getText(),
                    Long.parseLong(field2.getText()+field3.getText()), //?????????????????
                    Long.parseLong(field4.getText()),
                    field5.getText(),
                    field6.getText(),
                    field8.getText(),
                    field9.getText(),
                    Long.parseLong(field10.getText()),
                    Long.parseLong(field11.getText()),
                    Long.parseLong(field12.getText()),
                    field13.getText(),
                    " ");
            ConsumerManageController consumerManageController=new ConsumerManageController();
            try{
                consumerManageController.addConsumer(vo);
            }catch (RemoteException e1){
                e1.printStackTrace();
            }

            field1.clear();
            field2.clear();
            field3.clear();
            field4.clear();
            field5.clear();
            field6.clear();
            field7.clear();
            field8.clear();
            field9.clear();
            field10.clear();
            field11.clear();
            field12.clear();
            field13.clear();

        });

        hb.getChildren().addAll(field1,field2,field3,field4,field5,field6,field7,field8,field9,field10,field11,field12,field13);
        hb.setSpacing(3);

        final VBox vBox=new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10,0,0,10));
        vBox.getChildren().addAll(label,table,hb);

        ((Group)scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();


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


