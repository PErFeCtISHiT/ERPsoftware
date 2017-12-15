package client.Presentation.AccountantUI.AccountManagement;
import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.Presentation.NOgenerator.NOgenerator;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.logVO;
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

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import server.Po.coPO;
import server.Po.logPO;
import shared.*;

public class AccountManagementUI {


    private final ObservableList<Account> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();


    FinancialAccountController controller  = new FinancialAccountController();
    private NOgenerator nogenerator = new NOgenerator();


    public VBox start(String staff) throws Exception {
        TableView<Account> table = new TableView<>();
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("账户管理");
        stage.setWidth(750);
        stage.setHeight(550);
//        Label work = new Label("工作目录");

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
        IDCol.setMinWidth(200);
        IDCol.setCellValueFactory(
                param -> param.getValue().accountID);

/////////////////////////////////////////////////////////////////////////////////修改传递
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                param -> param.getValue().accountName);
        NameCol.setCellFactory(cellFactory);
        NameCol.setOnEditCommit(
                (CellEditEvent<Account, String> t) -> {
                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setaccountName(t.getNewValue());
                    Account acc = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    modifyAccount(acc);
                    try {
                        logVO log = new logVO();
                        log.setOperatorno(staff);
                        log.setKeyjob("修改账户");
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
/////////////////////////////////////////////////////////////////////////////////修改传递
        MoneyCol.setMinWidth(200);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);
        MoneyCol.setCellFactory(cellFactory);
        MoneyCol.setOnEditCommit(
                (CellEditEvent<Account, String> t) -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setmoney(t.getNewValue());
                    Account acc = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    modifyAccount(acc);
                    try {
                        logVO log = new logVO();
                        log.setOperatorno(staff);
                        log.setKeyjob("修改账户");
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
                            co.setKeyname("");
                            co.setSumall((double) 0.0);
                            co.setKeyno(data.get(this.getIndex()).getaccountID().toString());
                            System.out.println(data.get(this.getIndex()).getaccountID().toString());
                            data.remove(this.getIndex());
                            try {
                                logVO log = new logVO();
                                log.setOperatorno(staff);
                                log.setOpno("删除账户");
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
            List<coPO> list =controller.show();
            for (int i=0;i<list.size();i++){
                coVO newco = controller.PoToVo(list.get(i));
                Account account = controller.VoToAccount(newco);
                data.add(account);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }



        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol, MoneyCol,delCol);

//        final TextField addID= new TextField();
//        addID.setEditable(false);
//        addID.setPromptText("编号自动生成");
//        addID.setMaxWidth(IDCol.getPrefWidth());
//        final Label addID = new Label("编号自动生成");
        final TextField addName = new TextField();
        addName.setMaxWidth(NameCol.getPrefWidth());
        addName.setPromptText("账户名称");
        final TextField addMoney = new TextField();
        addMoney.setMaxWidth(MoneyCol.getPrefWidth());
        addMoney.setPromptText("账户余额");


        final TextField search = new TextField();
        search.setMaxWidth(NameCol.getPrefWidth());
        search.setPromptText("搜索关键词");
        final Button searchButton = new Button("搜索账户");
        searchButton.setOnAction((ActionEvent e) -> {
            String accountInfor = search.getText();
            ArrayList<Account> list = null;
            try {
                list = controller.findAccount(accountInfor);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            data.clear();
            data.addAll(list);
        });

        HBox newhb = new HBox();
        newhb.setSpacing(5);
        newhb.setPadding(new Insets(10, 0, 0, 10));
        newhb.getChildren().addAll(label, search, searchButton);


        final Button addButton = new Button("添加账户");
        addButton.setOnAction((ActionEvent e) -> {
            try {
                String ID = "YHZH-"+nogenerator.generate(10);
                Account newaccount = new Account(
                        ID,
                        addName.getText(),
                        addMoney.getText());
                data.add(newaccount);
                coVO co = new coVO();
                co.setKeyno(newaccount.getaccountID());
                co.setKeyname(newaccount.getaccountName());
                co.setSumall(praseDouble.prase(newaccount.getmoney()));
                controller.addAccount(co);

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
//            addID.clear();
            addName.clear();
            addMoney.clear();
        });

        final Button refresh = new Button("刷新列表");
        refresh.setOnAction(e -> {
            refresh();
        });

        hb.getChildren().addAll(addName, addMoney, addButton,refresh);//addID,
        hb.setSpacing(3);

        final VBox vbox = new VBox();
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
        try {
            List<coPO> list =controller.show();
            data.clear();
            for (int i=0;i<list.size();i++){
                coVO newco = controller.PoToVo(list.get(i));
                Account account = controller.VoToAccount(newco);
                data.add(account);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
