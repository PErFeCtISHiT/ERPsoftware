package client.Presentation.StockmanUI.goodsManageUI;

import client.BL.Stockman.StockmanGoodskindsbl.GoodsKindsController;
import client.RMI.link;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.Po.goodskindsPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 14:57 2017/12/2
 */
public class goodsKindsManageUI extends Application{


    GoodsKindsController goodsKindsController = new GoodsKindsController();

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
        stage.setWidth(1000);
        stage.setHeight(550);

        root = new TreeItem<>();
        root.setExpanded(true);
        goodsTreeView = new TreeView<>(root);
        goodsTreeView.setShowRoot(false);
        showGoodsTree();
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(goodsTreeView);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

    }

    /**
     * @author:pis
     * @description:显示商品树
     * @date: 19:58 2017/11/23
     */
    private void showGoodsTree() throws RemoteException {
        List<goodskindsPO> goodskindsVOS = goodsKindsController.FindAll();
        List<TreeItem<String>> treeGoodsKinds = new ArrayList<>();
        goodskindsPO t;
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
                    treeItem.getChildren().add(treeItem1);
                }
            }
        }
    }
}
