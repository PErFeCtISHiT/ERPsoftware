package client.BL.Manager.ManagerCheckProcessService;
import client.BLservice.Manager.ManagerCheckProcessblService.ManagerCheckProcessInterface;
import client.RMI.link;
import client.Vo.*;
import server.Po.*;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public class BillgottenController implements ManagerCheckProcessInterface{
    @Override
    public List<buyinPO> showbyingPO() throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().findAll(3);

    }


    @Override
    public List<selloutPO> showselloutPO() throws RemoteException
    { return link.getRemoteHelper().getSelloutBill().findAll(4);

    }

    @Override
    public List<moneyPO> showmoneyPO() throws RemoteException {
        return link.getRemoteHelper().getMoneyBill().findAll(5);
    }

    @Override
    public List<giftPO> showgiftPO() throws RemoteException {
        return link.getRemoteHelper().getGiftBill().findAll(6);
    }

    @Override
    public List<stockexceptionPO> showstockexceptionPO() throws RemoteException {
        return link.getRemoteHelper().getStockOverflowBill().findAll(7);
    }

    @Override
    public List<WarningPO> showwarningPO() throws RemoteException {
        return link.getRemoteHelper().getStockwarningBill().findAll(9);
    }


}