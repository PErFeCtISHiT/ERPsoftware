package client.BLservice.Stockman.StockmanExceptionblservice;

import client.Vo.goodsVO;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:35 2017/11/26
 */
public interface stockException {
    void ExceptionMake(goodsVO goods, Double actualNum, String operator, String note, String no, int type) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException;
}
