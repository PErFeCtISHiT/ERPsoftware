package client.Presentation.ManageUI;
import client.Presentation.GuideUI.GuideUI;
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

        Button checkSell = new Button("审批单据");

        GuideUI guide=new GuideUI();
        right=guide.start();

        checkSell.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = examineBillUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button checkmingxi = new Button("查看销售明细表");
        checkmingxi.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = checkSellUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button checkprocess = new Button("查看经营历程表");
        checkprocess.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = checkProgressUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        Button checksituation = new Button("查看经营情况表");
        checksituation.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = checkSituationUI.start();
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        Button makecut = new Button("制定促销策略");
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
