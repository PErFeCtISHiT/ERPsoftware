package client.BL.Accountant.FinancialBuildAccountbl;

import client.BLservice.Accountant.FinancialBuildAccountblservice.FinancialBuildAccountInterface;
import client.RMI.link;
import server.Po.AccountInitPO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.goodsPO;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 * @author: yotta
 * @description: controller for account build
 * @date: modify in 18:20 2017/12/24
 */

public class FinancialBuildController implements FinancialBuildAccountInterface {

    /**
     * 期初建账
     *
     * @return AccountBuild
     * @throws RemoteException
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */

    @Override
    public AccountBuild accountbuild() throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {

        Calendar c = Calendar.getInstance();
        int yearint = c.get(Calendar.YEAR);
        String year = yearint + "";
        ArrayList<AccountBuild_account> accountlist = getPastAccount(year);
        ArrayList<AccountBuild_consumer> consumerlist = getPastConsumer(year);
        ArrayList<AccountBuild_good> goodslist = getPastGoods(year);
        AccountBuild newaccount = new AccountBuild(year, accountlist, consumerlist, goodslist);

        link.getRemoteHelper().getaccountInit().Build(year);
        return newaccount;
    }

    /**
     * 展示期初建账
     *
     * @return ArrayList<AccountList>
     * @throws RemoteException
     */

    @Override
    public ArrayList<AccountList> show() throws RemoteException {
        List<AccountInitPO> list = link.getRemoteHelper().getaccountInit().findAll(20);
        ArrayList<AccountList> showlist = new ArrayList<>();
        for (AccountInitPO aList : list) {
            AccountList acc = new AccountList();
            acc.setYear(aList.getKeyyear());
            showlist.add(acc);
        }

        return showlist;
    }

    /**
     * 得到历史期初建账
     *
     * @param year
     * @return AccountBuild
     * @throws RemoteException
     */

    @Override
    public AccountBuild getPast(String year) throws RemoteException {
        ArrayList<AccountBuild_account> accountlist = getPastAccount(year);
        ArrayList<AccountBuild_consumer> consumerlist = getPastConsumer(year);
        ArrayList<AccountBuild_good> goodslist = getPastGoods(year);
        return new AccountBuild(year, accountlist, consumerlist, goodslist);
    }

    /**
     * 得到历史期初建账 账户列表
     *
     * @param year
     * @return ArrayList<AccountBuild_account>
     * @throws RemoteException
     */

    @Override
    public ArrayList<AccountBuild_account> getPastAccount(String year) throws RemoteException {
        ArrayList<AccountBuild_account> accountList = new ArrayList<>();
        List<coPO> polist = link.getRemoteHelper().getaccountInit().getPastAccount(year);
        for (coPO aPolist : polist) {
            AccountBuild_account account = PoToAccount(aPolist);
            accountList.add(account);
        }
        return accountList;
    }

    /**
     * Po转换
     *
     * @param po
     * @return AccountBuild_account
     * @throws RemoteException
     */

    @Override
    public AccountBuild_account PoToAccount(coPO po) throws RemoteException {
        String id = po.getKeyno();
        String name = po.getKeyname();
        Double money = po.getSumall();
        return new AccountBuild_account(id, name, money.toString());
    }


    /**
     * 得到历史期初建账 客户列表
     *
     * @param year
     * @return ArrayList<AccountBuild_consumer>
     * @throws RemoteException
     */

    @Override
    public ArrayList<AccountBuild_consumer> getPastConsumer(String year) throws RemoteException {
        ArrayList<AccountBuild_consumer> consumerList = new ArrayList<>();
        List<consumerPO> polist = link.getRemoteHelper().getaccountInit().getPastConsumer(year);
        for (consumerPO aPolist : polist) {
            AccountBuild_consumer consumer = PoToConsumer(aPolist);
            consumerList.add(consumer);
        }
        return consumerList;
    }

    /**
     * PO转换
     *
     * @param po
     * @return AccountBuild_consumer
     * @throws RemoteException
     */

    @Override
    public AccountBuild_consumer PoToConsumer(consumerPO po) throws RemoteException {
        AccountBuild_consumer con = new AccountBuild_consumer();
        con.setconsumerID(po.getKeyno());
        con.setconsumerName(po.getKeyname());
        con.setconsumerType(String.valueOf(po.getKinds()));
        con.setinOutGap(String.valueOf(po.getPay() - po.getReceive()));
        con.setdueIN(String.valueOf(po.getReceive()));
        con.setduePay(String.valueOf(po.getCapacit()));
        return con;
    }

    /**
     * 得到历史期初建账 商品列表
     *
     * @param year
     * @return ArrayList<AccountBuild_good>
     * @throws RemoteException
     */


    @Override
    public ArrayList<AccountBuild_good> getPastGoods(String year) throws RemoteException {
        ArrayList<AccountBuild_good> goodList = new ArrayList<>();
        List<goodsPO> polist = link.getRemoteHelper().getaccountInit().getPastGoods(year);
        for (goodsPO aPolist : polist) {
            AccountBuild_good good = PoToGood(aPolist);
            goodList.add(good);
        }
        return goodList;
    }

    /**
     * PO转换
     *
     * @param po
     * @return AccountBuild_good
     * @throws RemoteException
     */

    @Override
    public AccountBuild_good PoToGood(goodsPO po) throws RemoteException {
        AccountBuild_good good = new AccountBuild_good();
        good.setGoodsID(po.getKeyno());
        good.setGoodsName(po.getKeyname());
        good.setGoodsType(po.getKinds());
        good.setGoodsInprice(String.valueOf(po.getInprice()));
        good.setGoodsModel(po.getKeymodel());
        good.setGoodsOutprice(String.valueOf(po.getOutprice()));
        good.setGoodsReceinprice(String.valueOf(po.getReceprice()));
        good.setGoodsReceoutprice(String.valueOf(po.getReceoutprice()));
        return good;
    }

}


