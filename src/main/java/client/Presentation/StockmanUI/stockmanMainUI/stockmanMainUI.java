package client.Presentation.StockmanUI.stockmanMainUI;

import client.Presentation.StockmanUI.goodsCheckUI.goodsCheckUI;
import client.Presentation.StockmanUI.goodsGlanceUI.goodsGlanceUI;
import client.Presentation.StockmanUI.goodsManageUI.goodsKindsManageUI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import server.Po.userPO;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:59 2017/12/9
 */
public class stockmanMainUI {

    private HBox right = new HBox();
    private String staff;
    private goodsKindsManageUI goodsKindsManageUI = new goodsKindsManageUI();
    private goodsGlanceUI goodsGlanceUI = new goodsGlanceUI();
    private goodsCheckUI goodsCheckUI = new goodsCheckUI();
    private HBox finalBox = new HBox();

    public HBox start(userPO userPO) {

        staff = userPO.getKeyname();

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));

        Label work = new Label("工作目录", new ImageView(new Image("menu.png")));
        work.setStyle("-fx-background-color: transparent;-fx-border-color: transparent;-fx-font-family: serif;-fx-font-family: sans-serif;-fx-font-size:20");

        Button goods = new Button("商品管理", new ImageView(new Image("商品.png")));
        goods.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        goods.setOnAction(e -> {
            try {
                generatefinalBox(0);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button goodsGlance = new Button("库存查看", new ImageView(new Image("库存.png")));
        goodsGlance.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        goodsGlance.setOnAction(e -> {
            try {
                generatefinalBox(1);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        Button goodsCheck = new Button("库存盘点", new ImageView(new Image("盘点.png")));
        goodsCheck.setStyle("-fx-font-size: 14;-fx-border-color: transparent;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-family: serif");
        goodsCheck.setOnAction(e -> {
                    try {
                        generatefinalBox(2);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
        );

        vBox.getChildren().addAll(work, goods, goodsGlance, goodsCheck);

        finalBox.setSpacing(5);
        finalBox.setPadding(new Insets(10, 0, 0, 10));
        finalBox.getChildren().addAll(vBox, right);

        return finalBox;
    }

    private void generatefinalBox(int type) throws Exception {
        finalBox.getChildren().remove(right);
        switch (type) {
            case 0:
                right = goodsKindsManageUI.start(staff);
                break;
            case 1:
                right = goodsGlanceUI.start();
                break;
            case 2:
                right = goodsCheckUI.start();
                break;
        }
        finalBox.getChildren().add(right);
    }
}
