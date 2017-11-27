package client.BLservice.Stockman.StockmanWarningblservice;

import client.Vo.goodsVO;
import shared.ResultMessage;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:18 2017/11/26
 */
public interface stockWarning {
    ResultMessage warningMake(goodsVO goods,Long warningnum,String operator,String note,String no);
}
