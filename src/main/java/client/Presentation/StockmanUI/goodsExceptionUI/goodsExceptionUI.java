package client.Presentation.StockmanUI.goodsExceptionUI;


import client.BL.Stockman.StockmanExceptionbl.stockExceptionController;
import client.Presentation.tools.NOgenerator;
import client.Vo.goodsVO;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

public class goodsExceptionUI {

    private final Button SummitButton = new Button("提交单据");

    private final Label notification = new Label();
    private final Label billNum = new Label();
    private final Label name = new Label();
    private final Label num = new Label();
    private final Label basenum = new Label();
    private final TextArea text = new TextArea("");
    private final Label Staff = new Label();
    private Stage stage = new Stage();


    /**
     * @author:pis
     * @description: 警告界面
     * @date: 22:39 2017/12/5
     */
    public void systemWarning(goodsVO goods, String staff, Double addnum) {
        Stage systemWarning = new Stage();
        systemWarning.setTitle("警告");
        systemWarning.setAlwaysOnTop(true);
        systemWarning.setHeight(100);
        systemWarning.setWidth(1000);
        String mess;
        int type;
        if (addnum > 0) {
            type = 0;
            mess = "您正准备向系统添加" + goods.getKeyname() + " " + String.valueOf(addnum) + "件,是否创建库存报溢单";
        } else {
            type = 1;
            mess = "您正准备向系统减少" + goods.getKeyname() + " " + String.valueOf(-addnum) + "件，是否创建库存报损单";
        }
        Label message = new Label(mess);
        Button yes = new Button("确认");
        Button no = new Button("取消");
        no.setOnAction(e -> systemWarning.close());
        yes.setOnAction(e -> {
            goodsExceptionUI goodsExceptionUI = new goodsExceptionUI();
            try {
                goodsExceptionUI.start(goods, staff, type, addnum);
                systemWarning.close();
            } catch (RemoteException | IllegalAccessException | IntrospectionException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
        });
        HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().addAll(message, yes, no);
        Scene scene = new Scene(hbox);
        systemWarning.setScene(scene);
        systemWarning.show();
    }

    /**
     * @author:pis
     * @description: 单据界面
     * @date: 22:39 2017/12/5
     */
    public void start(goodsVO goods, String staff, int billtype, Double addnum) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String nostr = NOgenerator.generate(7);
        String type;
        final Label Type = new Label();
        if (billtype == 0) {
            type = "KCBYD";
            Type.setText("库存报溢单");
        } else {
            type = "KCBSD";
            Type.setText("库存报损单");
        }
        String no = type + "-" + nostr;

        billNum.setText(no);
        stage.setTitle("填写单据");
        Scene scene = new Scene(new Group(), 750, 450);

        Staff.setText(staff);


        name.setText(goods.getKeyname());
        num.setText(String.valueOf(goods.getNum()));
        basenum.setText(String.valueOf(goods.getNum() + addnum));

        SummitButton.setOnAction((ActionEvent e) -> {
            stockExceptionController stockExceptionController = new stockExceptionController();
            try {
                stockExceptionController.ExceptionMake(goods, goods.getNum() + addnum, staff, text.getText(), no, billtype);
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
        grid.add(new Label("系统库存:"), 0, 2);
        grid.add(num, 1, 2);
        grid.add(new Label("库房库存:"), 2, 2);
        grid.add(basenum, 3, 2);
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

