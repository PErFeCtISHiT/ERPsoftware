package client.BLservice.Accountant.FinancialCheckSellblservice;

import client.BL.Accountant.FinancialCheckSellbl.Sale;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;
import server.Po.goodsOutListPO;
import server.Po.salePO;
import shared.ResultMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface FinancialCheckSellInterface {


    public List<Sale> search(String detail) throws RemoteException;

    public ResultMessage getExcel(int type, String address) throws RemoteException, IOException, InterruptedException;

    public ArrayList<Sale> show() throws RemoteException;

    public Sale PoToSale(salePO po, goodsOutListPO goodslist) throws RemoteException;

    public saleVO PoToVo(salePO po) throws RemoteException;

}
