package client.BL.Manager.ManagerExamineBillService;

import client.BLservice.Manager.ManagerExamineblservice.ManagerExamineblInterface;
import client.RMI.link;
import client.Vo.*;
import server.Po.*;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public class ManagerExamineController implements ManagerExamineblInterface{
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

    @Override
    public List<buyinPO> searchbyingPO() {
        return null;
    }

    @Override
    public List<selloutPO> searchselloutPO() {
        return null;
    }

    @Override
    public List<moneyPO> searchmoneyPO() {
        return null;
    }

    @Override
    public List<giftPO> searchgiftPO() {
        return null;
    }

    @Override
    public List<stockexceptionPO> serachstockexceptionPO() {
        return null;
    }

    @Override
    public List<WarningPO> searchwarningPO() {
        return null;
    }

    @Override
    public ResultMessage hongchong(buyinVO buyinVO) {
        return null;
    }

    @Override
    public ResultMessage hongchong(selloutVO selloutVO) {
        return null;
    }

    @Override
    public ResultMessage hongchong(moneyVO moneyVO) {
        return null;
    }

    @Override
    public ResultMessage hongchong(giftVO giftVO) {
        return null;
    }

    @Override
    public ResultMessage hongchong(stockexceptionVO stockexceptionVO) {
        return null;
    }

    @Override
    public ResultMessage hongchong(WarningVO warningVO) {
        return null;
    }
}
