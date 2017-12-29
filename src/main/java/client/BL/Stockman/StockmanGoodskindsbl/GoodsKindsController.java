package client.BL.Stockman.StockmanGoodskindsbl;

import client.BLservice.Stockman.StockmanGoodskindsblservice.GoodsKindsListInterface;
import client.RMI.link;
import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:52 2017/11/23
 */
public class GoodsKindsController implements GoodsKindsListInterface {
    @Override
    public ResultMessage addgoodskinds(goodskindsVO kind) throws RemoteException {
        return link.getRemoteHelper().getGoodsKinds().addObject(kind, 1);
    }

    @Override
    public ResultMessage deletegoodskinds(goodskindsVO kind) throws RemoteException {
        return link.getRemoteHelper().getGoodsKinds().deleteObject(kind, 1);
    }

    @Override
    public ResultMessage modify(goodskindsVO kind) throws RemoteException {
        return link.getRemoteHelper().getGoodsKinds().modifyObject(kind, 1);
    }

    /**
     * @author:pis
     * @description:查找所有商品分类，返回list
     * @date: 19:53 2017/11/23
     */
    @Override
    public List FindAll() throws RemoteException {
        return link.getRemoteHelper().getGoodsKinds().findAll(1);
    }
}
