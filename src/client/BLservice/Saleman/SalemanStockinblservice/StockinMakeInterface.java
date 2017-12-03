package client.BLservice.Saleman.SalemanStockinblservice;

import shared.ResultMessage;

import client.Vo.buyinVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/3.
 */
public interface StockinMakeInterface {
    public ResultMessage addBuyinBill(buyinVO vo) throws RemoteException;
    public ResultMessage deleteBuyinBill(buyinVO vo) throws RemoteException;
    public ResultMessage modifyBuyinBill(buyinVO vo) throws RemoteException;
    public ArrayList<buyinVO> findBuyinBill(String keyword);
    public ArrayList<buyinVO> show();

}
