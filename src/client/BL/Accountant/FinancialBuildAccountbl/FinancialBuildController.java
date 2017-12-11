package client.BL.Accountant.FinancialBuildAccountbl;

import client.BLservice.Accountant.FinancialBuildAccountblservice.FinancialBuildAccountInterface;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.goodsPO;
import shared.ResultMessage;
import shared.praseDouble;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FinancialBuildController implements FinancialBuildAccountInterface{


    @Override
    public AccountBuild accountbuild() throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
//
        Calendar c = Calendar.getInstance();
        int yearint = c.get(Calendar.YEAR);
        String year=yearint+"";
        ArrayList<AccountBuild_account> accountlist = getPastAccount(year);
        ArrayList<AccountBuild_consumer> consumerlist = getPastConsumer(year);
        ArrayList<AccountBuild_good> goodslist = getPastGoods(year);

        year="1997";
        System.out.println(year);
        AccountBuild newaccount = new AccountBuild(year,accountlist,consumerlist,goodslist);

        link.getRemoteHelper().getaccountInit().Build(year);
        return newaccount;
    }


    @Override
    public AccountBuild getPast(String year) throws RemoteException{
        ArrayList<AccountBuild_account> accountlist = getPastAccount(year);
        ArrayList<AccountBuild_consumer> consumerlist = getPastConsumer(year);
        ArrayList<AccountBuild_good> goodslist = getPastGoods(year);
        AccountBuild newaccount = new AccountBuild(year,accountlist,consumerlist,goodslist);
        return newaccount;
    }

    @Override
    public ArrayList<AccountBuild_account> getPastAccount(String year) throws RemoteException {
        ArrayList<AccountBuild_account> accountList = new ArrayList<>();
        List<coPO> polist = link.getRemoteHelper().getaccountInit().getPastAccount(year);
        System.out.println(polist.size());
        for (int i=0;i<polist.size();i++){
            AccountBuild_account account =  PoToAccount(polist.get(i));
            accountList.add(account);
        }
        return accountList;
    }

    @Override
    public AccountBuild_account PoToAccount(coPO po) throws RemoteException {
        String id=po.getKeyno();
        String name= po.getKeyname();
        Double money = po.getSumall();
        AccountBuild_account account = new AccountBuild_account(id,name,money.toString());
        return account;
    }


    @Override
    public ArrayList<AccountBuild_consumer> getPastConsumer(String year) throws RemoteException {
        ArrayList<AccountBuild_consumer> consumerList = new ArrayList<>();
        List<consumerPO> polist = link.getRemoteHelper().getaccountInit().getPastConsumer(year);
        System.out.println(polist.size());
        for (int i=0;i<polist.size();i++){
            AccountBuild_consumer consumer =  PoToConsumer(polist.get(i));
            consumerList.add(consumer);
        }
        return consumerList;
    }

    @Override
    public AccountBuild_consumer PoToConsumer(consumerPO po) throws RemoteException {
        AccountBuild_consumer con = new AccountBuild_consumer();
        con.setconsumerID(po.getKeyno());
        con.setconsumerName(po.getKeyname());
        con.setconsumerType(String.valueOf(po.getKinds()));
        con.setinOutGap(String.valueOf(po.getPay()-po.getReceive()));
        con.setdueIN(String.valueOf(po.getReceive()));
        con.setduePay(String.valueOf(po.getCapacit()));
        return con;
    }

    @Override
    public ArrayList<AccountBuild_good> getPastGoods(String year) throws RemoteException {
        ArrayList<AccountBuild_good> goodList = new ArrayList<>();
        List<goodsPO> polist = link.getRemoteHelper().getaccountInit().getPastGoods(year);
        System.out.println(polist.size());
        for (int i=0;i<polist.size();i++){
            AccountBuild_good good =  PoToGood(polist.get(i));
            goodList.add(good);
        }
        return goodList;
    }


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


