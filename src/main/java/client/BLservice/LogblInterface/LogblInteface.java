package client.BLservice.LogblInterface;

import client.BL.Logbl.Log;
import server.Po.logPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogblInteface {

    ArrayList<Log> show() throws RemoteException;

    Log PoToLog(logPO log) throws RemoteException;
}
