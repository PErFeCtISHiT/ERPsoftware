package client.BLservice.Saleman.SalemanSaleblservice;

import client.BL.Saleman.SalemanSaleblservice.SelloutBill;
import client.Vo.selloutVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/3.
 */
public interface SelloutMakeInterface {
    ResultMessage addselloutBill(selloutVO vo) throws RemoteException;
    ResultMessage deleteselloutBill(selloutVO vo) throws RemoteException;
    ResultMessage modifyselloutBill(selloutVO vo) throws RemoteException;
    ArrayList<selloutVO> findselloutBill(String keyword);
    ArrayList<selloutVO> show();
    selloutVO selloutToVo(SelloutBill sellout);
    SelloutBill VoTosellout(selloutVO vo);
}
