package client.BL.Stockman.StockmanWarningbl;

import client.BLservice.Manager.ManagerExamineblservice.ManagerExamine;
import client.BLservice.Stockman.StockmanWarningblservice.stockWarning;
import client.RMI.link;
import client.Vo.WarningVO;
import client.Vo.goodsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:17 2017/11/26
 */
public class StockWarningController implements stockWarning {
    @Override
    public ResultMessage warningMake(goodsVO goods, String operator, String note,String no) throws RemoteException {
        WarningVO warningBill = new WarningVO();
        warningBill.setKind((double) 10);
        warningBill.setGoodsname(goods.getKeyname());
        warningBill.setGoodsno(goods.getKeyno());
        warningBill.setIsred((double) 0);
        warningBill.setNote(note);
        warningBill.setWarningnum(goods.getWarningnum());
        warningBill.setNum(goods.getNum());
        warningBill.setOper(operator);
        warningBill.setIscheck((double) 0);
        warningBill.setKeyno(no);
        warningBill.setIsDraft((double) 0);
        return link.getRemoteHelper().getStockwarningBill().addObject(warningBill,9);
    }
}
