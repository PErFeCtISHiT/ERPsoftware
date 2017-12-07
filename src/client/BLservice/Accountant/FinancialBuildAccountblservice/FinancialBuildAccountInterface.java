package client.BLservice.Accountant.FinancialBuildAccountblservice;

import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinancialBuildAccountInterface {


    public void accountbuild() throws RemoteException;

    public void getPast(String year) throws RemoteException;

}
