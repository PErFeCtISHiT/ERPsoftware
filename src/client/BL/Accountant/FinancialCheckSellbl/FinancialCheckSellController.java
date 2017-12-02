package client.BL.Accountant.FinancialCheckSellbl;

import client.BLservice.Accountant.FinancialCheckSellblservice.FinancialCheckSellInterface;
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
    public ArrayList<saleVO> check(String time){
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


//
//    public final SimpleStringProperty goodsName;
//    public final SimpleStringProperty goodsType;
//    public final SimpleStringProperty goodsNum;
//    public final SimpleStringProperty goodsPrice;
//    public final SimpleStringProperty totalSum;


    public Sale VoToSale(saleVO vo,goodsOutListVO goodslist) throws RemoteException{
        String saleTime = vo.getDateandtime();
        String goodsName;
        String goodsType;
        String goodsNum;
        String goodsPrice;
        String totalSum;

        return null;
    }


}
