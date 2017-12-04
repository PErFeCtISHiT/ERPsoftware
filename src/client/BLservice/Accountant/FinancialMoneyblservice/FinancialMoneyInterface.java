package client.BLservice.Accountant.FinancialMoneyblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.Vo.moneyVO;
import server.Po.consumerPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinancialMoneyInterface {

    public ResultMessage getMoneyID();

    public moneyVO find(String iD);

    public ResultMessage addBill(moneyVO vo);

    public moneyVO summit();

    public ResultMessage getSum();

    public ArrayList<Account> getAllAccount() throws RemoteException;

    public ArrayList<Consumer> getAllConsumer() throws RemoteException;

    public Consumer PoToConsumer(consumerPO po) throws RemoteException;
}
