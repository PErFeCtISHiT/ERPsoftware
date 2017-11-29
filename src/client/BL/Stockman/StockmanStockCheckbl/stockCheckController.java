package client.BL.Stockman.StockmanStockCheckbl;

import client.BLservice.Stockman.StockmanStockCheckblservice.stockCheck;
import client.RMI.link;
import client.Vo.goodsVO;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:25 2017/11/26
 */
public class stockCheckController implements stockCheck {
    /**
    *@author:pis
    *@description: 库存盘点，盘点当天商品
    *@date: 15:33 2017/11/26
    */
    @Override
    public List stockCheck(){
        return link.getRemoteHelper().getGoods().goodsfindAll();
    }
}
