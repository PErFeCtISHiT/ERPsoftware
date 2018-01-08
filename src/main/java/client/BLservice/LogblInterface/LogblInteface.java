package client.BLservice.LogblInterface;

import client.BL.Logbl.Log;
import server.Po.logPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogblInteface {
    /**
     *展示日志
     * @return
     * @throws RemoteException
     */
    ArrayList<Log> show() throws RemoteException;

    /**
     * 类型转化
     * @param log
     * @return
     * @throws RemoteException
     */
    Log PoToLog(logPO log) throws RemoteException;
}
