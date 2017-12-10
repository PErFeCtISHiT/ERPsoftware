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

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FinancialBuildController implements FinancialBuildAccountInterface{


    @Override
    public AccountBuild accountbuild() throws RemoteException{

        Calendar c = Calendar.getInstance();
        int yearint = c.get(Calendar.YEAR);
        String year=yearint+"";
        ArrayList<AccountBuild_account> accountlist = getPastAccount(year);
        ArrayList<AccountBuild_consumer> consumerlist = getPastConsumer(year);
        ArrayList<AccountBuild_good> goodslist = getPastGoods(year);

        AccountBuild newaccount = new AccountBuild(year,accountlist,consumerlist,goodslist);

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


        return null;
    }

    @Override
    public AccountBuild_account PoToAccount(coPO po) throws RemoteException {
        return null;
    }


    @Override
    public ArrayList<AccountBuild_consumer> getPastConsumer(String year) throws RemoteException {
        return null;
    }

    @Override
    public AccountBuild_consumer PoToConsumer(consumerPO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<AccountBuild_good> getPastGoods(String year) throws RemoteException {

        return null;
    }

    @Override
    public AccountBuild_good PoToGood(goodsPO po) throws RemoteException {
        return null;
    }

}


/**
 * 银行账户信息——>界面可以显示
 * 客户信息——>界面可以显示
 * 商品信息——>界面可以显示
 *
 *当前用户（郭丰睿）要早点干呀！！！
 *
 * 期初建账类
 * 包含
 * 商品信息
 * 客户信息
 * 银行账户信息
 * 当前用户信息
 *
 *
 * 方法包含：
 * 提交期初建账类
 *
 *
 *
 */
