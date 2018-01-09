package client.Presentation.AccountantUI.AccountManagement;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.Presentation.tools.NOgenerator;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.logVO;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import server.Po.coPO;
import shared.praseDouble;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @discription: UI for accountant, 账户管理
 * @author: yotta
 */


public class AccountManagementUI {

   //数据列表
    private final ObservableList<Account> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();

    FinancialAccountController controller = new FinancialAccountController();
    private NOgenerator nogenerator = new NOgenerator();


    //start函数

    public VBox start(String staff) throws Exception {
        TableView<Account> table = new TableView<>();

        final Label label = new Label("账户列表");
        label.setFont(new Font("Arial", 20));

        //账户列表及其列
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

        Alert modifyConfir = new Alert(Alert.AlertType.CONFIRMATION,"确认修改此账户?");

/////////////////////////////////////////////////////////////////////////////////
        //ID列
        IDCol.setMinWidth(200);
        IDCol.setCellValueFactory(
                param -> param.getValue().accountID);
        IDCol.setCellFactory(cellFactory);

/////////////////////////////////////////////////////////////////////////////////
        //名称列
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
                    logset(staff);
                });




/////////////////////////////////////////////////////////////////////////////////
        //金额列
        MoneyCol.setMinWidth(200);
        MoneyCol.setCellValueFactory(
                param -> param.getValue().money);
        MoneyCol.setCellFactory(cellFactory);
        MoneyCol.setOnEditCommit(
                (CellEditEvent<Account, String> t) -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setmoney(t.getNewValue());
                    Account acc = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    modifyAccount(acc);
                    logset(staff);

                });

//////////////////////////////////////////////////////////////////////////////////
        //删除列
        delCol.setCellFactory((col) -> {
            TableCell<Account, String> cell = new TableCell<Account, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button();
                        delBtn.setText("删除");
                        this.setGraphic(delBtn);



                        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"确认删除此账户?");




                        delBtn.setStyle("-fx-background-color: transparent;-fx-text-fill: red");
                        delBtn.setUnderline(true);
                        delBtn.setOnAction((ActionEvent)->{
                            Optional<ButtonType> result = confirmation.showAndWait();
                            if(result.isPresent() && result.get() == ButtonType.OK){

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
                                    link.getRemoteHelper().getLog().addObject(log, 13);
                                } catch (RemoteException | InvocationTargetException | IllegalAccessException | IntrospectionException e) {
                                    e.printStackTrace();
                                }

                                System.out.println("删除成功");
                                FinancialAccountController financialAccountController = new FinancialAccountController();
                                try {
                                    financialAccountController.deleteAccount(co);
                                } catch (RemoteException e3) {
                                    e3.printStackTrace();
                                }
                                System.out.println("弹窗测试！");
                            }
                        });

                    }
                }

            };
            return cell;
        });

