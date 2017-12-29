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
        } catch (RemoteException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
