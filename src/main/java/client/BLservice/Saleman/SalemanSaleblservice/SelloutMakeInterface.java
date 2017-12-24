package client.BLservice.Saleman.SalemanSaleblservice;

import client.BL.Saleman.SalemanSaleblservice.SelloutBill;
import client.Vo.selloutVO;
import server.Po.selloutPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/3.
 */
public interface SelloutMakeInterface {
    ResultMessage addselloutBill(selloutVO vo) throws RemoteException;
    ResultMessage deleteselloutBill(selloutVO vo) throws RemoteException;
    ResultMessage modifyselloutBill(selloutVO vo) throws RemoteException;
    List findselloutBill(String keyword);
    List show() throws RemoteException;
    selloutVO selloutToVo(SelloutBill sellout);
    SelloutBill VoTosellout(selloutVO vo);
}
