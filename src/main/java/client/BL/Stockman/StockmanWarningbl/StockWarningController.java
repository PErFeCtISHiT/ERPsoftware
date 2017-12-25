package client.BL.Stockman.StockmanWarningbl;

import client.BLservice.Stockman.StockmanWarningblservice.stockWarning;
import client.RMI.link;
import client.Vo.WarningVO;
import client.Vo.goodsVO;
import client.Vo.logVO;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:17 2017/11/26
 */
public class StockWarningController implements stockWarning {
    @Override
    public void warningMake(goodsVO goods, String operator, String note, String no) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
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

        logVO logVO = new logVO();
        logVO.setKeyjob("库存管理");
        logVO.setOpno("库存报警");
        logVO.setGoodsname(goods.getKeyname());
        logVO.setNote(note);
        logVO.setOperatorno(operator);
        link.getRemoteHelper().getLog().addObject(logVO,13);

        link.getRemoteHelper().getStockwarningBill().addObject(warningBill, 9);
    }
}
