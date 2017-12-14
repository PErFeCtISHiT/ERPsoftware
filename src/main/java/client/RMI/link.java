package client.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 20:03 2017/11/27
 */
public class link {
    private static RemoteHelper remoteHelper = RemoteHelper.getInstance();
    public static RemoteHelper getRemoteHelper(){
        return remoteHelper;
    }
    public static void linktoServer(){
        try {


            remoteHelper.setRemote(Naming.lookup("rmi://127.0.0.1:8886/DataRemoteObject"));

        } catch (MalformedURLException | RemoteException | NotBoundException e) {

            e.printStackTrace();

        }
    }
}
