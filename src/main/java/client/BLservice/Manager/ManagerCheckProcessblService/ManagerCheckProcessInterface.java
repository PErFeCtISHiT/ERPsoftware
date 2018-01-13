package client.BLservice.Manager.ManagerCheckProcessblService;

import client.Vo.*;
import server.Po.*;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public interface ManagerCheckProcessInterface {
    public List<buyinPO> showbyingPO() throws RemoteException;

    List<selloutPO> showselloutPO() throws RemoteException;

    List<moneyPO> showmoneyPO() throws RemoteException;

    List<giftPO> showgiftPO() throws RemoteException;

    List<stockexceptionPO> showstockexceptionPO() throws RemoteException;

    List<WarningPO> showwarningPO() throws RemoteException;


}
