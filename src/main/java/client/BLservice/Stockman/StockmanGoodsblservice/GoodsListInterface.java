package client.BLservice.Stockman.StockmanGoodsblservice;

import client.Vo.goodsVO;
import client.Vo.stockGoodsVO;

import java.rmi.RemoteException;
import java.util.List;

public interface GoodsListInterface {
    void addGoods(goodsVO goods) throws RemoteException;

    void deleteGoods(goodsVO goods) throws RemoteException;

    void modifyGoods(goodsVO goods) throws RemoteException;

    List findGoods(String keyword) throws RemoteException;

    List findByKind(String kind) throws RemoteException;

    List findAll() throws RemoteException;

    void stockGoods(stockGoodsVO stockGoodsVO) throws RemoteException;
}