//////////////////////////////////////////////////////////////////////////////////////
        //账户列表初始化
        try {
            List<coPO> list = controller.show();
            for (coPO aList : list) {
                coVO newco = controller.PoToVo(aList);
                Account account = controller.VoToAccount(newco);
                data.add(account);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol, MoneyCol, delCol);


        Label space = new Label("                                                                                                           ");
        space.setStyle("-fx-background-color: transparent;-fx-border-color: transparent");

        //搜索区域
        TextField search = new TextField();
        search.setMinWidth(90);
        search.setStyle("-fx-border-radius: 40;-fx-background-color: transparent;-fx-border-color: black");
        search.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    String accountInfor = search.getText();
                    ArrayList<Account> list = null;
                    try {
                        list = controller.findAccount(accountInfor);
                    } catch (RemoteException e1) {
                        e1.printStackTrace();
                    }
                    data.clear();
                    data.addAll(list);
                }
            }
        });


        HBox newhb = new HBox();
        newhb.setSpacing(5);
        newhb.setPadding(new Insets(10, 0, 0, 10));
        newhb.getChildren().addAll(label, space, search);

        //新增账户
        final Button addButton = new Button();
        addButton.setGraphic(new ImageView(new Image("添加.png")));
        addButton.setStyle("-fx-background-color: transparent");
        addButton.setOnAction((ActionEvent e) -> {
            Stage stage1 = new Stage();
            stage1.setWidth(350);
            stage1.setHeight(300);
            stage1.setX(230);
            stage1.setY(260);
            stage1.initStyle(StageStyle.UNDECORATED);

            VBox vb = new VBox();

            HBox box1 = new HBox();
            box1.setSpacing(1);
            Label add = new Label("账户名称:");
            add.setStyle("-fx-border-color: transparent;-fx-background-color: transparent;-fx-alignment: center;-fx-font-size: 20");
            TextField addName = new TextField();
            addName.setMinWidth(90);
            addName.setStyle("-fx-border-color: transparent;-fx-background-color: transparent");
            box1.getChildren().addAll(add, addName);

            HBox box2 = new HBox();
            box2.setSpacing(1);
            Label money = new Label("账户金额:");
            money.setStyle("-fx-border-color: transparent;-fx-background-color: transparent;-fx-alignment: center;-fx-font-size:20");
            TextField addMoney = new TextField();
            addMoney.setMinWidth(90);
            addMoney.setStyle("-fx-border-color: transparent;-fx-background-color: transparent");
            box2.getChildren().addAll(money, addMoney);

            Line line1 = new Line(0, 100, 400, 100);
            Line line2 = new Line(0, 200, 400, 200);

            Button addb = new Button("增加账户");
            addb.setMinSize(150, 30);
            addb.setStyle("-fx-text-fill: black;-fx-background-color: darkgray;-fx-border-color:transparent;-fx-alignment: center");
            Button cancelb = new Button("取消");
            cancelb.setMinSize(150, 30);
            cancelb.setStyle("-fx-text-fill: black;-fx-background-color: darkgray;-fx-border-color: transparent;-fx-alignment: center");
            vb.getChildren().addAll(box1, line1, box2, line2, addb, cancelb);
            vb.setSpacing(10);
            vb.setAlignment(Pos.CENTER);
            vb.setPadding(new Insets(10, 10, 10, 10));
            Scene s = new Scene(vb, 500, 500);
            s.getStylesheets().add("background.css");

            stage1.setScene(s);
            stage1.show();
            //增加账户  监听

            Alert warning = new Alert(Alert.AlertType.WARNING,"");
            addb.setOnAction((ActionEvent b1) -> {
                if(addName.getText()==null||addMoney.getText()==null||
                        addName.getText().isEmpty()||addMoney.getText().isEmpty()){
                    warning.setContentText("内容不能为空！");
                    warning.showAndWait();
                }
                else if(!isNumeric(addMoney.getText())){
                    warning.setContentText("输入金额应为数字！");
                    warning.showAndWait();
                }
                else{
                    try {
                        String ID = "YHZH-" + nogenerator.generate(10);
                        Account newaccount = new Account(
                                ID,
                                addName.getText(),
                                addMoney.getText());
                        data.add(newaccount);
                        coVO co = new coVO();
                        co.setKeyno(newaccount.getaccountID());
                        co.setKeyname(newaccount.getaccountName());
                        co.setSumall(praseDouble.prase(newaccount.getmoney()));
//断言
                        assert co.getKeyname()!=null;
                        assert co.getSumall()!=null;
                        controller.addAccount(co);

                        logVO log = new logVO();
                        log.setOperatorno(staff);
                        log.setOpno("增加账户");
                        link.getRemoteHelper().getLog().addObject(log, 13);


                    } catch (RemoteException | IntrospectionException | IllegalAccessException | InvocationTargetException e1) {
                        e1.printStackTrace();
                    }
                    addName.clear();
                    addMoney.clear();
                    stage1.close();
                }


            });

            cancelb.setOnAction((ActionEvent b2) -> {
                stage1.close();
            });
        });

        //刷新账户列表
        Button refresh = new Button();
        refresh.setGraphic(new ImageView(new Image("大刷新.png")));
        refresh.setStyle("-fx-background-color: transparent");
        refresh.setOnAction(e -> {
            refresh();
        });

        hb.getChildren().addAll(addButton, refresh);//addID,
        hb.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(3);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(newhb, table, hb);
        vbox.setMaxSize(1000, 800);

        vbox.getStylesheets().add("table.css");
        table.getStyleClass().add("table-view");
        return vbox;

    }

    private void logset(String staff) {
        try {
            logVO log = new logVO();
            log.setOperatorno(staff);
            log.setKeyjob("修改账户");
            link.getRemoteHelper().getLog().addObject(log, 13);
        } catch (RemoteException | InvocationTargetException | IllegalAccessException | IntrospectionException e) {
            e.printStackTrace();
        }
    }

//刷新函数
    private void refresh() {
        try {
            List<coPO> list = controller.show();
            data.clear();
            for (coPO aList : list) {
                coVO newco = controller.PoToVo(aList);
                Account account = controller.VoToAccount(newco);
                data.add(account);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

//修改函数
    private void modifyAccount(Account acc) {
        coVO vo = new coVO();
        vo.setKeyname(acc.getaccountName());
        vo.setKeyno(acc.getaccountID());
        vo.setSumall(Double.parseDouble(acc.getmoney()));
        try {
            controller.modifyAccount(vo);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
//是否为数字
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

//单元格可修改
    public class EditingCell extends TableCell<Account, String> {

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
            this.setTextFill(Color.BLACK);
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
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.focusedProperty().addListener(
                    (ObservableValue<? extends Boolean> arg0,
                     Boolean arg1, Boolean arg2) -> {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                    });
        }

        private String getString() {
            return getItem() == null ? "" : getItem();
        }
    }
}
