package client.BL.Saleman.SalemanConsumerManageblservice;

import client.BLservice.Saleman.SalemanConsumerManageblservice.ConsumerManageInterface;
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
        return null;
    }

    @Override
    public ResultMessage deleteConsumer(consumerVO consumer) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage modifyConsumer(consumerVO consumer) throws RemoteException {
        return null;
    }

}
