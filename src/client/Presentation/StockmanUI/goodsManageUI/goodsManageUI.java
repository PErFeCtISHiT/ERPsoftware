package client.Presentation.StockmanUI.goodsManageUI;
import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.BL.Stockman.StockmanGoodsbl.Goods;
import client.BL.Stockman.StockmanGoodsbl.GoodsController;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.goodsVO;
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
import server.Po.goodsPO;

import java.rmi.RemoteException;
import java.util.List;

public class goodsManageUI extends Application {
    GoodsController goodsController = new GoodsController();
    private final TableView<Goods> table = new TableView<>();
    private final ObservableList<Goods> data =

            FXCollections.observableArrayList();

    final HBox hb = new HBox();

    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws RemoteException {
        Scene scene = new Scene(new Group());
        stage.setTitle("商品管理");
        stage.setWidth(1000);
        stage.setHeight(550);

        /**
        *@author:pis
        *@description: 显示初始商品,kind由上一个界面传入
        *@date: 15:57 2017/12/2
        */
        List<goodsPO> originGoods = (List<goodsPO>) goodsController.findByKind("ferry");
        for(goodsPO i : originGoods){
            Goods newgoods = new Goods(i.getKeyno(),
                    i.getKeyname(),
                    i.getKeymodel(),
                    String.valueOf(i.getNum()),
                    String.valueOf(i.getInprice()),
                    String.valueOf(i.getOutprice()),
                    String.valueOf(i.getReceprice()),
                    String.valueOf(i.getReceoutprice()));
            data.add(newgoods);

        }
        final Label label = new Label("商品列表");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        Callback<TableColumn<Goods, String>,
                TableCell<Goods, String>> cellFactory
                = (TableColumn<Goods, String> p) -> new EditingCell() ;

        TableColumn<Goods, String> IDCol =
                new TableColumn<>("编号");
        TableColumn<Goods, String> NameCol =
                new TableColumn<>("名称");
        TableColumn<Goods, String> ModelCol =
                new TableColumn<>("型号");
        TableColumn<Goods,String> NumCol =
                new TableColumn<>("数量");
        TableColumn<Goods,String> inpriceCol =
                new TableColumn<>("进价");
        TableColumn<Goods,String> outpriceCol =
                new TableColumn<>("零售价");
        TableColumn<Goods,String> receinpriceCol =
                new TableColumn<>("最近进价");
        TableColumn<Goods,String> receoutpriceCol =
                new TableColumn<>("最近零售价");
        TableColumn<Goods, String> delCol =
                new TableColumn<>("是否删除");

        IDCol.setMinWidth(100);
        IDCol.setCellValueFactory(
                param -> param.getValue().goodsID);
        IDCol.setCellFactory(cellFactory);
        IDCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsID(t.getNewValue());
                });


        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().goodsName);
        NameCol.setCellFactory(cellFactory);
        NameCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsName(t.getNewValue());
                });

        ModelCol.setMinWidth(100);
        ModelCol.setCellValueFactory(
                param -> param.getValue().goodsModel);
        ModelCol.setCellFactory(cellFactory);
        ModelCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsModel(t.getNewValue());
                });

        NumCol.setMinWidth(100);
        NumCol.setCellValueFactory(
                param -> param.getValue().goodsNum);
        NumCol.setCellFactory(cellFactory);
        NumCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsNum(t.getNewValue());
                });

        inpriceCol.setMinWidth(100);
        inpriceCol.setCellValueFactory(
                param -> param.getValue().goodsInprice);
        inpriceCol.setCellFactory(cellFactory);
        inpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsInprice(t.getNewValue());
                });

        outpriceCol.setMinWidth(100);
        outpriceCol.setCellValueFactory(
                param -> param.getValue().goodsOutprice);
        outpriceCol.setCellFactory(cellFactory);
        outpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsOutprice(t.getNewValue());
                });

        receinpriceCol.setMinWidth(100);
        receinpriceCol.setCellValueFactory(
                param -> param.getValue().goodsReceinprice);
        receinpriceCol.setCellFactory(cellFactory);
        receinpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsReceinprice(t.getNewValue());
                });

        receoutpriceCol.setMinWidth(100);
        receoutpriceCol.setCellValueFactory(
                param -> param.getValue().goodsReceoutprice);
        receoutpriceCol.setCellFactory(cellFactory);
        receoutpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGoodsReceoutprice(t.getNewValue());
                });


        delCol.setCellFactory((col) -> {
            TableCell<Goods, String> cell = new TableCell<Goods, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("删除商品");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            goodsVO vo = new goodsVO();
                            vo.setKeyno(data.get(this.getIndex()).getGoodsID());
                            data.remove(this.getIndex());
                            try {
                                goodsController.deleteGoods(vo);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }

            };
            return cell;
        });



        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol,ModelCol,NumCol,inpriceCol,outpriceCol,receinpriceCol,receoutpriceCol,delCol);

        final TextField addID = new TextField();
        addID.setPromptText("ID");
        addID.setMaxWidth(IDCol.getPrefWidth());

        final TextField addName = new TextField();
        addName.setMaxWidth(NameCol.getPrefWidth());
        addName.setPromptText("Name");

        final TextField addModel = new TextField();
        addModel.setMaxWidth(ModelCol.getPrefWidth());
        addModel.setPromptText("Model");

        final TextField addNum = new TextField();
        addNum.setMaxWidth(ModelCol.getPrefWidth());
        addNum.setPromptText("Num");

        final TextField addinprice = new TextField();
        addinprice.setMaxWidth(ModelCol.getPrefWidth());
        addinprice.setPromptText("进价");

        final TextField addoutprice = new TextField();
        addoutprice.setMaxWidth(ModelCol.getPrefWidth());
        addoutprice.setPromptText("零售价");

        final TextField addreceinprice = new TextField();
        addreceinprice.setMaxWidth(ModelCol.getPrefWidth());
        addreceinprice.setPromptText("最近进价");

        final TextField addreceoutprice = new TextField();
        addreceoutprice.setMaxWidth(ModelCol.getPrefWidth());
        addreceoutprice.setPromptText("最近零售价");

/**
*todo:父类信息传入，设置商品父类
*/
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Goods newgoods = new Goods(
                    addID.getText(),
                    addName.getText(),
                    addModel.getText(),
                    addNum.getText(),
                    addinprice.getText(),
                    addoutprice.getText(),
                    addreceinprice.getText(),
                    addreceoutprice.getText());
            data.add(newgoods);
            goodsVO vo = new goodsVO();
            vo.setKeyno(newgoods.getGoodsID());
            vo.setKeyname(newgoods.getGoodsName());
            vo.setKeymodel(newgoods.getGoodsModel());
            vo.setNum(Long.parseLong(newgoods.getGoodsNum()));
            vo.setInprice(Long.parseLong(newgoods.getGoodsInprice()));
            vo.setOutprice(Long.parseLong(newgoods.getGoodsOutprice()));
            vo.setReceprice(Long.parseLong(newgoods.getGoodsReceinprice()));
            vo.setReceoutprice(Long.parseLong(newgoods.getGoodsReceoutprice()));
            try {
                goodsController.addGoods(vo);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            addID.clear();
            addName.clear();
            addModel.clear();
            addNum.clear();
            addinprice.clear();
            addoutprice.clear();
            addreceinprice.clear();
            addreceoutprice.clear();
        });

        hb.getChildren().addAll(addID, addName, addModel,addNum,addinprice,addoutprice,addreceinprice,addreceoutprice, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }



    class EditingCell extends TableCell<Goods, String> {

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
