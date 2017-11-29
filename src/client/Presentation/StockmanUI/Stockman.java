package client.Presentation.StockmanUI;
import client.BL.Stockman.StockmanGoodsbl.GoodsController;
import client.BL.Stockman.StockmanGoodskindsbl.GoodsKindsController;
import client.BL.Stockman.StockmanOverflowbl.stockOverflowController;
import client.BL.Stockman.StockmanStockCheckbl.stockCheckController;
import client.BL.Stockman.StockmanStockGlancebl.stockGlanceController;
import client.BL.Stockman.StockmanWarningbl.StockWarningController;
import client.BL.Stockman.Stockmandamagebl.stockDamageController;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import server.Po.goodsPO;
import server.Po.goodskindsPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:46 2017/11/23
 */
public class Stockman {
    private static Stage stockman;
    private static Label referance = new Label("工作目录");
    private static Button goodsmanage = new Button("商品管理");
    private static Button stockglance = new Button("库存查看");
    private static Button stockcheck = new Button("库存盘点");
    private static Button stockwarning = new Button("库存报警");
    private static Button makebill = new Button("建立单据");


    private static GridPane initPane;
    private static Scene init;
    private static Scene glanceScene;
    private static GridPane glancePane;
    private static Scene checkScene;
    private static GridPane checkPane;
    private static Scene warningScene;
    private static GridPane warningPane;
    private static Scene billScene;
    private static GridPane billPane;
    private static Scene goodsScene;
    private static GridPane goodsPane;


    private static TreeView<String> goodsTreeView;
    private static TreeItem<String> root;
    private static TableView<goodsVO> goodsVOTableView;

    static GoodsKindsController goodsKindsController = new GoodsKindsController();
    static stockDamageController StockDamageController = new stockDamageController();
    static GoodsController goodsController = new GoodsController();
    static stockOverflowController StockOverflowController = new stockOverflowController();
    static stockCheckController StockCheckController = new stockCheckController();
    static stockGlanceController StockGlanceController = new stockGlanceController();
    static StockWarningController stockWarningController = new StockWarningController();


    public static void start() {
        stockman = new Stage();
        initPane = new GridPane();
        init = new Scene(initPane,1200,850);
        setdefault(initPane,init);
        goodsmanage.setOnAction(e -> {
            try {
                showGoods();
            } catch (RemoteException e1) {

            }
        });
        stockglance.setOnAction(e -> stockGlance());
        stockcheck.setOnAction(e -> stockCheck());
        stockwarning.setOnAction(e -> stockWarning());
        makebill.setOnAction(e -> makeBill());
        stockman.show();
    }
    /**
    *@author:pis
    *@description: 建立单据
    *@date: 9:44 2017/11/26
    */
    private static void makeBill() {
        billPane = new GridPane();
        billScene = new Scene(billPane,1200,850);
        setdefault(billPane,billScene);
    }

    /**
    *@author:pis
    *@description: 库存报警
    *@date: 9:43 2017/11/26
    */
    private static void stockWarning() {
        warningPane = new GridPane();
        warningScene = new Scene(warningPane,1200,850);
        setdefault(warningPane,warningScene);
    }

    /**
    *@author:pis
    *@description: 库存盘点
    *@date: 9:42 2017/11/26
    */
    private static void stockCheck() {
        checkPane = new GridPane();
        checkScene = new Scene(checkPane,1200,850);
        setdefault(checkPane,checkScene);
    }

    /**
    *@author:pis
    *@description: 库存查看
    *@date: 9:41 2017/11/26
    */
    private static void stockGlance() {
        glancePane = new GridPane();
        glanceScene = new Scene(glancePane,1200,850);
        setdefault(glancePane,glanceScene);

    }

    /**
     * @author:pis
     * @description:默认布局器
     * @date: 19:50 2017/11/23
     */
    private static void setdefault(GridPane gridPane,Scene scene){
        GridPane.setConstraints(referance, 1, 1);
        GridPane.setConstraints(goodsmanage, 1, 2);
        GridPane.setConstraints(stockglance, 1, 3);
        GridPane.setConstraints(stockcheck, 1, 4);
        GridPane.setConstraints(stockwarning, 1, 5);
        GridPane.setConstraints(makebill, 1, 6);
        gridPane.getChildren().addAll(referance, goodsmanage, stockglance,
                stockcheck, stockwarning, makebill);
        scene.getStylesheets().add("/source/csscfg.css");
        stockman.setScene(scene);
        stockman.setMaximized(true);
    }

    /**
     * @author:pis
     * @description:商品管理
     * @date: 19:50 2017/11/23
     */
    private static void showGoods() throws RemoteException{

        goodsPane = new GridPane();
        goodsScene = new Scene(goodsPane,1200,850);

        Label goods = new Label("商品");
        Label id = new Label("编号");
        Label model = new Label("型号");
        Label num = new Label("库存");
        Label inprice = new Label("进价");
        Label outprice = new Label("零售价");


        Button addGoods = new Button("增加");
        Button deleteGoods = new Button("删除");
        Button edit = new Button("编辑");
        Button save = new Button("保存");
        Button cancel = new Button("取消");
        setdefault(goodsPane,goodsScene);
        root = new TreeItem<>();
        root.setExpanded(true);
        goodsTreeView = new TreeView<>(root);
        goodsTreeView.setShowRoot(false);
        showGoodsTree();
        goodsTreeView.setMinSize(400,500);

        GridPane.setConstraints(goods,2,1);
        GridPane.setConstraints(id,3,1);
        GridPane.setConstraints(model,4,1);
        GridPane.setConstraints(num,5,1);
        GridPane.setConstraints(inprice,6,1);
        GridPane.setConstraints(outprice,7,1);
        GridPane.setConstraints(goodsTreeView,2,2);
        GridPane.setConstraints(addGoods,2,3);
        GridPane.setConstraints(deleteGoods,3,3);
        GridPane.setConstraints(edit,4,3);
        GridPane.setConstraints(save,5,3);
        GridPane.setConstraints(cancel,6,3);


        addGoods.setOnAction(e -> makeaNewLine());

        goodsPane.getChildren().addAll(goods,id,model,num,inprice,outprice,goodsTreeView,
                addGoods,deleteGoods,edit,save,cancel);
    }
    /**
    *@author:pis
    *@description: 单击增加商品，界面新产生一行
    *@date: 17:12 2017/11/26
    */
    private static void makeaNewLine() {
    }



    /**
     * @author:pis
     * @description:显示商品树
     * @date: 19:58 2017/11/23
     */
    private static void showGoodsTree() throws RemoteException {
        List<goodskindsPO> goodskindsVOS = goodsKindsController.FindAll();
        List<TreeItem<String>> treeGoodsKinds = new ArrayList<>();
        goodskindsPO t;
        for (int i = 0; i < goodskindsVOS.size(); i++) {
            System.out.println(goodskindsVOS.get(i).getKeyno());
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
    *@description: 向树中增加商品
    *@date: 21:40 2017/11/23
    */
    private static void addgoods(TreeItem<String> treeItem1, String s) throws RemoteException{
        List<goodsPO> goodsVOS = goodsController.findByKind(s);
        goodsPO g ;
        for(int i = 0;i < goodsVOS.size();i++){
            g = goodsVOS.get(i);
            String message = g.getKeyname() + "  " + g.getKeyno() + "  " + g.getKeybatch() + "  " + g.getNum()
                     + "  " + g.getReceprice() + "  " + g.getReceoutprice();
            TreeItem<String> treeItem = new TreeItem<>(message);
            treeItem.setExpanded(false);
            treeItem1.getChildren().add(treeItem);
        }
    }



}


