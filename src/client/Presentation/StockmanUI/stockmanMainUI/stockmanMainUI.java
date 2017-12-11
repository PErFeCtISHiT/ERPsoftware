package client.Presentation.StockmanUI.stockmanMainUI;

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

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:59 2017/12/9
 */
public class stockmanMainUI extends Application{

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
        Button goods = new Button("商品管理");
        right = new HBox();
        goods.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsKindsManageUI.start(staff);
                finalBox.getChildren().add(right);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });

        Button goodsGlance = new Button("库存查看");
        goodsGlance.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsGlanceUI.start();
                finalBox.getChildren().add(right);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        });

        Button goodsCheck = new Button("库存盘点");
        goodsCheck.setOnAction(e -> {
            try {
                finalBox.getChildren().remove(right);
                right = goodsCheckUI.start();
                finalBox.getChildren().add(right);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });

        vBox.getChildren().addAll(work,goods,goodsGlance,goodsCheck);

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
