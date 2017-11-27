package client.BLservice.Stockman.Stockmandamageblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:44 2017/11/26
 */
public interface stockDamage {
    ResultMessage DamageMake(goodsVO goods, int actualNum, int systemNum, String operator,String note,String no) ;
}
