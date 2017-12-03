package client.BLservice.Stockman.StockmanOverflowblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:35 2017/11/26
 */
public interface stockOverflow {
    ResultMessage OverflowMake(goodsVO goods, Double actualNum, Double systemNum, String operator,String note,String no) throws RemoteException;
}
