package client.BLservice.Saleman.SalemanConsumerManageblservice;

import shared.ResultMessage;
import client.Vo.consumerVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/2.
 */
public interface ConsumerManageInterface {
    public ResultMessage addConsumer(consumerVO consumer) throws RemoteException;
    public ResultMessage deleteConsumer(consumerVO consumer) throws RemoteException;
    public ResultMessage modifyConsumer(consumerVO consumer) throws RemoteException;
    public ArrayList<consumerVO> findConsumer(String keyword);
    public ArrayList<consumerVO> show();
}
