package client.BLservice.LogblInterface;

import client.BL.Logbl.Log;
import server.Po.logPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogblInteface {

    public ArrayList<Log> show() throws RemoteException;

    public Log PoToLog(logPO log) throws RemoteException;
}
