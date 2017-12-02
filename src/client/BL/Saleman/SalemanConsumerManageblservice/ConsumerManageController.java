package client.BL.Saleman.SalemanConsumerManageblservice;

import client.BLservice.Saleman.SalemanConsumerManageblservice.ConsumerManageInterface;
import client.RMI.link;
import client.Vo.consumerVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/2.
 */
public class ConsumerManageController implements ConsumerManageInterface{
    @Override
    public ArrayList<consumerVO> findConsumer(String keyword) {
        return null;
    }

    @Override
    public ArrayList<consumerVO> show() {
        return null;
    }

    @Override
    public ResultMessage addConsumer(consumerVO consumer) throws RemoteException {
        return link.getRemoteHelper().getConsumer().addObject(consumer,10);
    }

    @Override
    public ResultMessage deleteConsumer(consumerVO consumer) throws RemoteException {
        return link.getRemoteHelper().getConsumer().deleteObject(consumer,10);
    }

    @Override
    public ResultMessage modifyConsumer(consumerVO consumer) throws RemoteException {
        return link.getRemoteHelper().getConsumer().modifyObject(consumer,10);
    }



}
