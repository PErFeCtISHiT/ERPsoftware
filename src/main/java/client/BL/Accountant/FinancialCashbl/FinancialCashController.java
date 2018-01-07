package client.BL.Accountant.FinancialCashbl;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.BL.Accountant.FinancialReceivebl.AccountBill;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.BLservice.Accountant.FinancialCashblservice.FinancialCashInterface;
import client.Presentation.tools.NOgenerator;
import client.RMI.link;
import client.Vo.coVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.moneyListPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.*;


/**
 *
 *
 * @author: yotta
 * @description: controller for Cash（现金费用）
 * @date: modify in 18:20 2017/12/24
 */
public class FinancialCashController implements FinancialCashInterface {

    FinancialAccountController Accountcontroller  = new FinancialAccountController();

    /**
     * 提交单据
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */

    @Override
    public ResultMessage summit(FinancialCash financialCash) throws RemoteException{
        moneyPO moneypo = FinancialCashToMoneyPO(financialCash);
        ArrayList<MoneyList> list = financialCash.getMoneyList();
        saveMoneyList(list);
        moneypo.setIsDraft(0.0);
        link.getRemoteHelper().getMoneyBill().addObject(moneypo,5);
        System.out.println("summit");
        return null;
    }

    /**
     * 再次提交
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */

    @Override
    public ResultMessage resummit(FinancialCash financialCash) throws RemoteException {
        moneyPO moneypo = FinancialCashToMoneyPO(financialCash);
        ArrayList<MoneyList> list = financialCash.getMoneyList();
        saveMoneyList(list);
        moneypo.setIsDraft(0.0);
        link.getRemoteHelper().getMoneyBill().modifyObject(moneypo,5);
        System.out.println("summit");
        return null;
    }

    /**
     * 保存草稿
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */

    @Override
    public ResultMessage saveAsDraft (FinancialCash financialCash) throws RemoteException{
        ArrayList<MoneyList> moneyLists = financialCash.getMoneyList();
        saveMoneyList(moneyLists);
        moneyPO moneypo = FinancialCashToMoneyPO(financialCash);
        moneypo.setIsDraft(1.0);
        link.getRemoteHelper().getMoneyBill().addObject(moneypo,5);
        return null;
    }

    /**
     * 保存条目列表
     *
     * @param moneyLists
     * @throws RemoteException
     */
    @Override
    public void saveMoneyList(ArrayList<MoneyList> moneyLists) throws RemoteException{
        for (int i=0; i< moneyLists.size();i++){
            MoneyList ml =moneyLists.get(i);
            System.out.println("List Size: "+moneyLists.get(i).getAccount()+ml.getkeyid());
            moneyListPO moneylist = new moneyListPO();

            moneylist.setKeyno(ml.getlistNO());
            moneylist.setAccountname(ml.getAccount());
            moneylist.setSumall(Double.parseDouble(ml.getMoney()));
            moneylist.setNote(ml.getComment());

            try {
                NOgenerator generater = new NOgenerator();
                String listID = "ZZLB-" + generater.generateMoneyList(18);
                moneylist.setKeyid(listID);
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

    /**
     * 编辑草稿
     *
     * @param Keyno
     * @return
     * @throws RemoteException
     */
    @Override
    public FinancialCash ReEditBill(String Keyno) throws RemoteException{

        List<moneyPO> moneypo = link.getRemoteHelper().getMoneyBill().findbyNO(5,Keyno);
//        System.out.println("po size: "+moneypo.size());
        moneyPO po = moneypo.get(0);
        FinancialCash bill=PoToFinancialCash(po);
        String keyNO = po.getKeyno();
        link.getRemoteHelper().getmoneyList().deleteByNO(keyNO);
//        System.out.println(" List size: "+bill.getMoneyList().size());
        return bill;

    }

    /**
     * PO转换
     *
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public FinancialCash PoToFinancialCash( moneyPO po) throws RemoteException{
        String ID = po.getKeyno();
        String Billtype = String.valueOf(po.getKind());
        String operater=po.getOper();
        String account=po.getAccoun();
        List<moneyListPO> list =link.getRemoteHelper().getmoneyList().findbyNO(18,po.getMoneyList());
        ArrayList<MoneyList> moneylist = PoToMoneyLists(list);
        System.out.println(" list size: "+list.size());
        double sum = po.getSumall();
        FinancialCash bill = new FinancialCash(ID,Billtype,operater,account,moneylist,sum);
        System.out.println(" potobill size: "+bill.getMoneyList().size());
        return bill;
    }

    /**
     * PO转换
     *
     * @param list
     * @return
     * @throws RemoteException
     */

    @Override
    public ArrayList<MoneyList> PoToMoneyLists (List<moneyListPO> list) throws RemoteException{
        ArrayList<MoneyList> newlist= new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            MoneyList newml= new MoneyList();
            newml.setAccount(list.get(i).getAccountname());
            newml.setMoney(String.valueOf(list.get(i).getSumall()));
            newml.setComment(list.get(i).getNote());
            newml.setKeyid(list.get(i).getKeyid());
            newml.setlistNO(list.get(i).getKeyno());

            newlist.add(newml);

        }
        return newlist;
    }


    /**
     * 所有已经审批的单据
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<AccountBill> getAllPromotedCash() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();
        for(int i=0;i<moneyPOList.size();i++){
            if (moneyPOList.get(i).getKind()==2.0&&moneyPOList.get(i).getIscheck()==1.0){
                accountBills.add(PoToAccountBill(moneyPOList.get(i)));
            }
        }
//        System.out.println(accountBills.size()+" "+accountBills.get(0).getKeyno());
        return accountBills;
    }

    /**
     * 正在审批的单据
     * @return
     * @throws RemoteException
     */

    @Override
    public ArrayList<AccountBill> getAllUnderPromotedCash() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();
        System.out.println(moneyPOList.size());
        for(int i=0;i<moneyPOList.size();i++){
            System.out.println(moneyPOList.get(i).getKeyno());
            if (moneyPOList.get(i).getKind()==2.0&&moneyPOList.get(i).getIscheck()==0.0 && moneyPOList.get(i).getIsDraft()==0.0){
                accountBills.add(PoToAccountBill(moneyPOList.get(i)));
            }
        }
        System.out.println(accountBills.size());
        return accountBills;
    }


    /**
     * 草稿单据
     *
     * @return
     * @throws RemoteException
     */

    @Override
    public ArrayList<AccountBill> getAllDraftCash() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<moneyPO> DraftCashPO = PickDraftCash(moneyPOList);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();

        for (int i=0; i<DraftCashPO.size();i++){
            accountBills.add(PoToAccountBill(DraftCashPO.get(i)));
        }

        return accountBills;
    }

