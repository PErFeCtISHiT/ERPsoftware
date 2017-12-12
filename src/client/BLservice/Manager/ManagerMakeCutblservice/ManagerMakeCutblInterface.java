package client.BLservice.Manager.ManagerMakeCutblservice;
import server.Po.*;
import client.Vo.*;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public interface ManagerMakeCutblInterface {
    public List<cutPO> showcutPO() throws RemoteException;
    public void addPO(cutPO po)throws RemoteException;
}
