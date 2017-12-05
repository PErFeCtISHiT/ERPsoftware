package client.BL.Saleman.SalemanStockinblservice;

import client.BLservice.Saleman.SalemanStockinblservice.StockinMakeInterface;
import client.RMI.link;
import client.Vo.buyinVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class StockinBillMakeController implements StockinMakeInterface {
    @Override
    public ArrayList<buyinVO> findBuyinBill(String keyword) {

        return null;
    }

    @Override
    public ArrayList<buyinVO> show() {
        return null;
    }

    @Override
    public ResultMessage addBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().addObject(vo,10);//???????????????
    }

    @Override
    public ResultMessage deleteBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().deleteObject(vo,10);
    }

    @Override
    public ResultMessage modifyBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().modifyObject(vo,10);
    }
}
