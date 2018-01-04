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
    Stage stage;

    public fxlogin(String finalname,Stage stage) {
        this.username = finalname;
        this.stage = stage;
    }

    public static void login(String str,Stage stage) throws Exception {
        userPO thisPO ;
        String password = link.getRemoteHelper().getUser().getpasswordByName(str);
        thisPO = (server.Po.userPO) link.getRemoteHelper().getUser().login(str, password).get(0);
        StartUI startUI = new StartUI();
        startUI.login(thisPO,stage);
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
            fxlogin.login(username,stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
