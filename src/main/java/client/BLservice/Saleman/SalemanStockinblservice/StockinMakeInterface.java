package client.BLservice.Saleman.SalemanStockinblservice;

import client.BL.Saleman.SalemanStockinblservice.StockinBill;
import shared.ResultMessage;

import client.Vo.buyinVO;
import server.Po.buyinPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/3.
 */
public interface StockinMakeInterface {
    ResultMessage addBuyinBill(buyinVO vo) throws RemoteException;
    ResultMessage deleteBuyinBill(buyinVO vo) throws RemoteException;
    ResultMessage modifyBuyinBill(buyinVO vo) throws RemoteException;
    List findBuyinBill(String keyword) throws RemoteException;
    List show() throws RemoteException;
    buyinVO billtovo(StockinBill stockinBill);
    StockinBill votoBill(buyinVO vo);
}
