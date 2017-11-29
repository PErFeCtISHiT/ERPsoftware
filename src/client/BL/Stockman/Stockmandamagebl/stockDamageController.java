package client.BL.Stockman.Stockmandamagebl;

import client.BLservice.Manager.ManagerExamineblservice.ManagerExamine;
import client.BLservice.Stockman.Stockmandamageblservice.stockDamage;
import client.RMI.link;
import client.Vo.goodsVO;
import client.Vo.stockexceptionVO;
import shared.ResultMessage;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:44 2017/11/26
 */
public class stockDamageController implements stockDamage {
    /**
    *@author:pis
    *@description: 同报溢
    *@date: 15:45 2017/11/26
    */
    @Override
    public ResultMessage DamageMake(goodsVO goods, int actualNum, int systemNum, String operator,String note,String no) {
        stockexceptionVO stockDamage = new stockexceptionVO();
        stockDamage.setKind((long) 9);
        stockDamage.setGoodsname(goods.getKeyname());
        stockDamage.setGoodsno(goods.getKeyno());
        stockDamage.setIscheck((long) 0);
        stockDamage.setIsred("NO");
        stockDamage.setNote(note);
        stockDamage.setNuminbase((long) actualNum);
        stockDamage.setNuminsys((long) systemNum);
        stockDamage.setOper(operator);
        stockDamage.setKeyno(no);
        ManagerExamine.acceptBill(stockDamage);
        return link.getRemoteHelper().getStockDamageBill().addObject(stockDamage,7);

    }
}
