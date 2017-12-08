package client.BL.Accountant.FinancialBuildAccountbl;

import client.BLservice.Accountant.FinancialBuildAccountblservice.FinancialBuildAccountInterface;
import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FinancialBuildController implements FinancialBuildAccountInterface{


    @Override
    public AccountBuild accountbuild() throws RemoteException{

        return null;
    }


    @Override
    public AccountBuild getPast(String year) throws RemoteException{



        return null;
    }

    @Override
    public ArrayList<AccountBuild_account> getPastAccount(String year) throws RemoteException {
        return null;
    }


    @Override
    public ArrayList<AccountBuild_consumer> getPastConsumer(String year) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<AccountBuild_good> getPastGoods(String year) throws RemoteException {
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
