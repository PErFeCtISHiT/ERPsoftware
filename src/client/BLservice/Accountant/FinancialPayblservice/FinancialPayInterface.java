package client.BLservice.Accountant.FinancialPayblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.Vo.moneyVO;
import server.Po.consumerPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinancialPayInterface {


    public ResultMessage getPayID();

    public moneyVO find(String iD);

    public ResultMessage addBill(moneyVO vo);

    public moneyVO summit();

    public ArrayList<Account> getAllAccount() throws RemoteException;

    public ArrayList<Consumer> getAllConsumer() throws RemoteException;

    public Consumer PoToConsumer(consumerPO po) throws RemoteException;
}
