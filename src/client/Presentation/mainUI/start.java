package client.Presentation.mainUI;

import client.Presentation.AccountantUI.AccountMain.Accountant;

import client.Presentation.StockmanUI.Stockman;

import client.RMI.RemoteHelper;
import client.RMI.link;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;

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

        turnToStockman.setOnAction(e -> {
            try {
                turntoStockman();
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });

        Button turnToAccountant = new Button("turn to Accountant");

        turnToAccountant.setOnAction(e -> {
            try {
                turntoAccountant();
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });



        v.getChildren().add(turnToStockman);

        v.getChildren().add(turnToAccountant);

        Scene scene = new Scene(v, 700, 700);

        scene.getStylesheets().add("/source/csscfg.css");

        login.setScene(scene);
        login.setMaximized(true);

        login.show();

    }



    private void turntoStockman() throws RemoteException{

        Stockman.start();

        login.close();

    }



    private void turntoAccountant() throws RemoteException{

        Accountant.start();

        login.close();

    }





}