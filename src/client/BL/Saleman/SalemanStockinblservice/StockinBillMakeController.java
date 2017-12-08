package client.BL.Saleman.SalemanStockinblservice;

import client.BLservice.Saleman.SalemanStockinblservice.StockinMakeInterface;
import client.RMI.link;
import client.Vo.buyinVO;
import shared.ResultMessage;
import server.Po.buyinPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class StockinBillMakeController implements StockinMakeInterface {
    @Override
    public List<buyinPO> findBuyinBill(String keyword) {

        return null;
    }

    @Override
    public List<buyinPO> show() throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().findAll(3);
    }

    @Override
    public ResultMessage addBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().addObject(vo,3);//???????????????
    }

    @Override
    public ResultMessage deleteBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().deleteObject(vo,3);
    }

    @Override
    public ResultMessage modifyBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().modifyObject(vo,3);
    }
}
