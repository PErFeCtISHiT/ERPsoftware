package client.BLservice.Accountant.FinancialBuildAccountblservice;

import client.BL.Accountant.FinancialBuildAccountbl.AccountBuild;
import client.BL.Accountant.FinancialBuildAccountbl.AccountBuild_account;
import client.BL.Accountant.FinancialBuildAccountbl.AccountBuild_consumer;
import client.BL.Accountant.FinancialBuildAccountbl.AccountBuild_good;
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

public interface FinancialBuildAccountInterface {


    public AccountBuild accountbuild() throws RemoteException;

    public AccountBuild getPast(String year) throws RemoteException;

    public ArrayList<AccountBuild_account> getPastAccount(String year) throws RemoteException;

    public AccountBuild_account PoToAccount(coPO po) throws RemoteException;

    public ArrayList<AccountBuild_consumer> getPastConsumer(String year) throws RemoteException;

    public AccountBuild_consumer PoToConsumer(consumerPO po) throws RemoteException;

    public ArrayList<AccountBuild_good> getPastGoods(String year) throws RemoteException;

    public AccountBuild_good PoToGood(goodsPO po) throws RemoteException;

}
