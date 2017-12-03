package client.BL.Stockman.StockmanStockGlancebl;

import client.BLservice.Stockman.StockmanStockGlanceblservevice.stockGlance;
import client.RMI.link;
import client.Vo.buyinVO;
import client.Vo.selloutVO;
import server.Po.buyinPO;
import server.Po.selloutPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:11 2017/11/26
 */
public class stockGlanceController implements stockGlance {
    private List<buyinPO> withBase = new ArrayList<>();
    private List<selloutPO> withConsumer = new ArrayList<>();


    /**
    *@author:pis
    *@description: 库存查看
    *@date: 10:11 2017/11/26
    */
    @Override
    public List stockglance(String from,String to) throws RemoteException {
        List<String> billNo = link.getRemoteHelper().getLog().logstockGlance(from,to);
        for (String s : billNo) {
            List temp = link.getRemoteHelper().getBuyinBill().findbyNO(3,s);
            if(!temp.isEmpty())
                withBase.add((buyinPO) temp.get(0));
            temp = link.getRemoteHelper().getBuyinBill().findbyNO(4,s);
            if(!temp.isEmpty())
                withConsumer.add((selloutPO) temp.get(0));
        }
        List<Object> ret = new ArrayList<>();
        ret.add(withBase);
        ret.add(withConsumer);
        return ret;
    }
}
