package client.BLservice.Accountant.FinancialCheckSellblservice;

import client.BL.Accountant.FinancialCheckSellbl.Sale;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface FinancialCheckSellInterface {


    public List<Sale> check(String time) throws RemoteException;

    public boolean getExcel(String address) throws RemoteException;

    public List<Sale> show() throws RemoteException;

    public Sale VoToSale(saleVO vo,goodsOutListVO goodslist) throws RemoteException;

}
