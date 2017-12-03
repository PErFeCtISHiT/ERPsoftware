package client.BL.Accountant.FinancialCheckSellbl;

import client.BLservice.Accountant.FinancialCheckSellblservice.FinancialCheckSellInterface;
import client.RMI.link;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FinancialCheckSellController implements FinancialCheckSellInterface{

    /**
     *
     * @param time
     * @return ArrayList<saleVO>
     */
    public ArrayList<Sale> check(String time){


        return null;
    }


    /**
     *
     * @param address
     * @return boolean
     */

    public boolean getExcel(String address){
        return false;
    }


    public ArrayList<Sale> show(){

       // return link.getRemoteHelper().
        return null;
    }



    public Sale VoToSale(saleVO vo,goodsOutListVO goodslist) throws RemoteException{
        String saleTime = vo.getDateandtime();
        String goodsName =goodslist.getGoodsname();
        String goodsType =goodslist.getKeymodel();
        double goodsNum = goodslist.getNum();
        double goodsPrice = goodslist.getPrice();
        double totalSum = goodsNum*goodsPrice;

        return null;
    }

}
