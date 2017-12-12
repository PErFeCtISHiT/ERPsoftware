package client.BLservice.Manager.ManagerMakeCutblservice;

import server.Po.packPO;

import java.rmi.RemoteException;
import java.util.List;

public interface ManagerMakeCutInterfaceForPack {
    public List<packPO> showpackPO()throws RemoteException;
}
