package client.Presentation.AccountantUI.AccountMain;



import client.BL.Stockman.StockmanGoodsbl.GoodsController;

import client.BL.Stockman.StockmanGoodskindsbl.GoodsKindsController;

import client.Presentation.AccountantUI.AccountManagement.AccountManagementUI;
import client.Presentation.AccountantUI.CashBill.CashUI;
import client.Presentation.AccountantUI.CheckSell.CheckSellUI;
import client.Presentation.AccountantUI.InitAccount.AccountInitUI;
import client.Presentation.AccountantUI.ReceivePayBill.PayUI;
import client.Presentation.AccountantUI.ReceivePayBill.ReceiveUI;
import client.RMI.link;
import client.Vo.goodsVO;

import client.Vo.goodskindsVO;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TreeItem;

import javafx.scene.control.TreeView;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;



public class AccountantMain extends Application {

    String staff = "core";
    String staffno;
    private VBox right ;

    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }

    @Override
    public void start(Stage Stage)  {
        HBox finalBox = new HBox();
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        AccountManagementUI accountManageUI = new AccountManagementUI();
        CheckSellUI checkSellUI = new CheckSellUI();
        AccountInitUI accountInitUI = new AccountInitUI();
        ReceiveUI receiveUI = new ReceiveUI();
        PayUI payUI = new PayUI();
        CashUI cashUI = new CashUI();


        Label work = new Label("工作目录");

        Button accountManageBT = new Button("账户管理");
        right = new VBox();
        accountManageBT.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = accountManageUI.start(staff);
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button checkSellBT = new Button("查看销售明细表");
        right = new VBox();
        checkSellBT.setOnAction(e->{
            try {
                finalBox.getChildren().remove(right);
                right = checkSellUI.start(staff);
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button initAccountBT = new Button("期初建账");
        right = new VBox();
        initAccountBT.setOnAction(e->{
            try {
                finalBox.getChildren().remove(right);
                right = accountInitUI.start(staff);
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        Button receiveBT = new Button("制定收款单");
        right = new VBox();
        receiveBT.setOnAction(e->{
            try {
                finalBox.getChildren().remove(right);
                right = receiveUI.start(staff);
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button payBT = new Button("制定付款单");
        right = new VBox();
        payBT.setOnAction(e->{
            try {
                finalBox.getChildren().remove(right);
                right = payUI.start(staff);
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button cashBT = new Button("制定现金费用单");
        right = new VBox();
        cashBT.setOnAction(e->{
            try {
                finalBox.getChildren().remove(right);
                right = cashUI.start(staff);
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });



//        Button checkSell = new Button("库存查看");
//        checkSell.setOnAction(e -> {
//            try {
//                finalBox.getChildren().remove(right);
//                right = CheckSellUI.start(staff);
//                finalBox.getChildren().add(right);
//            } catch (RemoteException e1) {
//                e1.printStackTrace();
//            } catch (ParseException e1) {
//                e1.printStackTrace();
//            }
//        });



        vBox.getChildren().addAll(work,accountManageBT,receiveBT,payBT,cashBT,checkSellBT,initAccountBT);

        finalBox.setSpacing(5);
        finalBox.setPadding(new Insets(10, 0, 0, 10));
        finalBox.getChildren().addAll(vBox,right);

        Scene scene = new Scene(finalBox);
        Stage.setScene(scene);
        Stage.setMinHeight(900);
        Stage.setMinWidth(1600);
        Stage.show();
    }
}
