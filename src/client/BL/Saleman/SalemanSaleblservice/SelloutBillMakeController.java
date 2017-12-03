package client.BL.Saleman.SalemanSaleblservice;

import client.BLservice.Saleman.SalemanSaleblservice.SelloutMakeInterface;
import client.RMI.link;
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
        return link.getRemoteHelper().getSelloutBill().addObject(vo, 10);
    }

    @Override
    public ResultMessage deleteselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().deleteObject(vo, 10);
    }

    @Override
    public ResultMessage modifyselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().modifyObject(vo, 10);
    }

    @Override
    public SelloutBill VoTosellout(selloutVO vo) {
        return null;

    }

    @Override
    public selloutVO selloutToVo(SelloutBill sellout) {
        return null;
    }
}
