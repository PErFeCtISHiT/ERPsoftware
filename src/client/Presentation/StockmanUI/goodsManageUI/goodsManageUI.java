package client.Presentation.StockmanUI.goodsManageUI;
import client.BL.Stockman.StockmanGoodsbl.Goods;
import client.BL.Stockman.StockmanGoodsbl.GoodsController;
import client.Presentation.StockmanUI.goodsWarningUI.goodsWarningUI;
import client.RMI.link;
import client.Vo.goodsVO;
import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import server.Po.goodsPO;
import shared.praseDouble;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.List;

public class goodsManageUI {
    private ObservableList<Goods> data;
    private String kinds;

    private GoodsController goodsController = new GoodsController();
    /**
    *todo:警戒数量，报警
    */
    int warningnum = 100;





    public VBox start(String kinds) throws RemoteException {
        this.kinds = kinds;

        TableView<Goods> table = new TableView<>();
        data =

                FXCollections.observableArrayList();

        HBox hb = new HBox();




        List<goodsPO> originGoods = (List<goodsPO>) goodsController.findByKind(kinds);
        for(goodsPO i : originGoods){
            Goods newgoods = new Goods(i.getKeyno(),
                    i.getKeyname(),
                    i.getKeymodel(),
                    String.valueOf(i.getNum()),
                    String.valueOf(i.getInprice()),
                    String.valueOf(i.getOutprice()),
                    String.valueOf(i.getReceprice()),
                    String.valueOf(i.getReceoutprice()),
                    String.valueOf(i.getWarningnum()));
            data.add(newgoods);

        }
        final Label label = new Label(kinds);
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
        TableColumn<Goods,String> warningnumcol =
                new TableColumn<>("警戒数量");
        TableColumn<Goods, String> delCol =
                new TableColumn<>("是否删除");
        TableColumn<Goods,String> warningCol =
                new TableColumn<>("库存报警");

        IDCol.setMinWidth(200);
        IDCol.setCellValueFactory(
                param -> param.getValue().goodsID);
        IDCol.setCellFactory(cellFactory);
        IDCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsID(t.getNewValue());
                    modifygoods(newgoods);
                });


        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                param -> param.getValue().goodsName);
        NameCol.setCellFactory(cellFactory);
        NameCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsName(t.getNewValue());
                    modifygoods(newgoods);

                });

        ModelCol.setMinWidth(50);
        ModelCol.setCellValueFactory(
                param -> param.getValue().goodsModel);
        ModelCol.setCellFactory(cellFactory);
        ModelCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsModel(t.getNewValue());
                    modifygoods(newgoods);
                });

        NumCol.setMinWidth(50);
        NumCol.setCellValueFactory(
                param -> param.getValue().goodsNum);
        NumCol.setCellFactory(cellFactory);
        NumCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsNum(t.getNewValue());
                    modifygoods(newgoods);
                });

        inpriceCol.setMinWidth(100);
        inpriceCol.setCellValueFactory(
                param -> param.getValue().goodsInprice);
        inpriceCol.setCellFactory(cellFactory);
        inpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsInprice(t.getNewValue());
                    modifygoods(newgoods);
                });

        outpriceCol.setMinWidth(100);
        outpriceCol.setCellValueFactory(
                param -> param.getValue().goodsOutprice);
        outpriceCol.setCellFactory(cellFactory);
        outpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsOutprice(t.getNewValue());
                    modifygoods(newgoods);
                });

        receinpriceCol.setMinWidth(100);
        receinpriceCol.setCellValueFactory(
                param -> param.getValue().goodsReceinprice);
        receinpriceCol.setCellFactory(cellFactory);
        receinpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsReceinprice(t.getNewValue());
                    modifygoods(newgoods);
                });

        receoutpriceCol.setMinWidth(100);
        receoutpriceCol.setCellValueFactory(
                param -> param.getValue().goodsReceoutprice);
        receoutpriceCol.setCellFactory(cellFactory);
        receoutpriceCol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsReceoutprice(t.getNewValue());
                    modifygoods(newgoods);
                });

        warningnumcol.setMinWidth(100);
        warningnumcol.setCellValueFactory(
                param -> param.getValue().goodsWarningnum);
        warningnumcol.setCellFactory(cellFactory);
        warningnumcol.setOnEditCommit(
                (CellEditEvent<Goods, String> t) -> {
                    Goods newgoods =  t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    newgoods.setGoodsWarningnum(t.getNewValue());
                    modifygoods(newgoods);
                });

        delCol.setCellFactory((col) -> new TableCell<Goods, String>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                this.setText(null);
                this.setGraphic(null);

                if (!empty) {
                    Button delBtn = new Button("删除商品");
                    this.setGraphic(delBtn);
                    delBtn.setOnMouseClicked((me) -> {
                        goodsVO vo = createGoodsVO(this);
                        data.remove(this.getIndex());
                        try {
                            goodsController.deleteGoods(vo);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }

        });

        warningCol.setCellFactory((col) -> new TableCell<Goods, String>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                this.setText(null);
                this.setGraphic(null);

                if (!empty) {
                        goodsVO goodsVO = createGoodsVO(this);
                    Button warninglBtn = new Button("报警");
                    if(goodsVO.getWarningnum() < goodsVO.getNum())
                        warninglBtn.setDisable(true);
                    this.setGraphic(warninglBtn);
                    warninglBtn.setOnMouseClicked((me) -> {
                        goodsWarningUI goodsWarningUI = new goodsWarningUI();
                        try {
                            goodsWarningUI.start(goodsVO);
                        } catch (RemoteException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }

        });



        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol,ModelCol,NumCol,inpriceCol,outpriceCol,receinpriceCol,receoutpriceCol,warningnumcol,delCol,warningCol);

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
                    addreceoutprice.getText(),
                    "100");

            data.add(newgoods);
            goodsVO vo = new goodsVO();
            vo.setKinds(kinds);
            vo.setKeyno(newgoods.getGoodsID());
            vo.setKeyname(newgoods.getGoodsName());
            vo.setKeymodel(newgoods.getGoodsModel());
            vo.setNum(praseDouble.prase(newgoods.getGoodsNum()));
            vo.setInprice(praseDouble.prase(newgoods.getGoodsInprice()));
            vo.setOutprice(praseDouble.prase(newgoods.getGoodsOutprice()));
            vo.setReceprice(praseDouble.prase(newgoods.getGoodsReceinprice()));
            vo.setReceoutprice(praseDouble.prase(newgoods.getGoodsReceoutprice()));
            vo.setWarningnum((double) 100);
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

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        return vbox;
    }



    class EditingCell extends TableCell<Goods, String> {

        private TextField textField;

        EditingCell() {
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
            return getItem() == null ? "" : getItem();
        }
    }

    private goodsVO createGoodsVO(TableCell tableCell){
        goodsVO goodsVO = new goodsVO();
        goodsVO.setKeyno(data.get(tableCell.getIndex()).getGoodsID());
        goodsVO.setKinds(kinds);
        goodsVO.setKeyname(data.get(tableCell.getIndex()).getGoodsName());
        goodsVO.setKeymodel(data.get(tableCell.getIndex()).getGoodsModel());
        goodsVO.setNum(praseDouble.prase(data.get(tableCell.getIndex()).getGoodsNum()));
        goodsVO.setInprice(praseDouble.prase(data.get(tableCell.getIndex()).getGoodsInprice()));
        goodsVO.setOutprice(praseDouble.prase(data.get(tableCell.getIndex()).getGoodsOutprice()));
        goodsVO.setReceoutprice(praseDouble.prase(data.get(tableCell.getIndex()).getGoodsReceoutprice()));
        goodsVO.setReceprice(praseDouble.prase(data.get(tableCell.getIndex()).getGoodsReceinprice()));
        goodsVO.setWarningnum(praseDouble.prase(data.get(tableCell.getIndex()).getGoodsWarningnum()));
        return goodsVO;
    }

    private void modifygoods(Goods newgoods){
        goodsVO vo = new goodsVO();
        vo.setKinds(kinds);
        vo.setKeyno(newgoods.getGoodsID());
        vo.setKeyname(newgoods.getGoodsName());
        vo.setKeymodel(newgoods.getGoodsModel());
        vo.setNum(praseDouble.prase(newgoods.getGoodsNum()));
        vo.setInprice(praseDouble.prase(newgoods.getGoodsInprice()));
        vo.setOutprice(praseDouble.prase(newgoods.getGoodsOutprice()));
        vo.setReceprice(praseDouble.prase(newgoods.getGoodsReceinprice()));
        vo.setReceoutprice(praseDouble.prase(newgoods.getGoodsReceoutprice()));
        vo.setWarningnum(praseDouble.prase(newgoods.getGoodsWarningnum()));
        try {
            goodsController.modifyGoods(vo);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
