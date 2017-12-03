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
    public ResultMessage addselloutBill(selloutVO vo) throws RemoteException;
    public ResultMessage deleteselloutBill(selloutVO vo) throws RemoteException;
    public ResultMessage modifyselloutBill(selloutVO vo) throws RemoteException;
    public ArrayList<selloutVO> findselloutBill(String keyword);
    public ArrayList<selloutVO> show();
    public selloutVO selloutToVo(SelloutBill sellout);
    public SelloutBill VoTosellout(selloutVO vo);
}
