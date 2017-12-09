package client.BLservice.Stockman.StockmanWarningblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:18 2017/11/26
 */
public interface stockWarning {
    ResultMessage warningMake(goodsVO goods,String operator,String note,String no) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException;
}
