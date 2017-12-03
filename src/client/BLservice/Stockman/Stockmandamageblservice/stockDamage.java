package client.BLservice.Stockman.Stockmandamageblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:44 2017/11/26
 */
public interface stockDamage {
    ResultMessage DamageMake(goodsVO goods, Double actualNum, Double systemNum, String operator,String note,String no) throws RemoteException;
}
