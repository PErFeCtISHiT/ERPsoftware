package server.Dataservice.Goodsdataservice;

import server.Dataservice.pubservice.pub;
import server.Po.goodsPO;
import shared.ResultMessage;

import java.util.List;

public interface Goods extends pub {
    List goodsfindGoods(String keyword) ;
    List goodsfindByKind(String kind);
    List goodsfindAll();
}
