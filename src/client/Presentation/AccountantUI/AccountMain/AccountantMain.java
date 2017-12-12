package client.Presentation.AccountantUI.AccountMain;



import client.BL.Stockman.StockmanGoodsbl.GoodsController;

import client.BL.Stockman.StockmanGoodskindsbl.GoodsKindsController;

import client.Presentation.AccountantUI.AccountManagement.AccountManagementUI;
import client.Presentation.ManageUI.CheckSellUI;
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
        CheckSellUI CheckSellUI = new CheckSellUI();

        Label work = new Label("工作目录");
        Button account = new Button("账户管理");
        right = new VBox();
        account.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = accountManageUI.start(staff);//
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



//        vBox.getChildren().addAll(work,account,checkSell);//goodsGlance

        finalBox.setSpacing(5);
        finalBox.setPadding(new Insets(10, 0, 0, 10));
        finalBox.getChildren().addAll(vBox,right);

        Scene scene = new Scene(finalBox);
        Stage.setScene(scene);
        Stage.setMinHeight(700);
        Stage.setMinWidth(1400);
        Stage.show();
    }
}
