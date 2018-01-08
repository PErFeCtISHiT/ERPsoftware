package client.BLservice.Accountant.FinancialBuildAccountblservice;

import client.BL.Accountant.FinancialBuildAccountbl.*;
import client.Presentation.AccountantUI.InitAccount.AccountInitUI;
import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.goodsPO;
import shared.ResultMessage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinancialBuildAccountInterface {

    /**
     * 期初建账
     *
     * @return AccountBuild
     * @throws RemoteException
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    public AccountBuild accountbuild() throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException;

    /**
     * 展示期初建账
     *
     * @return ArrayList<AccountList>
     * @throws RemoteException
     */

    public ArrayList<AccountList> show() throws RemoteException;
    /**
     * 得到历史期初建账
     *
     * @param year
     * @return AccountBuild
     * @throws RemoteException
     */
    public AccountBuild getPast(String year) throws RemoteException;
    /**
     * 得到历史期初建账 账户列表
     *
     * @param year
     * @return ArrayList<AccountBuild_account>
     * @throws RemoteException
     */

    public ArrayList<AccountBuild_account> getPastAccount(String year) throws RemoteException;
    /**
     * Po转换
     *
     * @param po
     * @return AccountBuild_account
     * @throws RemoteException
     */
    public AccountBuild_account PoToAccount(coPO po) throws RemoteException;
    /**
     * 得到历史期初建账 客户列表
     *
     * @param year
     * @return ArrayList<AccountBuild_consumer>
     * @throws RemoteException
     */
    public ArrayList<AccountBuild_consumer> getPastConsumer(String year) throws RemoteException;
    /**
     * PO转换
     *
     * @param po
     * @return AccountBuild_consumer
     * @throws RemoteException
     */
    public AccountBuild_consumer PoToConsumer(consumerPO po) throws RemoteException;
    /**
     * 得到历史期初建账 商品列表
     *
     * @param year
     * @return ArrayList<AccountBuild_good>
     * @throws RemoteException
     */

    public ArrayList<AccountBuild_good> getPastGoods(String year) throws RemoteException;
    /**
     * PO转换
     *
     * @param po
     * @return AccountBuild_good
     * @throws RemoteException
     */
    public AccountBuild_good PoToGood(goodsPO po) throws RemoteException;

}
