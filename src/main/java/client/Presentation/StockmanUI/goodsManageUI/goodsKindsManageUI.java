package client.Presentation.StockmanUI.goodsManageUI;

import client.BL.Stockman.StockmanGoodskindsbl.GoodsKindsController;
import client.Presentation.tools.NOgenerator;
import client.RMI.link;
import client.Vo.logVO;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import server.Po.goodskindsPO;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 14:57 2017/12/2
 */
public class goodsKindsManageUI {

    String staff;


    private GoodsKindsController goodsKindsController = new GoodsKindsController();

    private static TreeView<String> goodsTreeView;
    private static TreeItem<String> root;


    public HBox start(String staff) throws Exception {
        this.staff = staff;

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
        addbtn.setStyle("-fx-border-color: black;-fx-background-color: transparent");
        final Button modifybtn = new Button("修改");
        modifybtn.setStyle("-fx-border-color: black;-fx-background-color: transparent");
        final Button delbtn = new Button("删除");
        delbtn.setStyle("-fx-border-color: black;-fx-background-color: transparent");
        buttons.getChildren().addAll(kindsname, addbtn, delbtn, modifybtn);
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
            } catch (RemoteException | IllegalAccessException | InvocationTargetException | IntrospectionException e1) {
                e1.printStackTrace();
            }
        });
        modifybtn.setOnAction(e -> {
            try {
                modifykinds(kindsname.getText());
            } catch (RemoteException | IllegalAccessException | InvocationTargetException | IntrospectionException e1) {
                e1.printStackTrace();
            }
            kindsname.clear();
        });
        final VBox leftbox = new VBox();
        leftbox.setSpacing(5);
        leftbox.setPadding(new Insets(10, 0, 0, 10));
        leftbox.getChildren().addAll(goodsTreeView, buttons);

        vbox.getChildren().add(leftbox);

        goodsTreeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue.isLeaf()) {
                modifybtn.setDisable(false);
                try {
                    VBox vBox = goodsManageUI.start(newValue.getValue(), staff);
                    if (((TableView) vBox.getChildren().get(1)).getItems().size() != 0) {
                        addbtn.setDisable(true);
                        delbtn.setDisable(true);
                    } else {
                        addbtn.setDisable(false);
                        delbtn.setDisable(false);
                    }
                    if (vbox.getChildren().size() > 1)
                        vbox.getChildren().remove(1);
                    vbox.getChildren().add(vBox);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                modifybtn.setDisable(false);
                addbtn.setDisable(false);
                if (vbox.getChildren().size() > 1)
                    vbox.getChildren().remove(1);
                if (!newValue.getChildren().isEmpty()) {
                    delbtn.setDisable(true);
                } else
                    delbtn.setDisable(false);

            }
        });

