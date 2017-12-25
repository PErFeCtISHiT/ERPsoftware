package client.BL.Stockman.StockmanStockGlancebl;

import client.BLservice.Stockman.StockmanStockGlanceblservevice.stockGlance;
import client.RMI.link;
import server.Po.goodsOutListPO;
import server.Po.stockGoodsPO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:11 2017/11/26
 */
public class stockGlanceController implements stockGlance {


    /**
    *@author:pis
    *@description: 库存查看
    *@date: 10:11 2017/11/26
     * @param from
     * @param to
    */
    @Override
    public List stockglance(LocalDate from, LocalDate to) throws RemoteException, ParseException {
        List<stockGoodsPO> withBase = link.getRemoteHelper().getstockGoods().findAll(19);
        List<goodsOutListPO> withConsumer = link.getRemoteHelper().getgoodsoutList().findAll(17);
        List<stockGoodsPO> basetoadd = new ArrayList<>();
        List<goodsOutListPO> consumertoadd = new ArrayList<>();
        for(stockGoodsPO i : withBase){
            String temp = i.getKeyno();
            String dat = temp.split("-")[1];
            dat = dat.substring(0,4) + "-" + dat.substring(4,6) + "-" + dat.substring(6);
            LocalDate between = LocalDate.parse(dat);
            if(between.compareTo(from) >= 0 && between.compareTo(to) <= 0)
                basetoadd.add(i);
        }
        for(goodsOutListPO i : withConsumer){
            String temp = i.getKeyno();
            String dat = temp.split("-")[1];
            dat = dat.substring(0,4) + "-" + dat.substring(4,6) + "-" + dat.substring(6);
            LocalDate between = LocalDate.parse(dat);
            if(between.compareTo(from) >= 0 && between.compareTo(to) <= 0)
                consumertoadd.add(i);
        }
        List<Object> ret = new ArrayList<>();
        ret.add(basetoadd);
        ret.add(consumertoadd);
        return ret;
    }
}
