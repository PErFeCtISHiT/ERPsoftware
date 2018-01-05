package client.Presentation.mainUI;

import client.BL.LodinblService.LoginController;
import client.Presentation.AccountantUI.AccountMain.AccountantMain;
import client.Presentation.AccountantUI.LogCheck.LogCheckUI;
import client.Presentation.AdminUI.SetUI;
import client.Presentation.ManageUI.MainManageUI;
import client.Presentation.SalesmanUI.BillMake.newBillUI;
import client.Presentation.StockmanUI.stockmanMainUI.stockmanMainUI;
import client.RMI.link;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import server.Po.userPO;
import shared.Camera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/5.
 */
public class StartUI extends Application {


    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }

    private LoginController controller = new LoginController();

    public void start(Stage stage) throws RemoteException {



        VBox vBox = new VBox();

        Scene scene;
        stage.setTitle("登陆");
        stage.setWidth(600);
        stage.setHeight(390);


        HBox hbButtons = new HBox();
        hbButtons.setSpacing(20);

        Button btn1 = new Button("登录");
        btn1.setMinSize(150, 40);
        btn1.setStyle("-fx-background-color: deepskyblue;-fx-font: 100;-fx-text-fill: white");
        Button btn2 = new Button("刷脸登陆");
        btn2.setMinSize(150, 40);
        btn2.setStyle("-fx-background-color: deepskyblue;-fx-font: 100;-fx-text-fill: white");
        //       ComboBox<String> tfName = new ComboBox<>();

        Button exit = new Button("退出");
        exit.setStyle("-fx-background-color: transparent;-fx-border-color: transparent;-fx-text-fill: deepskyblue");
        exit.setUnderline(true);
        exit.setOnAction((ActionEvent v1) -> {
            stage.close();
        });

        TextField tfName = new TextField();

        tfName.setEditable(true);

        PasswordField pfPwd = new PasswordField();



        tfName.setMinWidth(400);
        pfPwd.setMinWidth(400);
        tfName.setStyle("-fx-prompt-text-fill: darkgray;-fx-border-color: transparent;-fx-font-size: 35;-fx-background-color: transparent");
        pfPwd.setStyle("-fx-prompt-text-fill: darkgray;-fx-border-color: transparent;-fx-font-size: 35;-fx-background-color: transparent");

        Line line1 = new Line(0, 100, 400, 100);

        Line line2 = new Line(0, 100, 400, 100);



        btn1.setOnAction((ActionEvent e) -> {
            String username = tfName.getText();
            String password = pfPwd.getText();
            try {
                List<userPO> userPOList;
                userPOList = controller.getAlluser(username, password);

                if (userPOList.size() == 1) {
                    userPO thisPO = userPOList.get(0);
                    login(thisPO, stage);
                    pfPwd.clear();
                } else {
                    pfPwd.clear();
                    Stage failstage = new Stage();
                    Scene failscene = new Scene(new Group());
                    GridPane failpane = new GridPane();
                    Label label = new Label("未查询到该账户!");
                    failpane.getChildren().add(label);
                    ((Group) failscene.getRoot()).getChildren().add(failpane);
                    failstage.setScene(failscene);
                    failstage.setWidth(200);
                    failstage.setHeight(90);
                    failstage.setTitle("登录失败");
                    failstage.show();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btn2.setOnAction(e -> {
            stage.setIconified(true);
            try {
                Facelogin(stage);
                stage.close();
            } catch (InterruptedException | IOException e1) {
                e1.printStackTrace();
            }
        });

        hbButtons.getChildren().addAll(btn1, btn2, exit);
        hbButtons.setAlignment(Pos.CENTER);


        vBox.getChildren().addAll(tfName, line1, pfPwd, line2, hbButtons);

        tfName.setMaxSize(150, 20);
        pfPwd.setMaxSize(150, 20);

        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-image: url(ba.png)");
        scene = new Scene(vBox, 400, 500);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    public void login(userPO thisPO, Stage stage) throws Exception {

        if (stage != null)
            stage.close();

        Stage showstage = new Stage();

        MenuBar topBar = new MenuBar();
        Menu nameMenu = new Menu(thisPO.getKeyname(), new ImageView(new Image("tou1.png")));

        Menu helpMenu = new Menu("需要帮助?");
        topBar.getMenus().addAll(nameMenu, helpMenu);

        MenuItem check = new MenuItem("查看资料");
        MenuItem logcheck = new MenuItem("查看工作情况");
        MenuItem exit = new MenuItem("退出");
        nameMenu.getItems().addAll(check, logcheck, new SeparatorMenuItem(), exit);

        exit.setOnAction((ActionEvent e) -> {
            showstage.close();
            assert stage != null;
            stage.show();
        });

        logcheck.setOnAction((ActionEvent e) -> {

            Stage logcheckStage = new Stage();

            LogCheckUI logCheckUI = new LogCheckUI();
            VBox box = new VBox();
            try {
                box = logCheckUI.start();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            logcheckStage.setWidth(630);
            logcheckStage.setHeight(400);
            Scene log = new Scene(box);
            logcheckStage.setScene(log);
            logcheckStage.show();
        });


        HBox hBox = new HBox();
        hBox.setMinWidth(1400);
        hBox.setMinHeight(650);
        switch (thisPO.getKeyjob()) {
            case "stockman":
                stockmanMainUI stockmanMainUI = new stockmanMainUI();
                hBox = stockmanMainUI.start(thisPO);

                break;
            case "accountant":
                AccountantMain accountantMain = new AccountantMain();
                hBox = accountantMain.start(thisPO);
                break;
            case "saleman":
                newBillUI newBillUI = new newBillUI();
                hBox = newBillUI.start(thisPO);
                break;
            case "manager":
                MainManageUI mainManageUI = new MainManageUI();
                hBox = mainManageUI.start(thisPO);
                break;
            case "admin":
                SetUI setUI = new SetUI();
                hBox = setUI.start(thisPO);
                break;
        }


        VBox fbox = new VBox();
        fbox.setMinSize(1400, 650);
        Scene scene1 = new Scene(fbox, 1400, 650);
        ((VBox) scene1.getRoot()).getChildren().addAll(topBar, hBox);
        scene1.getStylesheets().add("background.css");
        showstage.setResizable(true);
        showstage.setMaximized(true);
        showstage.setWidth(1400);
        showstage.setHeight(650);
        showstage.setScene(scene1);
        showstage.show();
    }


    private void Facelogin(Stage stage) throws IOException, InterruptedException {

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(1);
        grabber.setImageWidth(500);
        grabber.setImageHeight(660);
        grabber.start();

        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        opencv_core.IplImage grabbedImage = converter.convertToIplImage(grabber.grab());
        CanvasFrame frame = new CanvasFrame("Softer", CanvasFrame.getDefaultGamma() / grabber.getGamma());

        JPanel contentPane = new JPanel();
        Container contentPane2 = frame.getContentPane();


        JButton save_photo = new JButton("登录");
        JButton cancle = new JButton("关闭");
        Camera camera = new Camera();
        save_photo.addMouseListener(new SavePhotoMouseAdapter(grabbedImage, frame,stage));

        cancle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                frame.dispose();
                frame.setVisible(false);
            }
        });


        contentPane.add(save_photo, BorderLayout.SOUTH);

        contentPane.add(cancle, BorderLayout.SOUTH);

        contentPane2.add(contentPane, BorderLayout.SOUTH);

        while (frame.isVisible()) {


            if (camera.getState()) {
                grabbedImage = converter.convert(grabber.grab());
            }
            frame.showImage(converter.convert(grabbedImage));
            Thread.sleep(40);
        }

        grabber.stop();
        frame.dispose();

    }


}