    /**
     * PO转换
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public AccountBill PoToAccountBill(moneyPO po) throws RemoteException{
        AccountBill billcash = new AccountBill();

        if (po.getKind()==0.0){
            billcash.setKind("收款单");
        }
        else if (po.getKind() ==1.0){
            billcash.setKind("付款单");
        }
        else {
            billcash.setKind("现金费用单");
        }

        billcash.setIscheck(String.valueOf(po.getIscheck()));
        billcash.setIsDraft(String.valueOf(po.getIsDraft()));
        billcash.setIsred(String.valueOf(po.getIsred()));
        billcash.setSumall(String.valueOf(po.getSumall()));
        billcash.setKeyno(po.getKeyno());
        billcash.setConsumertype(po.getConsumertype());
        billcash.setOper(po.getOper());
        billcash.setConsumer(po.getConsumer());
        billcash.setAccoun(po.getAccoun());
        billcash.setMoneyList(po.getMoneyList());



        return billcash;
    }

    /**
     * 筛选草稿
     *
     * @param pos
     * @return
     * @throws RemoteException
     */

    @Override
    public ArrayList<moneyPO> PickDraftCash(List<moneyPO> pos) throws RemoteException{
        ArrayList<moneyPO> draftReceive = new ArrayList<moneyPO>();
        for(int i=0;i<pos.size();i++){
            if (pos.get(i).getKind()==2.0&&pos.get(i).getIsDraft()==1.0){
                draftReceive.add(pos.get(i));
            }
        }
        return draftReceive;
    }

    /**
     * 类型转换
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */

    @Override
    public moneyPO FinancialCashToMoneyPO(FinancialCash financialCash) throws RemoteException {
        moneyPO moneypo = new moneyPO();
        String billtype = financialCash.getBillType();
        String billID = financialCash.getID();
        String operater = financialCash.getOperater();
        String account = financialCash.getAccount();
        double sum = financialCash.getSum();
        String moneylistNO=null;
        if (financialCash.getMoneyList().size()!=0){
            moneylistNO = financialCash.getMoneyList().get(0).getlistNO();
        }


        moneypo.setKind(2.0);
        moneypo.setKeyno(billID);
        moneypo.setAccoun(account);
        moneypo.setConsumer("");
        moneypo.setConsumertype("");
        moneypo.setIscheck(0.0);
        moneypo.setIsred(0.0);
        moneypo.setIsDraft(0.0);
        moneypo.setOper(operater);
        moneypo.setMoneyList(moneylistNO);
        moneypo.setSumall(sum);

        return moneypo;
    }

    /**
     * 客户列表
     *
     * @return
     * @throws RemoteException
     */


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

    /**
     *
     * 客户列表
     *
     * @return
     * @throws RemoteException
     */

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


    /**
     * 类型转化
     *
     * @param po
     * @return
     */

    @Override
    public Consumer PoToConsumer(consumerPO po) {
        Consumer con = new Consumer();
        con.setconsumerID(po.getKeyno());
        con.setstaff(po.getServer());
        con.setinOutGap(String.valueOf(po.getPay()-po.getReceive()));
        con.setactualIN(String.valueOf(po.getPay()));
        con.setdueIN(String.valueOf(po.getReceive()));
        con.setduePay(String.valueOf(po.getCapacit()));
        con.setconsumerName(po.getKeyname());
        con.setconsumerLevel(String.valueOf(po.getLev()));
        return con;
    }

}