//        vbox.getStylesheets().add("treeview.css");
//        goodsTreeView.getStyleClass().add("tree-view");

        return vbox;

    }













    /**
     * @author:pis
     * @description: 商品分类的增删改
     * @date: 16:42 2017/12/4
     */
    private void addkinds(String text) throws RemoteException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        goodskindsPO goodskindsPO = new goodskindsPO();
        String no = NOgenerator.generate(1);
        String type = "SPFL";
        goodskindsPO.setKeyno(type + "-" + no);
        goodskindsPO.setKeyname(text);
        if (goodsTreeView.getSelectionModel().getSelectedItem() != null) {
            String father = goodsTreeView.getSelectionModel().getSelectedItem().getValue();
            goodskindsPO.setFather(father);
            List temp = link.getRemoteHelper().getGoodsKinds().goodsKindsFindByKeyWord(father);
            goodskindsPO goodskindsPO1 = ((goodskindsPO) temp.get(0));
            if (goodskindsPO1.getSon() != null)
                goodskindsPO1.setSon(goodskindsPO1.getSon() + text + ",");
            else
                goodskindsPO1.setSon(text + ",");
            link.getRemoteHelper().getPub().modifyObject(goodskindsPO1, 1);
            goodsTreeView.getSelectionModel().getSelectedItem().getChildren().add(new TreeItem<>(text));
        } else
            root.getChildren().add(new TreeItem<>(text));
        link.getRemoteHelper().getPub().addObject(goodskindsPO, 1);
        logVO logVO = new logVO();
        logVO.setOpno("增加商品分类");
        logVO.setOperatorno(staff);
        logVO.setGoodsname(goodskindsPO.getKeyname());
        logVO.setKeyjob("库存管理");
        link.getRemoteHelper().getLog().addObject(logVO, 13);

    }

    private void modifykinds(String text) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String temp = goodsTreeView.getSelectionModel().getSelectedItem().getValue();
        goodsTreeView.getSelectionModel().getSelectedItem().setValue(text);
        goodskindsPO goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFindByKeyWord(temp).get(0);
        goodskindsPO.setKeyname(text);
        link.getRemoteHelper().getPub().modifyObject(goodskindsPO, 1);
        String[] son = goodskindsPO.getSon().split(",");
        for (String s : son) {
            goodskindsPO goodskindsPO1 = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFindByKeyWord(s).get(0);
            goodskindsPO1.setFather(text);
            link.getRemoteHelper().getPub().modifyObject(goodskindsPO1, 1);
        }
        goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFindByKeyWord(goodskindsPO.getFather()).get(0);
        StringBuilder modify = new StringBuilder();
        son = goodskindsPO.getSon().split(",");
        for (String s : son) {
            if (s.equals(temp))
                modify.append(text).append(",");
            else
                modify.append(s).append(",");
        }
        goodskindsPO.setSon(modify.toString());
        link.getRemoteHelper().getPub().modifyObject(goodskindsPO, 1);

        logVO logVO = new logVO();
        logVO.setOpno("修改商品分类");
        logVO.setOperatorno(staff);
        logVO.setGoodsname(goodskindsPO.getKeyname());
        logVO.setKeyjob("库存管理");
        link.getRemoteHelper().getLog().addObject(logVO, 13);

    }

    private void delkinds() throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String temp = goodsTreeView.getSelectionModel().getSelectedItem().getValue();
        goodsTreeView.getSelectionModel().getSelectedItem().getParent().getChildren().remove(goodsTreeView.getSelectionModel().getSelectedItem());
        goodskindsPO goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFindByKeyWord(temp).get(0);
        link.getRemoteHelper().getPub().deleteObject(goodskindsPO, 1);
        goodskindsPO = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFindByKeyWord(goodskindsPO.getFather()).get(0);
        StringBuilder modify = new StringBuilder();
        String[] son = goodskindsPO.getSon().split(",");
        for (String s : son) {
            if (!s.equals(temp))
                modify.append(s).append(",");
        }
        goodskindsPO.setSon(modify.toString());
        link.getRemoteHelper().getPub().modifyObject(goodskindsPO, 1);
        logVO logVO = new logVO();
        logVO.setOpno("删除商品分类");
        logVO.setOperatorno(staff);
        logVO.setGoodsname(goodskindsPO.getKeyname());
        logVO.setKeyjob("库存管理");
        link.getRemoteHelper().getLog().addObject(logVO, 13);
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
                treeItem.setGraphic(new ImageView(new Image("文件.png")));
                root.getChildren().add(treeItem);
                treeItem.setExpanded(true);
                showkinds(treeItem);
            }
        }
    }

    private void showkinds(TreeItem<String> treeItem) throws RemoteException {
        goodskindsPO t = (server.Po.goodskindsPO) link.getRemoteHelper().getGoodsKinds().goodsKindsFindByKeyWord(treeItem.getValue()).get(0);
        String[] temp;
        if (t.getSon() != null && !t.getSon().equals("null")) {
            temp = t.getSon().split(",");
            for (String aTemp : temp) {
                TreeItem<String> treeItem1 = new TreeItem<>(aTemp);
                treeItem1.setGraphic(new ImageView(new Image("文件.png")));
                treeItem1.setExpanded(true);
                treeItem.getChildren().add(treeItem1);
                showkinds(treeItem1);
            }
        }
    }


}
