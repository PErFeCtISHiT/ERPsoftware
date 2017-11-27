package client.Presentation.mainUI;

import client.Presentation.AccountantUI.Accountant;

import client.Presentation.StockmanUI.Stockman;

import client.RMI.RemoteHelper;
import client.RMI.link;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.layout.StackPane;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class start extends Application {



    private Stage login;
    private static RemoteHelper remoteHelper;


    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
        
    }



    @Override

    public void start(Stage primaryStage) throws Exception {

        login = new Stage();

        VBox v = new VBox();

        Button turnToStockman = new Button("turn to stockman");

        turnToStockman.setOnAction(e -> turntoStockman());

        Button turnToAccountant = new Button("turn to Accountant");

        turnToAccountant.setOnAction(e -> turntoAccountant());



        v.getChildren().add(turnToStockman);

        v.getChildren().add(turnToAccountant);

        Scene scene = new Scene(v, 700, 700);

        scene.getStylesheets().add("/source/csscfg.css");

        login.setScene(scene);
        login.setMaximized(true);

        login.show();

    }



    private void turntoStockman() {

        Stockman.start();

        login.close();

    }



    private void turntoAccountant() {

        Accountant.start();

        login.close();

    }





}