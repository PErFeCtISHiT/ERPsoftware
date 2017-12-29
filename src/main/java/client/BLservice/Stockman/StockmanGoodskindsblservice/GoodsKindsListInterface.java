package client.BLservice.Stockman.StockmanGoodskindsblservice;

import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public interface GoodsKindsListInterface {
    ResultMessage addgoodskinds(goodskindsVO kind) throws RemoteException;

    ResultMessage deletegoodskinds(goodskindsVO kind) throws RemoteException;

    ResultMessage modify(goodskindsVO kind) throws RemoteException;

    List FindAll() throws RemoteException;
}
