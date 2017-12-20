package client.BL.Stockman.StockmanExceptionbl;


import client.BLservice.Stockman.StockmanExceptionblservice.stockException;
import client.RMI.link;
import client.Vo.goodsVO;
import client.Vo.logVO;
import client.Vo.stockexceptionVO;
import shared.ResultMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
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
    public ResultMessage ExceptionMake(goodsVO goods, Double actualNum, String operator,String note,String no,int type) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        stockexceptionVO stockOverflow = new stockexceptionVO();
        logVO logVO = new logVO();
        logVO.setKeyjob("库存管理");
        if(type == 0) {//库存报溢
            stockOverflow.setKind((double) 1);
            logVO.setOpno("库存报溢");
        }
        else {//报损
            stockOverflow.setKind((double) 0);
            logVO.setOpno("库存报损");
        }
        stockOverflow.setGoodsname(goods.getKeyname());
        stockOverflow.setGoodsno(goods.getKeyno());
        stockOverflow.setIscheck((double) 0);
        stockOverflow.setKeyno(no);
        stockOverflow.setIsred((double) 0);
        stockOverflow.setNote(note);
        stockOverflow.setNuminbase( actualNum);
        stockOverflow.setNuminsys(goods.getNum());
        stockOverflow.setOper(operator);


        logVO.setGoodsname(goods.getKeyname());
        logVO.setNote(note);
        logVO.setOperatorno(operator);
        link.getRemoteHelper().getLog().addObject(logVO,13);



        return link.getRemoteHelper().getStockOverflowBill().addObject(stockOverflow, 7);
    }
}
