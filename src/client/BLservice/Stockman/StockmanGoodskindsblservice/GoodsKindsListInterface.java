package client.BLservice.Stockman.StockmanGoodskindsblservice;

import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public interface GoodsKindsListInterface {
    public ResultMessage addgoodskinds(goodskindsVO kind) throws RemoteException;
    public ResultMessage deletegoodskinds(goodskindsVO kind) throws RemoteException;
    public ResultMessage modify(goodskindsVO kind) throws RemoteException;
    public List FindAll() throws RemoteException;
}
