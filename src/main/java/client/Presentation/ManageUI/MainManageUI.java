package client.Presentation.ManageUI;
import  client.Presentation.ManageUI.CheckSellUI;
import  client.Presentation.ManageUI.ExamineBillUI;
import  client.Presentation.ManageUI.CheckProgressUI;
import  client.Presentation.ManageUI.CheckSituationUI;
import  client.Presentation.ManageUI.MakeCutUI;

import client.RMI.link;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.Po.userPO;

import java.rmi.RemoteException;
import java.text.ParseException;

public class MainManageUI {
    private HBox right ;
    private String staff;

    public HBox start(userPO userpo)  {
        staff = userpo.getKeyname();

        HBox finalBox = new HBox();
        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));

        CheckSellUI checkSellUI =new CheckSellUI();
        ExamineBillUI examineBillUI =new ExamineBillUI();
        CheckProgressUI checkProgressUI =new CheckProgressUI();
        CheckSituationUI checkSituationUI =new CheckSituationUI();
        MakeCutUI makeCutUI = new MakeCutUI();



        Label work = new Label("工作目录");

        Button checkSell = new Button("审批单据",new ImageView(new Image("审批.png")));
        checkSell.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        right =new HBox();

        checkSell.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = examineBillUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button checkmingxi = new Button("查看销售明细表",new ImageView(new Image("查看.png")));
        checkSell.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        checkmingxi.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = checkSellUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button checkprocess = new Button("查看经营历程表",new ImageView(new Image("查看.png")));
        checkprocess.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");;
        checkprocess.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = checkProgressUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        Button checksituation = new Button("查看经营情况表",new ImageView(new Image("查看.png")));
        checksituation.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        checksituation.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = checkSituationUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        Button makecut = new Button("制定促销策略",new ImageView(new Image("定制.png")));
        makecut.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        makecut.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = makeCutUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });



        vBox.getChildren().addAll(work,checkSell,checkmingxi,checkprocess,checksituation,makecut);

        finalBox.setSpacing(5);
        finalBox.setPadding(new Insets(10, 0, 0, 10));
        finalBox.getChildren().addAll(vBox,right);
        return finalBox;
    }
}
