package client.BL.Stockman.StockmanGoodskindsbl;

import client.BLservice.Stockman.StockmanGoodskindsblservice.GoodsKindsListInterface;
import client.RMI.link;
import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:52 2017/11/23
 */
public class GoodsKindsController implements GoodsKindsListInterface {
    @Override
    public ResultMessage addgoodskinds(goodskindsVO kind) {
        return null;
    }

    @Override
    public ResultMessage deletegoodskinds(goodskindsVO kind) {
        return null;
    }

    @Override
    public ResultMessage modify(goodskindsVO kind) {
        return null;
    }
    /**
    *@author:pis
    *@description:查找所有商品分类，返回list
    *@date: 19:53 2017/11/23
    */
    @Override
    public List FindAll() {
        return link.getRemoteHelper().getGoodsKinds().goodsKindsFindAll();
    }
}
