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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.Po.userPO;

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
        stage.setWidth(350);
        stage.setHeight(350);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10);

        Button btn1 = new Button("登录");

        ComboBox<String> tfName = new ComboBox<>();
        tfName.setEditable(true);
        tfName.setPromptText("用户名");
        PasswordField pfPwd = new PasswordField();
        pfPwd.setPromptText("密码");

        List<userPO> userPOS = link.getRemoteHelper().getUser().findAll(15);
        for(userPO userPO : userPOS){
            String id = userPO.getKeyname();
            tfName.getItems().add(id);
        }

        tfName.setOnAction(e -> {
            String password = null;
            try {
                password = link.getRemoteHelper().getUser().getpasswordByName(tfName.getValue());
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            pfPwd.setText(password);
        });

        btn1.setOnAction((ActionEvent e) -> {
            String username = tfName.getValue();
            String password = pfPwd.getText();
            try {
                List<userPO> userPOList;
                userPOList = controller.getAlluser(username, password);

                if (userPOList.size() == 1) {
                    userPO thisPO = userPOList.get(0);
                    HBox hBox = null;
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

                    assert hBox != null;
                    Scene scene1 = new Scene(hBox);
                    stage.setResizable(true);
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


        hbButtons.getChildren().addAll(btn1);
        hbButtons.setAlignment(Pos.CENTER);

        Image image = new Image("logo.png");

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);

        vBox.getChildren().addAll(imageView,tfName,pfPwd,btn1);

        tfName.setMaxSize(100,20);
        pfPwd.setMaxSize(100,20);

        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));

        scene = new Scene(vBox, 10, 50);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
