package client.Presentation.StockmanUI.goodsWarningUI;


import client.BL.Stockman.StockmanWarningbl.StockWarningController;
import client.Presentation.NOgenerator.NOgenerator;
import client.Vo.goodsVO;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

public class goodsWarningUI {


    private final Button SummitButton = new Button("提交单据");

    private final Label notification = new Label();
    private final Label billNum = new Label();
    private final Label name = new Label();
    private final Label num = new Label();
    private final Label warningnum = new Label();
    private final TextArea text = new TextArea("");
    private final Label Staff = new Label();
    private Stage stage = new Stage();


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
            } catch (RemoteException | IllegalAccessException | IntrospectionException | InvocationTargetException e1) {
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

