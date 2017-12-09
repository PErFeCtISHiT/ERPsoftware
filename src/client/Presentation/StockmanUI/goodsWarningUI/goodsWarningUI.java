package client.Presentation.StockmanUI.goodsWarningUI;


import client.BL.Stockman.StockmanWarningbl.StockWarningController;
import client.Presentation.NOgenerator.NOgenerator;
import client.RMI.link;
import client.Vo.goodsVO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import server.Po.WarningPO;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class goodsWarningUI {


    final Button SummitButton = new Button("提交单据");

    final Label notification = new Label();
    final Label billNum = new Label();
    final Label name = new Label();
    final Label num = new Label();
    final Label warningnum = new Label();
    final TextArea text = new TextArea("");
    final Label Staff = new Label();
    Stage stage = new Stage();


    String address = " ";

    public void start(goodsVO goods, String staff) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String nostr = NOgenerator.generate(9);
        String type = "KCBJD";
        String no = type + "-" + nostr;

        billNum.setText(no);
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 750, 450);

        Staff.setText(staff);
        final Label Type = new Label("库存报警单");


        name.setText(goods.getKeyname());
        num.setText(String.valueOf(goods.getNum()));
        warningnum.setText(String.valueOf(goods.getWarningnum()));

        SummitButton.setOnAction((ActionEvent e) -> {
            StockWarningController stockWarningController = new StockWarningController();
            try {
                stockWarningController.warningMake(goods, staff, text.getText(), no);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            stage.close();
        });


        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("单据类型："), 0, 0);
        grid.add(Type, 1, 0);
        grid.add(new Label("单据编号："), 2, 0);
        grid.add(billNum, 3, 0);
        grid.add(new Label("操作员："), 4, 0);
        grid.add(Staff, 5, 0);
        grid.add(new Label("商品名称:"), 0, 1);
        grid.add(name, 1, 1);
        grid.add(new Label("库存:"), 0, 2);
        grid.add(num, 1, 2);
        grid.add(new Label("警戒数量:"), 2, 2);
        grid.add(warningnum, 3, 2);
        grid.add(new Label("备注:"), 0, 3);
        grid.add(text, 1, 3, 4, 1);
        grid.add(SummitButton, 2, 4);
        grid.add(notification, 0, 6, 3, 1);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
}

