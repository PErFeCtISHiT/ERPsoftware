package client.BLservice.Accountant.FinancialCheckSellblservice;

import client.BL.Accountant.FinancialCheckSellbl.Sale;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;
import server.Po.goodsOutListPO;
import server.Po.salePO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface FinancialCheckSellInterface {


    public List<Sale> check(String time) throws RemoteException;

    public boolean getExcel(String address) throws RemoteException;

    public ArrayList<Sale> show() throws RemoteException;

    public Sale PoToSale(salePO po, goodsOutListPO goodslist) throws RemoteException;

    public saleVO PoToVo(salePO po) throws RemoteException;

}
