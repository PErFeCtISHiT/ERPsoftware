package client.BL.Saleman.SalemanSaleblservice;

import client.BLservice.Saleman.SalemanSaleblservice.SelloutMakeInterface;
import client.Vo.selloutVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class SelloutBillMakeController implements SelloutMakeInterface {
    @Override
    public ArrayList<selloutVO> findselloutBill(String keyword) {
        return null;
    }

    @Override
    public ArrayList<selloutVO> show() {
        return null;
    }

    @Override
    public ResultMessage addselloutBill(selloutVO vo) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteselloutBill(selloutVO vo) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage modifyselloutBill(selloutVO vo) throws RemoteException {
        return null;
    }

}
