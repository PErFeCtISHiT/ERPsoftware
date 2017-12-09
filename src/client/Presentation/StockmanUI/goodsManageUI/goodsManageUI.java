package client.Presentation.StockmanUI.goodsManageUI;
import client.BL.Stockman.StockmanGoodsbl.Goods;
import client.BL.Stockman.StockmanGoodsbl.GoodsController;
import client.Presentation.NOgenerator.NOgenerator;
import client.Presentation.StockmanUI.goodsExceptionUI.goodsExceptionUI;
import client.Presentation.StockmanUI.goodsWarningUI.goodsWarningUI;
import client.Vo.goodsVO;
import client.Vo.stockGoodsVO;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafx.util.StringConverter;
import server.Po.goodsPO;
import shared.praseDouble;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class goodsManageUI {
    private ObservableList<Goods> data;
    private String kinds;

    private GoodsController goodsController = new GoodsController();
    int warningnum = 100;





    public VBox start(String kinds,String staff) throws RemoteException {
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
                    String.valueOf(i.getWarningnum()),
                    String .valueOf(i.getKeybatch()),
                    String .valueOf(i.getBatchno()),
                    String .valueOf(i.getDat()));
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
                    Double addnum = Double.valueOf(t.getNewValue()) - Double.valueOf(t.getOldValue());
                    newgoods.setGoodsNum(t.getNewValue());
                    goodsVO vo = new goodsVO();
                    vo.setKinds(kinds);
                    vo.setKeyno(newgoods.getGoodsID());
                    vo.setKeyname(newgoods.getGoodsName());
                    vo.setKeymodel(newgoods.getGoodsModel());
                    vo.setNum(praseDouble.prase(newgoods.getGoodsNum()) - addnum);
                    vo.setInprice(praseDouble.prase(newgoods.getGoodsInprice()));
                    vo.setOutprice(praseDouble.prase(newgoods.getGoodsOutprice()));
                    vo.setReceprice(praseDouble.prase(newgoods.getGoodsReceinprice()));
                    vo.setReceoutprice(praseDouble.prase(newgoods.getGoodsReceoutprice()));
                    vo.setWarningnum(praseDouble.prase(newgoods.getGoodsWarningnum()));
                    modifygoods(newgoods);


                    stockGoodsVO stockGoodsVO = new stockGoodsVO();

                    try {
                        stockGoodsVO.setKeyno("RKD" + "-" + NOgenerator.generate(19));
                    } catch (RemoteException | IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    stockGoodsVO.setGoodsname(vo.getKeyname());
                    stockGoodsVO.setGoodsno(vo.getKeyno());
                    stockGoodsVO.setKeynum(addnum);
                    stockGoodsVO.setSumall(addnum * vo.getReceprice());
                    try {
                        goodsController.stockGoods(stockGoodsVO);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    goodsExceptionUI goodsExceptionUI = new goodsExceptionUI();
                    goodsExceptionUI.systemWarning(vo,staff,addnum);


                });

        inpriceCol.setMinWidth(50);
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

        outpriceCol.setMinWidth(50);
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

        receinpriceCol.setMinWidth(50);
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

        receoutpriceCol.setMinWidth(50);
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

        warningnumcol.setMinWidth(50);
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

                        stockGoodsVO stockGoodsVO = new stockGoodsVO();

                        try {
                            stockGoodsVO.setKeyno("RKD" + "-" + NOgenerator.generate(19));
                        } catch (RemoteException | IntrospectionException | IllegalAccessException | InvocationTargetException e1) {
                            e1.printStackTrace();
                        }
                        stockGoodsVO.setGoodsname(vo.getKeyname());
                        stockGoodsVO.setGoodsno(vo.getKeyno());
                        stockGoodsVO.setKeynum(-vo.getNum());
                        stockGoodsVO.setSumall(-vo.getNum() * vo.getReceprice());
                        try {
                            goodsController.stockGoods(stockGoodsVO);
                        } catch (RemoteException e1) {
                            e1.printStackTrace();
                        }

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
                            goodsWarningUI.start(goodsVO,staff);
                        } catch (RemoteException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }

        });



        table.setItems(data);
        table.getColumns().addAll(IDCol, NameCol,ModelCol,NumCol,inpriceCol,outpriceCol,receinpriceCol,receoutpriceCol,warningnumcol,delCol,warningCol);


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

        final TextField addbatch = new TextField();
        addbatch.setMaxWidth(ModelCol.getPrefWidth());
        addbatch.setPromptText("批次");

        final TextField addbatchno = new TextField();
        addbatchno.setMaxWidth(ModelCol.getPrefWidth());
        addbatchno.setPromptText("批号");

        DatePicker makeDate = new DatePicker();
        String pattern = "yyyyMMdd";
        makeDate.setPromptText(pattern);
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        makeDate.setConverter(converter);




        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            String no = "";
            try {
                no = NOgenerator.generate(0);
            } catch (RemoteException | IllegalAccessException | InvocationTargetException | IntrospectionException e1) {
                e1.printStackTrace();
            }
            String type = "SP";
            no = type + "-" + no;
            String dat = "";
            if(makeDate.getValue() != null)
                dat = makeDate.getValue().toString();
            else
                dat = null;
            Goods newgoods = new Goods(
                    no,
                    addName.getText(),
                    addModel.getText(),
                    addNum.getText(),
                    addinprice.getText(),
                    addoutprice.getText(),
                    addreceinprice.getText(),
                    addreceoutprice.getText(),
                    "100", addbatch.getText(), addbatchno.getText(), dat);

            data.add(newgoods);
            goodsVO vo = new goodsVO();
            vo.setKeyno(no);
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
            vo.setKeybatch(newgoods.getBatch());
            vo.setBatchno(newgoods.getBatchno());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date= null;
            try {
                date = sdf.parse(makeDate.getValue().toString());
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            vo.setDat(sqldate);
            try {
                goodsController.addGoods(vo);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            stockGoodsVO stockGoodsVO = new stockGoodsVO();

            try {
                stockGoodsVO.setKeyno("RKD" + "-" + NOgenerator.generate(19));
            } catch (RemoteException | IntrospectionException | IllegalAccessException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
            stockGoodsVO.setGoodsname(vo.getKeyname());
            stockGoodsVO.setGoodsno(vo.getKeyno());
            stockGoodsVO.setKeynum(vo.getNum());
            stockGoodsVO.setSumall(vo.getNum() * vo.getReceprice());
            try {
                goodsController.stockGoods(stockGoodsVO);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }

            addName.clear();
            addModel.clear();
            addNum.clear();
            addinprice.clear();
            addoutprice.clear();
            addreceinprice.clear();
            addreceoutprice.clear();
            addbatch.clear();
            addbatchno.clear();
        });

        hb.getChildren().addAll( addName, addModel,addNum,addinprice,addoutprice,addreceinprice,addreceoutprice,addbatch,addbatchno,makeDate, addButton);
        hb.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        return vbox;
    }



    public static class EditingCell extends TableCell<Goods, String> {

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
