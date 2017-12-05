package client.BLservice.Saleman.SalemanStockinblservice;

import shared.ResultMessage;

import client.Vo.buyinVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/3.
 */
public interface StockinMakeInterface {
    ResultMessage addBuyinBill(buyinVO vo) throws RemoteException;
    ResultMessage deleteBuyinBill(buyinVO vo) throws RemoteException;
    ResultMessage modifyBuyinBill(buyinVO vo) throws RemoteException;
    ArrayList<buyinVO> findBuyinBill(String keyword) throws RemoteException;
    ArrayList<buyinVO> show() ;

}
