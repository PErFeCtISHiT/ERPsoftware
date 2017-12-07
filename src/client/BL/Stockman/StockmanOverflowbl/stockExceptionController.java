package client.BL.Stockman.StockmanOverflowbl;


import client.BLservice.Stockman.StockmanExceptionblservice.stockException;

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
public class stockExceptionController implements stockException {
    /**
    *@author:pis
    *@description: 产生单据，总经理审批
    *@date: 15:43 2017/11/26
    */
    @Override
    public ResultMessage ExceptionMake(goodsVO goods, Double actualNum, String operator,String note,String no,int type) throws RemoteException {
        stockexceptionVO stockOverflow = new stockexceptionVO();
        if(type == 0)
        stockOverflow.setKind((double) 8);
        else
            stockOverflow.setKind((double) 9);
        stockOverflow.setGoodsname(goods.getKeyname());
        stockOverflow.setGoodsno(goods.getKeyno());
        stockOverflow.setIscheck((double) 0);
        stockOverflow.setKeyno(no);
        stockOverflow.setIsred((double) 0);
        stockOverflow.setNote(note);
        stockOverflow.setNuminbase( actualNum);
        stockOverflow.setNuminsys(goods.getNum());
        stockOverflow.setOper(operator);
        return link.getRemoteHelper().getStockOverflowBill().addObject(stockOverflow, 7);
    }
}
