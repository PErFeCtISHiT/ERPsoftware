package client.Presentation.StockmanUI.stockmanMainUI;

import client.RMI.link;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:59 2017/12/9
 */
public class stockmanMainUI extends Application{

    public static void main(String[] args){
        link.linktoServer();
        launch(args);
    }

    @Override
    public void start(Stage Stage) throws Exception {
        Label work = new Label("工作目录");
    }
}
