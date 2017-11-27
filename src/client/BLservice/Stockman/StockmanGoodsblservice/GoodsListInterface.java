package client.BLservice.Stockman.StockmanGoodsblservice;
import java.util.List;
import client.Vo.*;
import shared.ResultMessage;

public interface GoodsListInterface {
    ResultMessage addGoods(goodsVO goods);
    ResultMessage deleteGoods(goodsVO goods);
    ResultMessage modifyGoods(goodsVO goods);
    List findGoods(String keyword);
    List findByKind(String kind);
    List findAll();
}
