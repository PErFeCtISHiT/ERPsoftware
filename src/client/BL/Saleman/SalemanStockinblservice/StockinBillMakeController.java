package client.BL.Saleman.SalemanStockinblservice;

import client.BLservice.Saleman.SalemanStockinblservice.StockinMakeInterface;
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
        return null;
    }

    @Override
    public ResultMessage deleteBuyinBill(buyinVO vo) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage modifyBuyinBill(buyinVO vo) throws RemoteException {
        return null;
    }
}
