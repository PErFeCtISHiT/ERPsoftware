package client.BL.Accountant.FinancialReceivebl;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.BLservice.Accountant.FinancialReceiveblservice.FinancialReceiveInterface;
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
 * @description: controller for 收款单
 * @date: modify in 18:20 2017/12/24
 */

public class FinancialReceiveController implements FinancialReceiveInterface {


    FinancialAccountController Accountcontroller  = new FinancialAccountController();

    /**
     * 提交单据
     *
     * @param financialBill
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage summit(FinancialBill financialBill) throws RemoteException{
        ArrayList<MoneyList> list = financialBill.getMoneyList();
        saveMoneyList(list);
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
        link.getRemoteHelper().getMoneyBill().addObject(moneypo,5);
        return null;
    }

    /**
     * 再次提交
     *
     * @param financialBill
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage resummit(FinancialBill financialBill) throws RemoteException {
        ArrayList<MoneyList> list = financialBill.getMoneyList();
        saveMoneyList(list);
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
        moneypo.setIsDraft(0.0);
        link.getRemoteHelper().getMoneyBill().modifyObject(moneypo,5);
        return null;
    }
    /**
     * 保存草稿
     *
     * @param financialBill
     * @return
     * @throws RemoteException
     */


    @Override
    public ResultMessage saveAsDraft (FinancialBill financialBill) throws RemoteException{
        ArrayList<MoneyList> moneyLists = financialBill.getMoneyList();
        saveMoneyList(moneyLists);
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
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
            moneyListPO moneylist = new moneyListPO();
            moneylist.setKeyno(ml.getlistNO());
            moneylist.setAccountname(ml.getAccount());
            moneylist.setSumall(Double.parseDouble(ml.getMoney()));
            moneylist.setNote(ml.getComment());
            if(moneylist.getKeyid()==null){
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


    }

    /**
     * 编辑草稿
     *
     * @param Keyno
     * @return
     * @throws RemoteException
     */

    @Override
    public FinancialBill ReEditBill(String Keyno) throws RemoteException{
        List<moneyPO> moneypo = link.getRemoteHelper().getMoneyBill().findbyNO(5,Keyno);
        moneyPO po = moneypo.get(0);
        FinancialBill bill=PoToFinancialBill(po);
        String keyNO = po.getKeyno();
        link.getRemoteHelper().getmoneyList().deleteByNO(keyNO);
        return bill;
    }
    /**
     * 所有已经审批的单据
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<AccountBill> getAllPromotedReceive() throws RemoteException{

        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();
        for(int i=0;i<moneyPOList.size();i++){
            if (moneyPOList.get(i).getKind()==0.0&&moneyPOList.get(i).getIscheck()==1.0){
                accountBills.add(PoToAccountBill(moneyPOList.get(i)));
            }
        }
        return accountBills;
    }

    /**
     * 正在审批的单据
     * @return
     * @throws RemoteException
     */

    @Override
    public ArrayList<AccountBill> getAllUnderPromotedReceive() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();
        for(int i=0;i<moneyPOList.size();i++){
            if (moneyPOList.get(i).getKind()==0.0&&moneyPOList.get(i).getIscheck()==0.0 && moneyPOList.get(i).getIsDraft()==0.0){
                accountBills.add(PoToAccountBill(moneyPOList.get(i)));
            }
        }
        return accountBills;
    }

    /**
     * 草稿单据
     *
     * @return
     * @throws RemoteException
     */

    @Override
    public ArrayList<AccountBill> getAllDraftReceive() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<moneyPO> DraftReceivePO = PickDraftReceive(moneyPOList);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();

        for (int i=0; i<DraftReceivePO.size();i++){
            accountBills.add(PoToAccountBill(DraftReceivePO.get(i)));
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

    /**
     * 筛选草稿
     *
     * @param pos
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<moneyPO> PickDraftReceive(List<moneyPO> pos) throws RemoteException{
        ArrayList<moneyPO> draftReceive = new ArrayList<moneyPO>();
        for(int i=0;i<pos.size();i++){
            if (pos.get(i).getKind()==0.0&&pos.get(i).getIsDraft()==1.0){
                draftReceive.add(pos.get(i));
            }
        }
        return draftReceive;
    }
    /**
     * 类型转换
     *
     * @param financialBill
     * @return
     * @throws RemoteException
     */

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
        moneypo.setKind(0.0);
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 类型转化
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public FinancialBill PoToFinancialBill( moneyPO po) throws RemoteException{
        String ID = po.getKeyno();
        String Billtype = String.valueOf(po.getKind());
        String operater=po.getOper();
        String consumerType=po.getConsumertype();
        String consumerID=po.getConsumer();
        List<moneyListPO> list =link.getRemoteHelper().getmoneyList().findbyNO(18,po.getMoneyList());//////////////////////
        ArrayList<MoneyList> moneylist = PoToMoneyLists(list);
        double sum = po.getSumall();
        FinancialBill bill = new FinancialBill(ID,Billtype,operater,consumerType,consumerID,moneylist,sum);
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
            newml.setKeyid(list.get(i).getKeyid());
            newml.setlistNO(list.get(i).getKeyno());
            newml.setAccount(list.get(i).getAccountname());
            newml.setMoney(String.valueOf(list.get(i).getSumall()));
            newml.setComment(list.get(i).getNote());
            newlist.add(newml);

        }
        return newlist;
    }

    /**
     * 账户列表
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
