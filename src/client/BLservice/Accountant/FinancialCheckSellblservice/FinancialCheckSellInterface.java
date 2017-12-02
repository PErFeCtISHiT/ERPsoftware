package client.BLservice.Accountant.FinancialCheckSellblservice;

import client.BL.Accountant.FinancialCheckSellbl.Sale;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinancialCheckSellInterface {


    public ArrayList<Sale> check(String time);

    public boolean getExcel(String address);

    public ArrayList<Sale> show();

    public Sale VoToSale(saleVO vo,goodsOutListVO goodslist) throws RemoteException;

}
