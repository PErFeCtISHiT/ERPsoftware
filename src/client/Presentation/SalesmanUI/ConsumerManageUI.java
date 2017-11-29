package client.Presentation.SalesmanUI;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Created by Leonarda on 2017/11/29.
 */
public class ConsumerManageUI extends Application {
    private final TableView<Consumer> table=new TableView<>();
    private final ObservableList<Consumer> data=
            FXCollections.observableArrayList(
                    new Consumer(),
                    new Consumer()
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
        TableColumn<Consumer,Integer> level=new TableColumn<>("级别");
        TableColumn<Consumer,String> name=new TableColumn<>("姓名");

    }

    public static class Consumer{

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


