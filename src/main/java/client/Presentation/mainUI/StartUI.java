package client.Presentation.mainUI;

import client.BL.LodinblService.LoginController;
import client.Presentation.AccountantUI.AccountMain.AccountantMain;
import client.Presentation.SalesmanUI.BillMake.newBillUI;
import client.Presentation.StockmanUI.goodsManageUI.goodsKindsManageUI;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.Po.userPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/5.
 */
public class StartUI extends Application{


    public static void main(String[] args){
        link.linktoServer();
        launch(args);
    }

    LoginController controller=new LoginController();

    public void start(Stage stage){
        GridPane grid=new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);

        Scene scene;
        stage.setTitle("登陆");
        stage.setWidth(350);
        stage.setHeight(200);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10);

        Button btn1 = new Button("登录");
        Button btn2 = new Button("注册");

        TextField tfName = new TextField();
        tfName.setPromptText("用户名");
        PasswordField pfPwd = new PasswordField();
        pfPwd.setPromptText("密码");


        btn1.setOnAction((ActionEvent e)->{
            String username=tfName.getText();
            String password=pfPwd.getText();
            try{
                List<userPO> userPOList;
                userPOList=controller.getAlluser(username,password);

               if(userPOList.size() == 1) {
                   userPO thisPO = userPOList.get(0);
                   HBox hBox = null;
                   switch (thisPO.getKeyjob()) {
                       case "stockman":
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

                   }
                   assert hBox != null;
                   Scene scene1 = new Scene(hBox);
                   newBillUI newBillUI = new newBillUI();
                   Scene scene2 = new Scene(newBillUI.start(thisPO));
                   stage.setMaximized(true);
                   stage.setScene(scene2);
               }

                else{
                    pfPwd.clear();
                    Stage failstage=new Stage();
                    Scene failscene=new Scene(new Group());
                    GridPane failpane=new GridPane();
                    Label label=new Label("未查询到该账户!");
                    failpane.getChildren().add(label);
                    ((Group)failscene.getRoot()).getChildren().add(failpane);
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

        btn2.setOnAction((ActionEvent e)->{

        });

        hbButtons.getChildren().addAll(btn1, btn2);
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

        scene=new Scene(grid,10,50);

        stage.setScene(scene);
        stage.show();
    }
}
