package client.BL.Stockman.StockmanStockCheckbl;

import client.BLservice.Stockman.StockmanStockCheckblservice.stockCheck;
import client.RMI.link;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:25 2017/11/26
 */
public class stockCheckController implements stockCheck {
    /**
     * @author:pis
     * @description: 库存盘点，盘点当天商品
     * @date: 15:33 2017/11/26
     */
    @Override
    public List StockCheck() throws RemoteException {
        return link.getRemoteHelper().getGoods().findAll(0);
    }

    @Override
    public void exportToExcel(int type, String path) throws RemoteException, IOException, InterruptedException {

        link.getRemoteHelper().getGoods().exportToExcel(type, path);
    }


}
