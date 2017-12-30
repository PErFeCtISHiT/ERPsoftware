package client.Presentation.mainUI;

import client.BL.LodinblService.LoginController;
import client.Presentation.AccountantUI.AccountMain.AccountantMain;
import client.Presentation.AdminUI.SetUI;
import client.Presentation.ManageUI.MainManageUI;
import client.Presentation.SalesmanUI.BillMake.newBillUI;
import client.Presentation.StockmanUI.stockmanMainUI.stockmanMainUI;
import client.RMI.link;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import server.Po.userPO;

import java.util.List;

/**
 * Created by Leonarda on 2017/12/5.
 */
public class StartUI extends Application {

    public static void main(String[] args) {
        link.linktoServer();
        launch(args);
    }

    LoginController controller = new LoginController();

    public void start(Stage stage) {

//        Group root = new Group();
//        Scene scene = new Scene(root, 800, 600, Color.BLACK);
//        primaryStage.setScene(scene);
//        Group circles = new Group();
//        for (int i = 0; i < 30; i++) {
//            Circle circle = new Circle(150, Color.web("white", 0.05));
//            circle.setStrokeType(StrokeType.OUTSIDE);
//            circle.setStroke(Color.web("white", 0.16));
//            circle.setStrokeWidth(4);
//            circles.getChildren().add(circle);
//        }
//        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
//                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{
//                        new Stop(0, Color.web("#f8bd55")),
//                        new Stop(0.14, Color.web("#c0fe56")),
//                        new Stop(0.28, Color.web("#5dfbc1")),
//                        new Stop(0.43, Color.web("#64c2f8")),
//                        new Stop(0.57, Color.web("#be4af7")),
//                        new Stop(0.71, Color.web("#ed5fc2")),
//                        new Stop(0.85, Color.web("#ef504c")),
//                        new Stop(1, Color.web("#f2660f")),}));
//        Group blendModeGroup =
//                new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
//                        Color.BLACK), circles), colors);
//        colors.setBlendMode(BlendMode.OVERLAY);
//        root.getChildren().add(blendModeGroup);
//        circles.setEffect(new BoxBlur(10, 10, 3));
//        Timeline timeline = new Timeline();
//        for (Node circle : circles.getChildren()) {
//            timeline.getKeyFrames().addAll(
//                    new KeyFrame(Duration.ZERO, // set start position at 0
//                            new KeyValue(circle.translateXProperty(), random() * 800),
//                            new KeyValue(circle.translateYProperty(), random() * 600)),
//                    new KeyFrame(new Duration(40000), // set end position at 40s
//                            new KeyValue(circle.translateXProperty(), random() * 800),
//                            new KeyValue(circle.translateYProperty(), random() * 600)));
//        }
//        // play 40s of animation
//        timeline.play();
//
//        primaryStage.show();


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(40);

        Scene scene;
 //       stage.setTitle("登陆");
        stage.setWidth(500);
        stage.setHeight(657);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10);

        Button btn1 = new Button("登录");
//        Button btn2 = new Button("注册");

        TextField tfName = new TextField();
        tfName.setPromptText("用户名");
        PasswordField pfPwd = new PasswordField();
        pfPwd.setPromptText("密码");

        tfName.setMinWidth(400);
        pfPwd.setMinWidth(400);
//        tfName.setMinHeight(200);
        tfName.setStyle("-fx-prompt-text-fill: darkgray;-fx-border-color: transparent;-fx-font-size: 35;-fx-background-color: transparent");
        pfPwd.setStyle("-fx-prompt-text-fill: darkgray;-fx-border-color: transparent;-fx-font-size: 35;-fx-background-color: transparent");

        btn1.setOnAction((ActionEvent e) -> {
            String username = tfName.getText();
            String password = pfPwd.getText();
            try {
                List<userPO> userPOList;
                userPOList = controller.getAlluser(username, password);

                if (userPOList.size() == 1) {
                    userPO thisPO = userPOList.get(0);
                    HBox hBox = null;
                    switch (thisPO.getKeyjob()) {
                        case "stockman":
                            ;
                            stockmanMainUI stockmanMainUI = new stockmanMainUI();
                            hBox = stockmanMainUI.start(thisPO);
                            break;
                        case "accnoutant":
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

                    assert hBox != null;
                    Scene scene1 = new Scene(hBox);
                    stage.setMaximized(true);
                    stage.setScene(scene1);
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
        btn1.setStyle("-fx-text-fill: #a9a6a5;-fx-font: 40;-fx-background-color: #e4e9ee");

        hbButtons.getChildren().addAll(btn1);
        hbButtons.setAlignment(Pos.CENTER);

        grid.add(tfName, 1, 0);
        grid.add(pfPwd, 1, 1);
        grid.add(hbButtons, 0, 2, 2, 1);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column2);

        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-image: url(timg.jpeg)");


        scene = new Scene(grid, 400, 500);
//        scene.setFill(Color.CORNSILK);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);


        stage.show();
    }
}
