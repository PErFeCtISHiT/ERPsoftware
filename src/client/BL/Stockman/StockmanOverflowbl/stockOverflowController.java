package client.BL.Stockman.StockmanOverflowbl;

import client.BLservice.Manager.ManagerExamineblservice.ManagerExamine;
import client.BLservice.Stockman.StockmanOverflowblservice.stockOverflow;
import client.RMI.link;
import client.Vo.goodsVO;
import client.Vo.stockexceptionVO;
import shared.ResultMessage;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:41 2017/11/26
 */
public class stockOverflowController implements stockOverflow {
    /**
    *@author:pis
    *@description: 产生单据，总经理审批
    *@date: 15:43 2017/11/26
    */
    @Override
    public ResultMessage OverflowMake(goodsVO goods, Double actualNum, Double systemNum, String operator,String note,String no) throws RemoteException {
        stockexceptionVO stockOverflow = new stockexceptionVO();
        stockOverflow.setKind((double) 8);
        stockOverflow.setGoodsname(goods.getKeyname());
        stockOverflow.setGoodsno(goods.getKeyno());
        stockOverflow.setIscheck((double) 0);
        stockOverflow.setKeyno(no);
        stockOverflow.setIsred("NO");
        stockOverflow.setNote(note);
        stockOverflow.setNuminbase( actualNum);
        stockOverflow.setNuminsys(systemNum);
        stockOverflow.setOper(operator);
        ManagerExamine.acceptBill(stockOverflow);
        return link.getRemoteHelper().getStockOverflowBill().addObject(stockOverflow, 7);
    }
}
