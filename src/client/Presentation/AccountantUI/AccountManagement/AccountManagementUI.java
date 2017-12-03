package client.Presentation.AccountantUI.AccountManagement;
import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.RMI.link;
import client.Vo.coVO;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.rmi.RemoteException;
import java.util.List;

public class AccountManagementUI extends Application {

    private final TableView<Account> table = new TableView<>();
    private final ObservableList<Account> data =
            FXCollections.observableArrayList(
                    new Account("A", "B", "C"),
                    new Account("Q", "W", "E")
            );
    final HBox hb = new HBox();


    FinancialAccountController controller  = new FinancialAccountController();
    public static void main(String[] args) {
        link.linktoServer();
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

        Callback<TableColumn<Account, String>,
                TableCell<Account, String>> cellFactory
                = (TableColumn<Account, String> p) -> new EditingCell();

        TableColumn<Account, String> IDCol =
                new TableColumn<>("账户编号");
        TableColumn<Account, String> NameCol =
                new TableColumn<>("账户名称");
        TableColumn<Account, String> MoneyCol =
                new TableColumn<>("账户余额");
        TableColumn<Account, String> delCol =
                new TableColumn<>("是否删除");

/////////////////////////////////////////////////////////////////////////////////修改传递
        IDCol.setMinWidth(100);
        IDCol.setCellValueFactory(
                param -> param.getValue().accountID);
        IDCol.setCellFactory(cellFactory);
        IDCol.setOnEditCommit(
                (CellEditEvent<Account, String> t) -> {
                    ((Account) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setaccountID(t.getNewValue());

                    Account acc = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    modifyAccount(acc);
                });

/////////////////////////////////////////////////////////////////////////////////修改传递
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().accountName);
        NameCol.setCellFactory(cellFactory);
        NameCol.setOnEditCommit(
                (CellEditEvent<Account, String> t) -> {
                    ((Account) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setaccountName(t.getNewValue());
                    Account acc = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    modifyAccount(acc);

                });
/////////////////////////////////////////////////////////////////////////////////修改传递
        MoneyCol.setMinWidth(200);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);
        MoneyCol.setCellFactory(cellFactory);
        MoneyCol.setOnEditCommit(
                (CellEditEvent<Account, String> t) -> {
                    ((Account) t.getTableView().getItems().get(t.getTablePosition().getRow())).setmoney(t.getNewValue());
                    Account acc = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    modifyAccount(acc);
                });

//////////////////////////////////////////////////////////////////////////////////删除传递
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
                            coVO co = new coVO();
                            co.setKeyname("456");
                            co.setSumall((double) 500);
                            data.remove(this.getIndex());
                            System.out.println("删除成功");
                            FinancialAccountController financialAccountController = new FinancialAccountController();
                            try {
                                financialAccountController.deleteAccount(co);
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        });
                    }
                }

            };
            return cell;
        });

//////////////////////////////////////////////////////////////////////////////////////开始获取数据
        try {
            List<coVO> list =controller.show();
            for (int i=0;i<list.size();i++){
                coVO newco = list.get(i);
                Account account = controller.VoToAccount(newco);
                data.add(account);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }



        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol, MoneyCol,delCol);

        final TextField addID= new TextField();
        addID.setPromptText("accountID");
        addID.setMaxWidth(IDCol.getPrefWidth());
        final TextField addName = new TextField();
        addName.setMaxWidth(NameCol.getPrefWidth());
        addName.setPromptText("accountName");
        final TextField addMoney = new TextField();
        addMoney.setMaxWidth(MoneyCol.getPrefWidth());
        addMoney.setPromptText("money");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Account newaccount = new Account(
                    addID.getText(),
                    addName.getText(),
                    addMoney.getText());
            data.add(newaccount);
            coVO co = new coVO();
            co.setKeyno(newaccount.getaccountID());
            co.setKeyname(newaccount.getaccountName());
            co.setSumall(Double.parseDouble(newaccount.getmoney()));
            try {
                controller.addAccount(co);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            addID.clear();
            addName.clear();
            addMoney.clear();
        });

        hb.getChildren().addAll(addID, addName, addMoney, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }



    class EditingCell extends TableCell<Account, String> {

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


    private void modifyAccount(Account acc){
        coVO vo = new coVO();
        vo.setKeyname(acc.getaccountName());
        vo.setKeyno(acc.getaccountID());
        vo.setSumall(Double.parseDouble(acc.getmoney()));
        try {
            controller.modifyAccount(vo);
        }catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
