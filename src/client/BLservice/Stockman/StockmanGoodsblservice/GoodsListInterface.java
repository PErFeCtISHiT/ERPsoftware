package client.BLservice.Stockman.StockmanGoodsblservice;
import java.rmi.RemoteException;
import java.util.List;
import client.Vo.*;
import shared.ResultMessage;

public interface GoodsListInterface {
    ResultMessage addGoods(goodsVO goods) throws RemoteException;
    ResultMessage deleteGoods(goodsVO goods) throws RemoteException;
    ResultMessage modifyGoods(goodsVO goods) throws RemoteException;
    List findGoods(String keyword) throws RemoteException;
    List findByKind(String kind) throws RemoteException;
    List findAll() throws RemoteException;
}
