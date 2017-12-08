package client.BL.Stockman.StockmanWarningbl;

import client.BLservice.Stockman.StockmanWarningblservice.WarningList;
import client.RMI.link;
import client.Vo.WarningVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:18 2017/12/5
 */
public class WarningBillList implements WarningList{
    List<WarningVO> Drafts = new ArrayList<>();

    @Override
    public List getAllDraft() throws RemoteException {
        List<WarningVO> warningVOS = (List<WarningVO>)link.getRemoteHelper().getStockwarningBill().findAll(9);
        for(WarningVO i : warningVOS){
            //if()
        }
        return Drafts;
    }
}
