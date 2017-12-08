package client.Presentation.SalesmanUI.BillMake;

import client.BL.Saleman.SalemanConsumerManageblservice.Consumer;
import client.BL.Saleman.SalemanConsumerManageblservice.ConsumerManageController;
import client.BL.Saleman.SalemanSaleblservice.SelloutBill;
import client.BL.Saleman.SalemanSaleblservice.SelloutBillMakeController;
import client.BL.Saleman.SalemanStockinblservice.StockinBill;
import client.BL.Saleman.SalemanStockinblservice.StockinBillMakeController;
import client.RMI.link;
import server.Po.consumerPO;
import server.Po.buyinPO;
import server.Po.selloutPO;
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

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
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

    ConsumerManageController consumerManageController=new ConsumerManageController();

    StockinBillMakeController stockinBillMakeController=new StockinBillMakeController();

    SelloutBillMakeController selloutBillMakeController=new SelloutBillMakeController();



    public static void main(String[] args){
        link.linktoServer();
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


        try {
            List<consumerPO> consumerList= consumerManageController.show();

            consumerNode.setExpanded(true);
            for(consumerPO consumer:consumerList){
                TreeItem<String> empleaf=new TreeItem<>(consumer.getKeyno());
                boolean isfound=false;
                for(TreeItem<String> depNode:consumerNode.getChildren()){
                    if(depNode.getValue().contentEquals(String.valueOf(consumer.getLev()))){
                        depNode.getChildren().add(empleaf);
                        isfound=true;
                        break;
                    }
                }

                if(!isfound){
                    TreeItem<String> depNode=new TreeItem<>(String.valueOf(consumer.getLev()));
                    consumerNode.getChildren().add(depNode);
                    depNode.getChildren().add(empleaf);
                }
            }
        }catch (RemoteException a){
            a.printStackTrace();
        }

        try{
            List<buyinPO> stockinList=stockinBillMakeController.show();
            buyinNode.setExpanded(true);
            TreeItem<String> in=new TreeItem<>("进货单");;
            TreeItem<String> cancel=new TreeItem<>("进货退货单");;
            for(buyinPO stockin:stockinList){
                TreeItem<String> empleaf=new TreeItem<>(stockin.getKeyno());
                if(String.valueOf(stockin.getKind()).equals("0")){
                    in.getChildren().add(empleaf);
                }
                else{
                    cancel.getChildren().add(empleaf);
                }
            }
            buyinNode.getChildren().addAll(in,cancel);
        }catch(RemoteException e){
            e.printStackTrace();
        }

        try{
            List<selloutPO> selloutBillList=selloutBillMakeController.show();
            selloutNode.setExpanded(true);
            TreeItem<String> selloutin=new TreeItem<String>("销售单");
            TreeItem<String> selloutCancel=new TreeItem<>("销售退货单");
            for(selloutPO sellout:selloutBillList){
                TreeItem<String> empleaf=new TreeItem<>(sellout.getKeyno());
                if(String.valueOf(sellout.getKind()).equals("0")){
                    selloutin.getChildren().add(empleaf);
                }
                else{
                    selloutCancel.getChildren().add(empleaf);
                }
            }
            selloutNode.getChildren().addAll(selloutin,selloutCancel);
        }catch(RemoteException e){
            e.printStackTrace();
        }

        rootNode.getChildren().addAll(consumerNode,buyinNode,selloutNode);


        HBox hb=new HBox();

        TreeView<String> consumerTree=new TreeView<>(consumerNode);
        TreeView<String> buyinTree=new TreeView<>(buyinNode);
        TreeView<String> selloutTree=new TreeView<>(selloutNode);


        TreeView<String> treeView=new TreeView<>(rootNode);
        hb.getChildren().add(treeView);

        consumerTree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
            if(newValue.isLeaf()){
                Tab newTab=new Tab();
                newTab.setText(newValue.getValue());
                newTab.setContent(ConsumerPane(newValue.getValue()));
                tabs.getTabs().add(newTab);
            }
        });

        buyinTree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
            if(newValue.isLeaf()){
                Tab newTab=new Tab();
                newTab.setText(newValue.getValue());
                newTab.setContent(BuyinPane(newValue.getValue()));
                tabs.getTabs().add(newTab);
            }
        });

        selloutTree.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
            if(newValue.isLeaf()){
                Tab newTab=new Tab();
                newTab.setText(newValue.getValue());
                newTab.setContent(SelloutPane(newValue.getValue()));
                tabs.getTabs().add(newTab);
            }
        });

        tabs.setTabMinHeight(15);
        tabs.setTabMinWidth(50);

        hb.getChildren().add(tabs);

        VBox VB=new VBox();
        VB.getChildren().addAll(menuBar,hb);
        final Scene scene=new Scene(VB,1400,650);
        scene.setFill(Color.LIGHTGRAY);

        stage.setTitle("进货销售人员");
        stage.setWidth(1400);
        stage.setHeight(650);
        stage.setScene(scene);
        stage.show();
    }

    private Pane ConsumerPane(String id){
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(12);
        gridPane.setMinHeight(450);
        gridPane.setMinWidth(1050);

        ConsumerManageController controller=new ConsumerManageController();
        try {
            consumerPO consumer = (consumerPO) controller.findbyid(id).get(0);
            String number=consumer.getKeyno();
            double level=consumer.getLev();
            String name=consumer.getKeyname();
            String phone=consumer.getTel();
            String mail=consumer.getMailcode();
            String email=consumer.getEmail();
            double capacit=consumer.getCapacit();
            double receive=consumer.getReceive();
            double pay=consumer.getPay();
            String server=consumer.getServer();

            Label label1=new Label("客户编号：");
            Label numOfLabel1=new Label();
            numOfLabel1.setText(number);
            gridPane.add(label1,3,2);
            gridPane.add(numOfLabel1,3,3);

            Label label2=new Label("客户级别：");
            Label numOfLabel2=new Label();
            numOfLabel2.setText(String.valueOf(level));
            gridPane.add(label2,4,2);
            gridPane.add(numOfLabel2,4,3);

            Label label3=new Label("姓名：");
            Label numOfLabel3=new Label();
            numOfLabel3.setText(name);
            gridPane.add(label3,5,2);
            gridPane.add(numOfLabel3,5,3);

            Label label4=new Label("电话：");
            Label numOfLabel4=new Label();
            numOfLabel4.setText(phone);
            gridPane.add(label4,6,2);
            gridPane.add(numOfLabel4,6,3);

            Label label5=new Label("邮编：");
            Label numOfLabel5=new Label();
            numOfLabel5.setText(mail);
            gridPane.add(label5,7,2);
            gridPane.add(numOfLabel5,7,3);

            Label label6=new Label("电子邮箱：");
            Label numOfLabel6=new Label();
            numOfLabel6.setText(email);
            gridPane.add(label6,8,2);
            gridPane.add(numOfLabel6,8,3);

            Label label7=new Label("应收额度：");
            Label numOfLabel7=new Label();
            numOfLabel7.setText(String.valueOf(capacit));
            gridPane.add(label7,9,2);
            gridPane.add(numOfLabel7,9,3);

            Label label8=new Label("应收：");
            Label numOfLabel8=new Label();
            numOfLabel8.setText(String.valueOf(String.valueOf(receive)));
            gridPane.add(label8,10,2);
            gridPane.add(numOfLabel8,10,3);

            Label label9=new Label("应付：");
            Label numOfLabel9=new Label();
            numOfLabel9.setText(String.valueOf(pay));
            gridPane.add(label9,11,2);
            gridPane.add(numOfLabel9,11,3);

            Label label10=new Label("应收：");
            Label numOfLabel10=new Label();
            numOfLabel10.setText(server);
            gridPane.add(label10,12,2);
            gridPane.add(numOfLabel10,12,3);

            Button edit=new Button("编辑");
            gridPane.add(edit,12,6);
            edit.setOnAction(e->{
                String a1=numOfLabel1.getText();
                String a2=numOfLabel2.getText();
                String a3=numOfLabel3.getText();
                String a4=numOfLabel4.getText();
                String a5=numOfLabel5.getText();
                String a6=numOfLabel6.getText();
                String a7=numOfLabel7.getText();
                String a8=numOfLabel8.getText();
                String a9=numOfLabel9.getText();
                String a10=numOfLabel10.getText();
                gridPane.getChildren().removeAll(numOfLabel1,numOfLabel2,numOfLabel3,numOfLabel4,numOfLabel5,numOfLabel6,numOfLabel7,numOfLabel8,numOfLabel9,numOfLabel10);

                TextField b1=new TextField();
                b1.setPromptText(a1);
                b1.setMinSize(50,5);
                gridPane.add(b1,3,3);

                TextField b2=new TextField();
                b2.setPromptText(a2);
                b2.setMinSize(50,5);
                gridPane.add(b2,4,3);

                TextField b3=new TextField();
                b3.setPromptText(a3);
                b3.setMinSize(50,5);
                gridPane.add(b3,5,3);

                TextField b4=new TextField();
                b4.setPromptText(a4);
                b4.setMinSize(50,5);
                gridPane.add(b4,6,3);

                TextField b5=new TextField();
                b5.setPromptText(a5);
                b5.setMinSize(50,5);
                gridPane.add(b5,7,3);

                TextField b6=new TextField();
                b6.setPromptText(a6);
                b6.setMinSize(50,5);
                gridPane.add(b6,8,3);

                TextField b7=new TextField();
                b7.setPromptText(a7);
                b7.setMinSize(50,5);
                gridPane.add(b2,9,3);

                TextField b8=new TextField();
                b8.setPromptText(a8);
                b8.setMinSize(50,5);
                gridPane.add(b8,10,3);

                TextField b9=new TextField();
                b9.setPromptText(a9);
                b9.setMinSize(50,5);
                gridPane.add(b9,11,3);

                TextField b10=new TextField();
                b10.setPromptText(a10);
                b10.setMinSize(50,5);
                gridPane.add(b10,12,3);

            });

        }catch(RemoteException e){
            e.printStackTrace();
        }

        return gridPane;
    }

    private Pane BuyinPane(String id){

        return null;
    }

    private Pane SelloutPane(String id){


        return null;
    }
}
