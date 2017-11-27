package client.BLservice.Stockman.StockmanOverflowblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:35 2017/11/26
 */
public interface stockOverflow {
    ResultMessage OverflowMake(goodsVO goods, int actualNum, int systemNum, String operator,String note,String no);
}
