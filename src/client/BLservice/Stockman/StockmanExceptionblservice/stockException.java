package client.BLservice.Stockman.StockmanExceptionblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:35 2017/11/26
 */
public interface stockException {
    ResultMessage ExceptionMake(goodsVO goods, Double actualNum, String operator,String note,String no,int type) throws RemoteException;
}
