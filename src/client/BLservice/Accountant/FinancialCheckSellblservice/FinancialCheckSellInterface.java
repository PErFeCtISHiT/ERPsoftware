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


    List<Sale> check(String time) throws RemoteException;

    boolean getExcel(String address) throws RemoteException;

    ArrayList<Sale> show() throws RemoteException;

    Sale PoToSale(salePO po, goodsOutListPO goodslist) throws RemoteException;

    saleVO PoToVo(salePO po) throws RemoteException;

}
