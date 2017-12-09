package client.BL.Stockman.StockmanStockGlancebl;

import client.BLservice.Stockman.StockmanStockGlanceblservevice.stockGlance;
import client.RMI.link;
import server.Po.goodsOutListPO;
import server.Po.stockGoodsPO;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:11 2017/11/26
 */
public class stockGlanceController implements stockGlance {
    private List<stockGoodsPO> withBase;
    private List<goodsOutListPO> withConsumer;
    private List<stockGoodsPO> Basetoadd;
    private List<goodsOutListPO> Consumertoadd;


    /**
    *@author:pis
    *@description: 库存查看
    *@date: 10:11 2017/11/26
     * @param from
     * @param to
    */
    @Override
    public List stockglance(LocalDate from, LocalDate to) throws RemoteException, ParseException {
        withBase = link.getRemoteHelper().getstockGoods().findAll(19);
        withConsumer = link.getRemoteHelper().getgoodsoutList().findAll(17);
        Basetoadd = new ArrayList<>();
        Consumertoadd = new ArrayList<>();
        for(stockGoodsPO i : withBase){
            String temp = i.getKeyno();
            String dat = temp.split("-")[1];
            dat = dat.substring(0,4) + "-" + dat.substring(4,6) + "-" + dat.substring(6);
            LocalDate between = LocalDate.parse(dat);
            if(between.compareTo(from) >= 0 && between.compareTo(to) <= 0)
                Basetoadd.add(i);
        }
        for(goodsOutListPO i : withConsumer){
            String temp = i.getKeyno();
            String dat = temp.split("-")[1];
            dat = dat.substring(0,4) + "-" + dat.substring(4,6) + "-" + dat.substring(6);
            LocalDate between = LocalDate.parse(dat);
            if(between.compareTo(from) >= 0 && between.compareTo(to) <= 0)
                Consumertoadd.add(i);
        }
        List<Object> ret = new ArrayList<>();
        ret.add(Basetoadd);
        ret.add(Consumertoadd);
        return ret;
    }
}
