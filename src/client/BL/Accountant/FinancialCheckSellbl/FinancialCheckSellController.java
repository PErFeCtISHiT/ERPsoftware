package client.BL.Accountant.FinancialCheckSellbl;

import client.BLservice.Accountant.FinancialCheckSellblservice.FinancialCheckSellInterface;
import client.RMI.link;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;
import server.Po.salePO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class FinancialCheckSellController implements FinancialCheckSellInterface{

    /**
     *
     * @param time
     * @return ArrayList<saleVO>
     */
    public List<Sale> check(String time) throws RemoteException{


        return null;
    }


    /**
     *
     * @param address
     * @return boolean
     */

    public boolean getExcel(String address) throws RemoteException{
        return false;
    }


    public List<Sale> show() throws RemoteException{
        //link.getRemoteHelper().getSale().findAll()
        return null;
    }



    public Sale VoToSale(saleVO vo, goodsOutListVO goodslist) throws RemoteException{
        String saleTime = vo.getDateandtime();
        String goodsName =goodslist.getGoodsname();
        String goodsType =goodslist.getKeymodel();
        double goodsNum = goodslist.getNum();
        double goodsPrice = goodslist.getPrice();
        double totalSum = goodsNum*goodsPrice;

        return null;
    }

}
