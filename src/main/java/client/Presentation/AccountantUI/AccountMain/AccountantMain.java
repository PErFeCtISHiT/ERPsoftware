package client.Presentation.AccountantUI.AccountMain;


import client.Presentation.AccountantUI.AccountManagement.AccountManagementUI;
import client.Presentation.AccountantUI.CashBill.CashUI;
import client.Presentation.AccountantUI.CheckSell.CheckSellUI;
import client.Presentation.AccountantUI.InitAccount.AccountInitUI;
import client.Presentation.AccountantUI.LogCheck.LogCheckUI;
import client.Presentation.AccountantUI.ReceivePayBill.PayUI;
import client.Presentation.AccountantUI.ReceivePayBill.ReceiveUI;
import client.Presentation.GuideUI.GuideUI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import server.Po.userPO;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.ParseException;


public class AccountantMain {

    String staff = "Yotta";
    private VBox right;
    HBox finalBox = new HBox();

    public HBox start(userPO userPO) throws Exception {
        staff = userPO.getKeyname();
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        AccountManagementUI accountManageUI = new AccountManagementUI();
        CheckSellUI checkSellUI = new CheckSellUI();
        AccountInitUI accountInitUI = new AccountInitUI();
        ReceiveUI receiveUI = new ReceiveUI();
        PayUI payUI = new PayUI();
        CashUI cashUI = new CashUI();
        LogCheckUI logcheckUI = new LogCheckUI();

        Label work = new Label("工作目录",new ImageView(new Image("menu.png")));
        work.setStyle("-fx-background-color: transparent;-fx-border-color: transparent;-fx-font-family:serif;-fx-font-size:20");

        GuideUI guideUI=new GuideUI();
        VBox r=new VBox();
        r.getChildren().add(guideUI.start());
        right=r;

        Button accountManageBT = new Button("账户管理",new ImageView(new Image("manage.png")));
        accountManageBT.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        Boxset(accountManageBT, accountManageUI.start(staff), receiveUI);

        Button checkSellBT = new Button("查看销售明细表",new ImageView(new Image("checksell.png")));
        checkSellBT.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        Boxset(checkSellBT, checkSellUI.start(staff), receiveUI);

        Button initAccountBT = new Button("期初建账",new ImageView(new Image("build.png")));
        initAccountBT.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        Boxset(initAccountBT, accountInitUI.start(staff), receiveUI);


        Button receiveBT = new Button("制定收款单",new ImageView(new Image("realreceive.png")));
        receiveBT.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        Boxset(receiveBT, receiveUI.start(staff), receiveUI);

        Button payBT = new Button("制定付款单",new ImageView(new Image("pay.png")));
        payBT.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        Boxset(payBT, payUI.start(staff), receiveUI);

        Button cashBT = new Button("制定现金费用单",new ImageView(new Image("money.png")));
        cashBT.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        Boxset(cashBT, cashUI.start(staff), receiveUI);


        Line line1=new Line(0,100,100,100);

        Line slipLine=new Line(200,0,200,650);

        vBox.getChildren().addAll(work, line1, accountManageBT, receiveBT, payBT, cashBT, checkSellBT, initAccountBT);

        finalBox.setSpacing(10);
        finalBox.setPadding(new Insets(10, 0, 0, 10));
        finalBox.getChildren().addAll(vBox,slipLine, right);

        return finalBox;
    }

    private void Boxset(Button receiveBT, VBox start, ReceiveUI receiveUI) {
        receiveBT.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = start;
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }
}
