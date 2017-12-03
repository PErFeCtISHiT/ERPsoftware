package client.BL.Stockman.StockmanGoodsbl;

import client.BLservice.Stockman.StockmanGoodsblservice.GoodsListInterface;
import client.RMI.link;
import client.Vo.goodsVO;
import server.Po.goodsPO;
import shared.ResultMessage;
import shared.copyclass;

import java.rmi.RemoteException;

import java.util.List;
/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:46 2017/11/23
 */
public class GoodsController implements GoodsListInterface {

    /**
    *@author:pis
    *@description:
    *@date: 19:49 2017/11/23
    */

    @Override
    public ResultMessage addGoods(goodsVO goods) throws RemoteException {
        goodsPO g = new goodsPO();
        copyclass.copy(goods,g);
        return link.getRemoteHelper().getGoods().addObject(g,0);
    }
    /**
    *@author:pis
    *@description:
    *@date: 19:49 2017/11/23
    */
    @Override
    public ResultMessage deleteGoods(goodsVO goods) throws RemoteException{
        goodsPO g = new goodsPO();
        copyclass.copy(goods,g);
        return link.getRemoteHelper().getGoods().deleteObject(g,0);
    }
    /**
    *@author:pis
    *@description:
    *@date: 19:49 2017/11/23
    */
    @Override
    public ResultMessage modifyGoods(goodsVO goods) throws RemoteException{
        goodsPO g = new goodsPO();
        copyclass.copy(goods,g);
        return link.getRemoteHelper().getGoods().modifyObject(g,0);
    }
    /**
    *@author:pis
    *@description: 通过关键词查找商品
    *@date: 19:49 2017/11/23
    */
    @Override
    public List findGoods(String keyword)throws RemoteException {
        return link.getRemoteHelper().getGoods().goodsfindGoods(keyword);
    }
    /**
    *@author:pis
    *@description: 查找该分类下所有商品,返回列表
    *@date: 19:49 2017/11/23
    */
    @Override
    public List findByKind(String kind) throws RemoteException{

        return  link.getRemoteHelper().getGoods().goodsfindByKind(kind);
    }

    /**
    *@author:pis
    *@description: 查找到所有的商品
    *@date: 18:36 2017/11/27
    */
    @Override
    public List findAll() throws RemoteException{
        return link.getRemoteHelper().getGoods().findAll(1);
    }
}