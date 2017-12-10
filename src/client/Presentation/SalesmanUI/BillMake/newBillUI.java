package client.Presentation.SalesmanUI.BillMake;

import client.BL.Saleman.SalemanConsumerManageblservice.Consumer;
import client.BL.Saleman.SalemanSaleblservice.SelloutBill;
import client.BL.Saleman.SalemanStockinblservice.StockinBill;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Leonarda on 2017/12/6.
 */
public class newBillUI extends Application{

    TreeItem<String> rootNode;
    TreeItem<String> consumerNode;
    TreeItem<String> buyinNode;
    TreeItem<String> selloutNode;

    TabPane tabs=new TabPane();

    List<Consumer> consumerList= Arrays.<Consumer>asList(
            new Consumer("A","1"),
            new Consumer("B","1"),
            new Consumer("C","0"),
            new Consumer("D","0"),
            new Consumer("E","1")
    );

    List<StockinBill> stockinList=Arrays.<StockinBill>asList(
            new StockinBill("a","b","c","d","e","f","g","0"),
            new StockinBill("A","B","C","D","E","F","G","1"),
            new StockinBill("sda","B","C","D","E","F","G","0"),
            new StockinBill("sddd","b","c","d","e","f","g","1"),
            new StockinBill("huo","b","c","d","e","f","g","0")
    );

    List<SelloutBill> selloutBillList=Arrays.<SelloutBill>asList(
            new SelloutBill("asasd","a","a","a","a","a","a","c","c","c","d","0"),
            new SelloutBill("ssd","a","a","a","a","a","a","c","c","c","d","1"),
            new SelloutBill("jli","a","a","a","a","a","a","c","c","c","d","1"),
            new SelloutBill("bhft","a","a","a","a","a","a","c","c","c","d","0"),
            new SelloutBill("rtxz","a","a","a","a","a","a","c","c","c","d","1")
    );



    public static void main(String[] args){
        launch(args);
    }

    public newBillUI(){
        this.rootNode=new TreeItem<>("工作目录");
        this.consumerNode=new TreeItem<>("客户列表");
        this.buyinNode=new TreeItem<>("进货单列表");
        this.selloutNode=new TreeItem<>("销售单列表");
    }

    public void start(Stage stage){

        MenuBar menuBar=new MenuBar();

        Menu menu1=new Menu("菜单");
        Menu menu2=new Menu("新建");
        Menu menu3=new Menu("帮助");

        menuBar.getMenus().addAll(menu1,menu2,menu3);

        consumerNode.setExpanded(true);
        for(Consumer consumer:consumerList){
            TreeItem<String> empleaf=new TreeItem<>(consumer.getName());
            boolean isfound=false;
            for(TreeItem<String> depNode:consumerNode.getChildren()){
                if(depNode.getValue().contentEquals(consumer.getLevel())){
                    depNode.getChildren().add(empleaf);
                    isfound=true;
                    break;
                }
            }
            if(!isfound){
                TreeItem<String> depNode=new TreeItem<>(consumer.getLevel());
                consumerNode.getChildren().add(depNode);
                depNode.getChildren().add(empleaf);
            }
        }


        buyinNode.setExpanded(true);
        TreeItem<String> in=new TreeItem<>("进货单");;
        TreeItem<String> cancel=new TreeItem<>("进货退货单");;
        for(StockinBill stockin:stockinList){
            TreeItem<String> empleaf=new TreeItem<>(stockin.getBuyinID());
            if((stockin.getBuyinKinds()).equals("0")){
                in.getChildren().add(empleaf);
            }
            else{
                cancel.getChildren().add(empleaf);
            }
        }
        buyinNode.getChildren().addAll(in,cancel);


        selloutNode.setExpanded(true);
        TreeItem<String> selloutin=new TreeItem<String>("销售单");
        TreeItem<String> selloutCancel=new TreeItem<>("销售退货单");
        for(SelloutBill sellout:selloutBillList){
            TreeItem<String> empleaf=new TreeItem<>(sellout.getSelloutID());
            if(sellout.getSelloutID().equals("0")){
                selloutin.getChildren().add(empleaf);
            }
            else{
                selloutCancel.getChildren().add(empleaf);
            }
        }
        selloutNode.getChildren().addAll(selloutin,selloutCancel);
        

        rootNode.getChildren().addAll(consumerNode,buyinNode,selloutNode);

        stage.setTitle("进货销售人员");
        stage.setWidth(1400);
        stage.setHeight(650);
        HBox hb=new HBox();
        final Scene scene=new Scene(hb,1400,650);
        scene.setFill(Color.LIGHTGRAY);

        TreeView<String> treeView=new TreeView<>(rootNode);
        hb.getChildren().add(treeView);

        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
            if(newValue.isLeaf()){
                Tab newTab=new Tab();
                newTab.setText(newValue.getValue());
                newTab.setContent(ConsumerPane(newValue.getValue()));
                tabs.getTabs().add(newTab);
            }
        });

        tabs.setTabMinHeight(15);
        tabs.setTabMinWidth(50);
        hb.getChildren().add(tabs);


        stage.setScene(scene);
        stage.show();
    }

    private Pane ConsumerPane(String name){
        Consumer consuemr=new Consumer(name,"B","C","D","E","F","G","H","I","J","K","L","M");
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(12);
        gridPane.setMinHeight(450);
        gridPane.setMinWidth(1050);
        Label label1=new Label("aaaa");
        gridPane.getChildren().add(label1);
        return gridPane;
    }
}
