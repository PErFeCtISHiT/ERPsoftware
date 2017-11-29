package client.BL.Stockman.StockmanWarningbl;

import client.BLservice.Manager.ManagerExamineblservice.ManagerExamine;
import client.BLservice.Stockman.StockmanWarningblservice.stockWarning;
import client.RMI.link;
import client.Vo.WarningVO;
import client.Vo.goodsVO;
import shared.ResultMessage;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:17 2017/11/26
 */
public class StockWarningController implements stockWarning {
    @Override
    public ResultMessage warningMake(goodsVO goods, Long warningnum, String operator, String note,String no) {
        WarningVO warningBill = new WarningVO();
        warningBill.setKind((long) 10);
        warningBill.setGoodsname(goods.getKeyname());
        warningBill.setGoodsno(goods.getKeyno());
        warningBill.setIsred((long) 0);
        warningBill.setNote(note);
        warningBill.setWarningnum(warningnum);
        warningBill.setNum(goods.getNum());
        warningBill.setOper(operator);
        warningBill.setIscheck((long) 0);
        warningBill.setKeyno(no);
        ManagerExamine.acceptBill(warningBill);
        return link.getRemoteHelper().getStockwarningBill().addObject(warningBill,9);
    }
}
