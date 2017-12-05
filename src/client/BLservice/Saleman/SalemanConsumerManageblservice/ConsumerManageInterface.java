package client.BLservice.Saleman.SalemanConsumerManageblservice;

import client.BL.Saleman.SalemanConsumerManageblservice.Consumer;
import shared.ResultMessage;
import client.Vo.consumerVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/2.
 */
public interface ConsumerManageInterface {
    ResultMessage addConsumer(consumerVO consumer) throws RemoteException;
    ResultMessage deleteConsumer(consumerVO consumer) throws RemoteException;
    ResultMessage modifyConsumer(consumerVO consumer) throws RemoteException;
    ArrayList<consumerVO> findConsumer(String keyword);
    ArrayList<consumerVO> show();
    consumerVO consumerToVO(Consumer consumer);
    Consumer VOtoconsumer(consumerVO vo);
}
