package client.Presentation.ManageUI;

import client.Presentation.StockmanUI.goodsCheckUI.goodsCheckUI;
import client.Presentation.StockmanUI.goodsGlanceUI.goodsGlanceUI;
import client.Presentation.StockmanUI.goodsManageUI.goodsKindsManageUI;
import client.RMI.link;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.text.ParseException;

public class MainManageUI extends Application{
    String staff = "core";
    String staffno;
    private HBox right ;

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
        goodsKindsManageUI goodsKindsManageUI = new goodsKindsManageUI();
        goodsGlanceUI goodsGlanceUI = new goodsGlanceUI();
        goodsCheckUI goodsCheckUI = new goodsCheckUI();
        Label work = new Label("工作目录");

        Button checkSell = new Button("审批单据");
        checkSell.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsGlanceUI.start();
                finalBox.getChildren().add(right);
            } catch (RemoteException | ParseException e1) {
                e1.printStackTrace();
            }
        });

        Button checkmingxi = new Button("查看销售明细表");
        checkmingxi.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsCheckUI.start();
                finalBox.getChildren().add(right);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });

        Button checkprocess = new Button("查看经营历程表");
        checkprocess.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsCheckUI.start();
                finalBox.getChildren().add(right);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });


        Button checksituation = new Button("查看经营情况表");
        checksituation.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsCheckUI.start();
                finalBox.getChildren().add(right);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });


        Button makecut = new Button("制定促销策略");
        makecut.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsCheckUI.start();
                finalBox.getChildren().add(right);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });



        vBox.getChildren().addAll(work,checkmingxi,checkprocess,checksituation,makecut);

        finalBox.setSpacing(5);
        finalBox.setPadding(new Insets(10, 0, 0, 10));
        finalBox.getChildren().addAll(vBox,right);

        Scene scene = new Scene(finalBox);
        Stage.setScene(scene);
        Stage.setMaximized(true);
        Stage.show();
    }
}
