package client.BL.Stockman.StockmanGoodsbl;
/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:46 2017/11/23
 */
import client.BLservice.Stockman.StockmanGoodsblservice.GoodsListInterface;
import client.RMI.link;
import client.Vo.goodsVO;
import shared.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class GoodsController implements GoodsListInterface {
    /**
    *@author:pis
    *@description:
    *@date: 19:49 2017/11/23
    */
    @Override
    public ResultMessage addGoods(goodsVO goods) {
        return null;
    }
    /**
    *@author:pis
    *@description:
    *@date: 19:49 2017/11/23
    */
    @Override
    public ResultMessage deleteGoods(goodsVO goods) {
        return null;
    }
    /**
    *@author:pis
    *@description:
    *@date: 19:49 2017/11/23
    */
    @Override
    public ResultMessage modifyGoods(goodsVO goods) {
        return null;
    }
    /**
    *@author:pis
    *@description:
    *@date: 19:49 2017/11/23
    */
    @Override
    public List findGoods(String keyword) {
        return null;
    }
    /**
    *@author:pis
    *@description: 查找该分类下所有商品,返回列表
    *@date: 19:49 2017/11/23
    */
    @Override
    public List findByKind(String kind) {

        return (List<goodsVO>) link.getRemoteHelper().getGoods().goodsfindByKind(kind);
    }

    /**
    *@author:pis
    *@description: 查找到所有的商品
    *@date: 18:36 2017/11/27
    */
    @Override
    public List findAll() {
        return null;
    }
}