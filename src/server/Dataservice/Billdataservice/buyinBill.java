package server.Dataservice.Billdataservice;

import server.Dataservice.pubservice.pub;
import server.Po.buyinPO;
import shared.ResultMessage;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:18 2017/11/26
 */
public interface buyinBill extends pub {
    buyinPO buyinfindByNO(String No);
}
