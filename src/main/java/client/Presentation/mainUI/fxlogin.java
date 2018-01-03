package client.Presentation.mainUI;/**
 * @author: pis
 * @description: good good study
 * @date: create in 21:11 2017/12/31
 */

import client.Presentation.AccountantUI.AccountMain.AccountantMain;
import client.Presentation.AdminUI.SetUI;
import client.Presentation.ManageUI.MainManageUI;
import client.Presentation.SalesmanUI.BillMake.newBillUI;
import client.Presentation.StockmanUI.stockmanMainUI.stockmanMainUI;
import client.RMI.link;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.bytedeco.javacpp.presets.opencv_core;
import server.Po.userPO;

public class fxlogin implements Runnable{
    String username;

    public fxlogin(String finalname) {
        username = finalname;
    }

    public static void login(String str) throws Exception {
        userPO thisPO = new userPO();
        Stage stage = new Stage();
        String password = link.getRemoteHelper().getUser().getpasswordByName(str);
        thisPO = (server.Po.userPO) link.getRemoteHelper().getUser().login(str, password).get(0);
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
        stage.show();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            fxlogin.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
