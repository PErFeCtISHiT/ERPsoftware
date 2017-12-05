package client.BL.Accountant.FinancialReceivebl;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.BLservice.Accountant.FinancialReceiveblservice.FinancialReceiveInterface;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.moneyVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.*;

public class FinancialReceiveController implements FinancialReceiveInterface {


    FinancialAccountController Accountcontroller  = new FinancialAccountController();



    @Override
    public ResultMessage getReceiveID(){
        return null;
    }

    @Override
    public moneyVO find(String iD){
        return null;
    }

    @Override
    public ResultMessage addBill(moneyVO vo){
        return null;
    }

    @Override
    public moneyVO summit(){
        return null;
    }

    @Override
    public ArrayList<Account> getAllAccount() throws RemoteException {

        List<coPO> list = link.getRemoteHelper().getCoaccount().findAll(10);
        ArrayList<Account> colist = new ArrayList<Account>();
        for (int i=0;i<list.size();i++){
            coVO newco = Accountcontroller.PoToVo(list.get(i));
            Account account = Accountcontroller.VoToAccount(newco);
            colist.add(account);
        }

        return colist;
    }



    @Override
    public ArrayList<Consumer> getAllConsumer() throws RemoteException {

        List<consumerPO> list = link.getRemoteHelper().getConsumer().findAll(2);
        ArrayList<Consumer> consumer =new ArrayList<Consumer>();
        for (int i=0;i<list.size();i++){
            Consumer newcon = PoToConsumer(list.get(i));
            consumer.add(newcon);
        }

        return consumer;
    }

    @Override
    public Consumer PoToConsumer(consumerPO po) throws RemoteException{
        Consumer con = new Consumer();
        con.setconsumerID(po.getKeyno());
        con.setconsumerName(po.getKeyname());
        con.setconsumerLevel(String.valueOf(po.getLev()));
        con.setstaff(po.getServer());
        con.setinOutGap(String.valueOf(po.getPay()-po.getReceive()));
        con.setactualIN(String.valueOf(po.getPay()));
        con.setdueIN(String.valueOf(po.getReceive()));
        con.setduePay(String.valueOf(po.getCapacit()));
        return con;
    }



}