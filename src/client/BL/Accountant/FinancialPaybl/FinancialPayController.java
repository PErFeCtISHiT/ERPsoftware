package client.BL.Accountant.FinancialPaybl;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.BL.Accountant.FinancialReceivebl.AccountBill;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.FinancialBill;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.BLservice.Accountant.FinancialPayblservice.FinancialPayInterface;
import client.Presentation.NOgenerator.NOgenerator;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.moneyVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.moneyListPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.*;

public class FinancialPayController implements FinancialPayInterface {


    FinancialAccountController Accountcontroller  = new FinancialAccountController();



    @Override
    public ResultMessage summit(FinancialBill financialBill) throws RemoteException{
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
        moneypo.setIsDraft(0.0);
        ArrayList<MoneyList> list = financialBill.getMoneyList();
        saveMoneyList(list);
        link.getRemoteHelper().getMoneyBill().addObject(moneypo,5);
        return null;
    }

    @Override
    public ResultMessage resummit(FinancialBill financialBill) throws RemoteException {
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
        moneypo.setIsDraft(0.0);
        ArrayList<MoneyList> list = financialBill.getMoneyList();
        saveMoneyList(list);
        link.getRemoteHelper().getMoneyBill().modifyObject(moneypo,5);
        return null;
    }

    @Override
    public ResultMessage saveAsDraft (FinancialBill financialBill) throws RemoteException{
        ArrayList<MoneyList> moneyLists = financialBill.getMoneyList();
        saveMoneyList(moneyLists);
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
        moneypo.setIsDraft(1.0);

        link.getRemoteHelper().getMoneyBill().addObject(moneypo,5);
        return null;
    }


