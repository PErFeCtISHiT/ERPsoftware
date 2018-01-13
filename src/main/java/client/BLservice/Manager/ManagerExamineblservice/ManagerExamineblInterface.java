package client.BLservice.Manager.ManagerExamineblservice;

import client.Vo.*;
import server.Po.*;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public interface ManagerExamineblInterface {
  List<buyinPO> showbyingPO() throws RemoteException;

  List<selloutPO> showselloutPO() throws RemoteException;

  List<moneyPO> showmoneyPO() throws RemoteException;

  List<giftPO> showgiftPO() throws RemoteException;

  List<stockexceptionPO> showstockexceptionPO() throws RemoteException;

  List<WarningPO> showwarningPO() throws RemoteException;

  List<buyinPO> searchbyingPO();

  List<selloutPO> searchselloutPO();

  List<moneyPO> searchmoneyPO();

  List<giftPO> searchgiftPO();

  List<stockexceptionPO> serachstockexceptionPO();

  List<WarningPO> searchwarningPO();

  ResultMessage hongchong(buyinVO buyinVO);

  ResultMessage hongchong(selloutVO selloutVO);

  ResultMessage hongchong(moneyVO moneyVO);

  ResultMessage hongchong(giftVO giftVO);

  ResultMessage hongchong(stockexceptionVO stockexceptionVO);

  ResultMessage hongchong(WarningVO warningVO);
}
