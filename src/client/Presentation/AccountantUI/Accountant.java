package client.Presentation.AccountantUI;



import client.BL.Stockman.StockmanGoodsbl.GoodsController;

import client.BL.Stockman.StockmanGoodskindsbl.GoodsKindsController;

import client.Vo.goodsVO;

import client.Vo.goodskindsVO;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TreeItem;

import javafx.scene.control.TreeView;

import javafx.scene.layout.GridPane;

import javafx.stage.Stage;



import java.util.ArrayList;

import java.util.List;



public class Accountant {



    private static Stage Accountant;

    private static Label Workplace = new Label("工作目录");



    private static Button accountManagement = new Button("账户管理");

    private static Button receiveBill = new Button("制定收款单");

    private static Button payBill = new Button("制定付款单");

    private static Button cashBill = new Button("制定现金费用单");

    private static Button salesDetails = new Button("查看销售明细表");

    private static Button checkProgress = new Button("查看经营历程表");

    private static Button checkSituation = new Button("查看经营情况表");

    private static Button accountInit = new Button("期初建账");

    private static Scene init;

    private static Scene goodsScene;

    private static GridPane accountPane;

    private static TreeView<String> goodsTreeView;

    static TreeItem<String> root = new TreeItem<>();



    public static void start() {

        Accountant = new Stage();

        GridPane gridPane = new GridPane();

        setdefaultConstraints(gridPane);

        receiveBill.setOnAction(e -> showGoods());

        gridPane.getChildren().addAll(Workplace, accountManagement,receiveBill, payBill, cashBill, salesDetails, checkProgress,checkSituation,accountInit);

        init = new Scene(gridPane, 1000, 1600);

        init.getStylesheets().add("/source/csscfg.css");

        Accountant.setScene(init);

        Accountant.show();

    }













    /**

     * @author:pis

     * @description:

     * @date: 19:50 2017/11/23

     */

    private static void setdefaultConstraints(GridPane gridPane) {//默认布局器

        gridPane.setConstraints(Workplace, 1, 1);

        gridPane.setConstraints(accountManagement, 1, 2);

        gridPane.setConstraints(receiveBill, 1, 3);

        gridPane.setConstraints(payBill, 1, 4);

        gridPane.setConstraints(cashBill, 1, 5);

        gridPane.setConstraints(salesDetails, 1, 6);

        gridPane.setConstraints(checkProgress, 1, 7);

        gridPane.setConstraints(checkSituation, 1, 8);

        gridPane.setConstraints(accountInit, 1, 9);



    }



    /**

     * @author:pis

     * @description:商品管理

     * @date: 19:50 2017/11/23

     */

    private static void showGoods() {

        accountPane = new GridPane();

        setdefaultConstraints(accountPane);

        root.setExpanded(true);

        goodsTreeView = new TreeView<>(root);

        goodsTreeView.setShowRoot(false);

        showGoodsTree();

        goodsTreeView.setMinSize(700,500);

        accountPane.setConstraints(goodsTreeView,2,1);

        accountPane.getChildren().addAll(Workplace, accountManagement, payBill, cashBill, salesDetails, checkProgress,goodsTreeView);

        goodsScene = new Scene(accountPane,1000,800);

        goodsScene.getStylesheets().add("/source/csscfg.css");

        Accountant.setScene(goodsScene);

    }



    /**

     * @author:pis

     * @description:显示商品树

     * @date: 19:58 2017/11/23

     */

    private static void showGoodsTree() {

        GoodsKindsController goodsKindsController = new GoodsKindsController();

        List<goodskindsVO> goodskindsVOS = goodsKindsController.FindAll();

        List<TreeItem<String>> treeGoodsKinds = new ArrayList<>();

        goodskindsVO t;

        for (int i = 0; i < goodskindsVOS.size(); i++) {

            t = goodskindsVOS.get(i);

            if(t.getFather() == null){

                TreeItem<String> treeItem = new TreeItem<>(t.getKeyname());

                root.getChildren().add(treeItem);

                treeItem.setExpanded(true);

                treeGoodsKinds.add(treeItem);

                String temp[] = t.getSon().split(",");

                for(int j = 0;j < temp.length;j++){

                    TreeItem<String> treeItem1 = new TreeItem<>(temp[j]);

                    treeItem1.setExpanded(true);

                    addgoods(treeItem1,temp[j]);

                    treeItem.getChildren().add(treeItem1);

                }

            }

        }

    }

    /**

     *@author:pis

     *@description:

     *@date: 21:40 2017/11/23

     */

    private static void addgoods(TreeItem<String> treeItem1, String s) {

        GoodsController goodsController = new GoodsController();

        List<goodsVO> goodsVOS = goodsController.findByKind(s);

        goodsVO g ;

        for(int i = 0;i < goodsVOS.size();i++){

            g = goodsVOS.get(i);

            TreeItem<String> treeItem = new TreeItem<>(g.getKeyname());

            treeItem.setExpanded(false);

            treeItem1.getChildren().add(treeItem);

        }

    }

}