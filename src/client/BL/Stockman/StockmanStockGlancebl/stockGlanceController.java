package client.BL.Stockman.StockmanStockGlancebl;

import client.BLservice.Stockman.StockmanStockGlanceblservevice.stockGlance;
import client.RMI.link;
import client.Vo.buyinVO;
import client.Vo.selloutVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:11 2017/11/26
 */
public class stockGlanceController implements stockGlance {
    private List<buyinVO> withBase = new ArrayList<>();
    private List<selloutVO> withConsumer = new ArrayList<>();
    /**
    *@author:pis
    *@description: 库存查看
    *@date: 10:11 2017/11/26
    */
    @Override
    public List stockglance(String from,String to) throws RemoteException {
        List<String> billNo = link.getRemoteHelper().getLog().logstockGlance(from,to);
        for (String s : billNo) {
            link.getRemoteHelper().getBuyinBill().findbyNO(3,s);
        }
        List<Object> ret = new ArrayList<>();
        ret.add(withBase);
        ret.add(withConsumer);
        return null;
    }
}
