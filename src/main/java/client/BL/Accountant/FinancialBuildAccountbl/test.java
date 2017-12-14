package client.BL.Accountant.FinancialBuildAccountbl;

import client.RMI.link;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

public class test {


    public static void main(String[] args) {
        link.linktoServer();
        try {
            link.getRemoteHelper().getaccountInit().Build("2017");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        launch(args);
    }


}
