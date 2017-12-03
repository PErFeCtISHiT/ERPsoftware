package client.BLservice.Stockman.StockmanWarningblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:18 2017/11/26
 */
public interface stockWarning {
    ResultMessage warningMake(goodsVO goods,Double warningnum,String operator,String note,String no) throws RemoteException;
}
