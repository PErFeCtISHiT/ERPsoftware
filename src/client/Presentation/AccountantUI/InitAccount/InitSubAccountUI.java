package client.Presentation.AccountantUI.InitAccount;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class InitSubAccountUI extends Application {

    private final TableView<Account> table = new TableView<>();
    private final ObservableList<Account> data =
            FXCollections.observableArrayList(
                    new Account("A", "B", "C"),
                    new Account("Q", "W", "E"));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("账户管理");
        stage.setWidth(650);
        stage.setHeight(550);

        final Label label = new Label("账户列表");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn<Account, String> IDCol =
                new TableColumn<>("账户编号");
        TableColumn<Account, String> NameCol =
                new TableColumn<>("账户名称");
        TableColumn<Account, String> MoneyCol =
                new TableColumn<>("账户余额");
        TableColumn<Account, String> delCol =
                new TableColumn<>("是否删除");

        IDCol.setMinWidth(100);
        IDCol.setCellValueFactory(
                param -> param.getValue().accountID);



        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().accountName);


        MoneyCol.setMinWidth(200);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);



        delCol.setCellFactory((col) -> {
            TableCell<Account, String> cell = new TableCell<Account, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            data.remove(this.getIndex());
                            System.out.println("删除成功");

                        });
                    }
                }

            };
            return cell;
        });



        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol, MoneyCol,delCol);

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("accountID");
        addFirstName.setMaxWidth(IDCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(NameCol.getPrefWidth());
        addLastName.setPromptText("accountName");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(MoneyCol.getPrefWidth());
        addEmail.setPromptText("money");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Account newaccount = new Account(
                    addFirstName.getText(),
                    addLastName.getText(),
                    addEmail.getText());
            data.add(newaccount);
            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
        });

        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Account {

        private final SimpleStringProperty accountID;
        private final SimpleStringProperty accountName;
        private final SimpleStringProperty money;

        private Account(String fName, String lName, String email) {
            this.accountID = new SimpleStringProperty(fName);
            this.accountName = new SimpleStringProperty(lName);
            this.money = new SimpleStringProperty(email);
        }

        public String getaccountID() {
            return accountID.get();
        }

        public void setaccountID(String fName) {
            accountID.set(fName);
        }

        public String getaccountName() {
            return accountName.get();
        }

        public void setaccountName(String fName) {
            accountName.set(fName);
        }

        public String getmoney() {
            return money.get();
        }

        public void setmoney(String fName) {
            money.set(fName);
        }
    }

}