    @Override
    public void saveMoneyList(ArrayList<MoneyList> moneyLists) throws RemoteException{
        for (int i=0; i< moneyLists.size();i++){
            MoneyList ml =moneyLists.get(i);
            System.out.println(ml.getlistNO());
            moneyListPO moneylist = new moneyListPO();
            moneylist.setKeyno(ml.getlistNO());
            moneylist.setAccountname(ml.getAccount());
            moneylist.setSumall(Double.parseDouble(ml.getMoney()));
            moneylist.setNote(ml.getComment());
            try {
                NOgenerator generater = new NOgenerator();
                String listID = "ZZLB-" + generater.generateMoneyList(18);
                moneylist.setKeyid(listID);
                System.out.println("List Size: "+moneylist.getKeyid());
                link.getRemoteHelper().getmoneyList().addObject(moneylist,18);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public FinancialBill ReEditBill(String Keyno) throws RemoteException{
        List<moneyPO> moneypo = link.getRemoteHelper().getMoneyBill().findbyNO(5,Keyno);
//        System.out.println("po size: "+moneypo.size());
        moneyPO po = moneypo.get(0);
        FinancialBill bill=PoToFinancialBill(po);
        String keyNO = po.getKeyno();
        link.getRemoteHelper().getmoneyList().deleteByNO(keyNO);
//        System.out.println(" List size: "+bill.getMoneyList().size());
        return bill;

    }

    @Override
    public FinancialBill PoToFinancialBill( moneyPO po) throws RemoteException{
        String ID = po.getKeyno();
        String Billtype = String.valueOf(po.getKind());
        String operater=po.getOper();
        String consumerType=po.getConsumertype();
        String consumerID=po.getConsumer();
        List<moneyListPO> list =link.getRemoteHelper().getmoneyList().findbyNO(18,po.getMoneyList());
        ArrayList<MoneyList> moneylist = PoToMoneyLists(list);
        System.out.println(" list size: "+list.size());
        double sum = po.getSumall();
        FinancialBill bill = new FinancialBill(ID,Billtype,operater,consumerType,consumerID,moneylist,sum);
        System.out.println(" potobill size: "+bill.getMoneyList().size());
        return bill;
    }

    @Override
    public ArrayList<MoneyList> PoToMoneyLists (List<moneyListPO> list) throws RemoteException{
        ArrayList<MoneyList> newlist= new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            MoneyList newml= new MoneyList();
            newml.setKeyid(list.get(i).getKeyid());
            newml.setlistNO(list.get(i).getKeyno());
            newml.setAccount(list.get(i).getAccountname());
            newml.setMoney(String.valueOf(list.get(i).getSumall()));
            newml.setComment(list.get(i).getNote());
            newlist.add(newml);

        }
        return newlist;
    }


    @Override
    public ArrayList<AccountBill> getAllPromotedPay() throws RemoteException{

        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();
        for(int i=0;i<moneyPOList.size();i++){
            if (moneyPOList.get(i).getKind()==1.0&&moneyPOList.get(i).getIscheck()==1.0){
                accountBills.add(PoToAccountBill(moneyPOList.get(i)));
            }
        }
//        System.out.println(accountBills.size()+" "+accountBills.get(0).getKeyno());
        return accountBills;
    }


    @Override
    public ArrayList<AccountBill> getAllUnderPromotedPay() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();
        System.out.println(moneyPOList.size());
        for(int i=0;i<moneyPOList.size();i++){
            System.out.println(moneyPOList.get(i).getKeyno());
            if (moneyPOList.get(i).getKind()==1.0&&moneyPOList.get(i).getIscheck()==0.0 && moneyPOList.get(i).getIsDraft()==0.0){
                accountBills.add(PoToAccountBill(moneyPOList.get(i)));
            }
        }
        System.out.println(accountBills.size());
        return accountBills;
    }



    @Override
    public ArrayList<AccountBill> getAllDraftPay() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<moneyPO> DraftPayPO = PickDraftPay(moneyPOList);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();

        for (int i=0; i<DraftPayPO.size();i++){
            accountBills.add(PoToAccountBill(DraftPayPO.get(i)));
        }

        return accountBills;
    }
    @Override
    public AccountBill PoToAccountBill(moneyPO po) throws RemoteException{
        AccountBill bill = new AccountBill();

        if (po.getKind()==0.0){
            bill.setKind("收款单");
        }
        else if (po.getKind() ==1.0){
            bill.setKind("付款单");
        }
        else {
            bill.setKind("现金费用单");
        }
        bill.setKeyno(po.getKeyno());
        bill.setConsumertype(po.getConsumertype());
        bill.setOper(po.getOper());
        bill.setConsumer(po.getConsumer());
        bill.setAccoun(po.getAccoun());
        bill.setMoneyList(po.getMoneyList());

        bill.setIscheck(String.valueOf(po.getIscheck()));
        bill.setIsDraft(String.valueOf(po.getIsDraft()));
        bill.setIsred(String.valueOf(po.getIsred()));
        bill.setSumall(String.valueOf(po.getSumall()));

        return bill;
    }


    @Override
    public ArrayList<moneyPO> PickDraftPay(List<moneyPO> pos) throws RemoteException{
        ArrayList<moneyPO> draftReceive = new ArrayList<moneyPO>();
        for(int i=0;i<pos.size();i++){
            if (pos.get(i).getKind()==1.0&&pos.get(i).getIsDraft()==1.0){
                draftReceive.add(pos.get(i));
            }
        }
        return draftReceive;
    }

    @Override
    public moneyPO FinancialBillToMoneyPO(FinancialBill financialBill) throws RemoteException {
        moneyPO moneypo = new moneyPO();
        String billtype = financialBill.getBillType();
        String billID = financialBill.getID();
        String operater = financialBill.getOperater();
        String consumerType = financialBill.getConsumerType();
        String consumerID = financialBill.getConsumerID();
        double sum = financialBill.getSum();
        String moneylistNO=null;
        if (financialBill.getMoneyList().size()!=0){
            moneylistNO = financialBill.getMoneyList().get(0).getlistNO();
        }


        moneypo.setKind(1.0);
        moneypo.setKeyno(billID);
        moneypo.setAccoun("");
        moneypo.setConsumer(consumerID);
        moneypo.setConsumertype(consumerType);
        moneypo.setIscheck(0.0);
        moneypo.setIsred(0.0);
        moneypo.setIsDraft(0.0);
        moneypo.setOper(operater);
        moneypo.setMoneyList(moneylistNO);
        moneypo.setSumall(sum);

        return moneypo;
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
    public Consumer PoToConsumer(consumerPO po) {
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