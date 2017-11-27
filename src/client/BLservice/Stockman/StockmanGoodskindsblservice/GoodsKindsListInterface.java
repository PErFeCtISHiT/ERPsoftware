package client.BLservice.Stockman.StockmanGoodskindsblservice;

import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.util.List;

public interface GoodsKindsListInterface {
    public ResultMessage addgoodskinds(goodskindsVO kind);
    public ResultMessage deletegoodskinds(goodskindsVO kind);
    public ResultMessage modify(goodskindsVO kind);
    public List FindAll();
}
