package client.Presentation.StockmanUI.goodsManageUI;

import client.BL.Stockman.StockmanGoodskindsbl.GoodsKindsController;
import client.Presentation.NOgenerator.NOgenerator;
import client.RMI.link;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.Po.goodskindsPO;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javafx.application.Application.launch;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 14:57 2017/12/2
 */
public class goodsKindsManageUI extends Application{


    private GoodsKindsController goodsKindsController = new GoodsKindsController();

    private static TreeView<String> goodsTreeView;
    private static TreeItem<String> root;

    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("商品分类管理");
        stage.setWidth(1400);
        stage.setHeight(750);

        root = new TreeItem<>();
        root.setExpanded(true);
        goodsTreeView = new TreeView<>(root);
        goodsTreeView.setShowRoot(false);
        showGoodsTree();
        final HBox vbox = new HBox();
        goodsManageUI goodsManageUI = new goodsManageUI();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));


        final HBox buttons = new HBox();
        buttons.setSpacing(5);
        buttons.setPadding(new Insets(10, 0, 0, 10));
        final TextField kindsname = new TextField();
        kindsname.setPromptText("种类名称");
        final Button addbtn = new Button("增加");
        final Button modifybtn = new Button("修改");
        final Button delbtn = new Button("删除");
        buttons.getChildren().addAll(kindsname,addbtn,delbtn,modifybtn);
        delbtn.setDisable(true);
        modifybtn.setDisable(true);
        addbtn.setOnAction(e -> {
            try {
                addkinds(kindsname.getText());
                kindsname.clear();
            } catch (RemoteException | IntrospectionException | IllegalAccessException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
        });
        delbtn.setOnAction(e -> {
            try {
                delkinds();
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });
        modifybtn.setOnAction(e -> {
            try {
                modifykinds(kindsname.getText());
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            kindsname.clear();
        });
        final VBox leftbox = new VBox();
        leftbox.setSpacing(5);
        leftbox.setPadding(new Insets(10, 0, 0, 10));
        leftbox.getChildren().addAll(goodsTreeView,buttons);

        vbox.getChildren().add(leftbox);

        goodsTreeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue.isLeaf()) {
                modifybtn.setDisable(false);
                try {
                    VBox vBox = goodsManageUI.start(newValue.getValue());
                    if(((TableView)vBox.getChildren().get(1)).getItems().size() != 0){
                        addbtn.setDisable(true);
                        delbtn.setDisable(true);
                    }
                    else{
                        addbtn.setDisable(false);
                        delbtn.setDisable(false);
                    }
                    if(vbox.getChildren().size() > 1)
                        vbox.getChildren().remove(1);
                    vbox.getChildren().add(vBox);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else{
                modifybtn.setDisable(false);
                addbtn.setDisable(false);
                if(vbox.getChildren().size() > 1)
                    vbox.getChildren().remove(1);
                if(!newValue.getChildren().isEmpty()){
                    delbtn.setDisable(true);
                }
                else
                    delbtn.setDisable(false);

            }
        });



        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

    }


    /**
    *@author:pis
    *@description: 商品分类的增删改
    *@date: 16:42 2017/12/4
    */
    private void addkinds(String text) throws RemoteException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        goodskindsPO goodskindsPO = new goodskindsPO();
        String no = NOgenerator.generate(1);
        String type = "SPFL";
        goodskindsPO.setKeyno(type + "-" + no);
        goodskindsPO.setKeyname(text);
        String father = goodsTreeView.getSelectionModel().getSelectedItem().getValue();

        if(father != null) {
            goodskindsPO.setFather(father);
            List temp = link.getRemoteHelper().getGoodsKinds().goodsKindsFind(father);
            goodskindsPO goodskindsPO1 = ((goodskindsPO)temp.get(0));
            if(goodskindsPO1.getSon() != null)
            goodskindsPO1.setSon(goodskindsPO1.getSon() + text + ",");
            else
                goodskindsPO1.setSon(text + ",");
            link.getRemoteHelper().getPub().modifyObject(goodskindsPO1,1);
            goodsTreeView.getSelectionModel().getSelectedItem().getChildren().add(new TreeItem<>(text));
        }
        else
            root.getChildren().add(new TreeItem<>(text));
        link.getRemoteHelper().getPub().addObject(goodskindsPO,1);

    }

    private void modifykinds(String text) throws RemoteException {
        String temp = goodsTreeView.getSelectionModel().getSelectedItem().getValue();
        goodsTreeView.getSelectionModel().getSelectedItem().setValue(text);
        goodskindsPO goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFind(temp).get(0);
        goodskindsPO.setKeyname(text);
        link.getRemoteHelper().getPub().modifyObject(goodskindsPO,1);
        String[] son = goodskindsPO.getSon().split(",");
        for(String s : son){
            goodskindsPO goodskindsPO1 = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFind(s).get(0);
            goodskindsPO1.setFather(text);
            link.getRemoteHelper().getPub().modifyObject(goodskindsPO1,1);
        }
        goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFind(goodskindsPO.getFather()).get(0);
        StringBuilder modify = new StringBuilder();
        son = goodskindsPO.getSon().split(",");
        for(String s : son){
            if(s.equals(temp))
                modify.append(text).append(",");
            else
                modify.append(s).append(",");
        }
        goodskindsPO.setSon(modify.toString());
        link.getRemoteHelper().getPub().modifyObject(goodskindsPO,1);

    }

    private void delkinds() throws RemoteException {
        String temp = goodsTreeView.getSelectionModel().getSelectedItem().getValue();
        goodsTreeView.getSelectionModel().getSelectedItem().getParent().getChildren().remove(goodsTreeView.getSelectionModel().getSelectedItem());
        goodskindsPO goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFind(temp).get(0);
        link.getRemoteHelper().getPub().deleteObject(goodskindsPO,1);
        goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFind(goodskindsPO.getFather()).get(0);
        StringBuilder modify = new StringBuilder();
        String[] son = goodskindsPO.getSon().split(",");
        for(String s : son){
            if(!s.equals(temp))
                modify.append(s).append(",");
        }
        goodskindsPO.setSon(modify.toString());
        link.getRemoteHelper().getPub().modifyObject(goodskindsPO,1);
    }

    /**
     * @author:pis
     * @description:显示商品树
     * @date: 19:58 2017/11/23
     */
    private void showGoodsTree() throws RemoteException {
        List<goodskindsPO> goodskindsVOS = goodsKindsController.FindAll();
        goodskindsPO t;
        for (goodskindsPO goodskindsVO : goodskindsVOS) {
            t = goodskindsVO;
            if (t.getFather() == null) {
                TreeItem<String> treeItem = new TreeItem<>(t.getKeyname());
                root.getChildren().add(treeItem);
                treeItem.setExpanded(true);
                showkinds(treeItem);
            }
        }
    }

    private void showkinds(TreeItem<String> treeItem) throws RemoteException {
        goodskindsPO t = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFind(treeItem.getValue()).get(0);
        String[] temp;
        if(t.getSon() != null && !t.getSon().equals("null")) {
            temp = t.getSon().split(",");
            for (String aTemp : temp) {
                TreeItem<String> treeItem1 = new TreeItem<>(aTemp);
                treeItem1.setExpanded(true);
                treeItem.getChildren().add(treeItem1);
                showkinds(treeItem1);
            }
        }

    }
}
