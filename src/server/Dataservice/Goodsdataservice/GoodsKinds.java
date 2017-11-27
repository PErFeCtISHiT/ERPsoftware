package server.Dataservice.Goodsdataservice;

import server.Dataservice.pubservice.pub;
import server.Po.goodskindsPO;
import shared.ResultMessage;

import java.util.List;

public interface GoodsKinds extends pub {
    List goodsKindsFindAll();
    List goodsKindsFind(String keyword);
}
