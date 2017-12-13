package client.BL.Saleman.SalemanConsumerManageblservice;

import client.BLservice.Saleman.SalemanConsumerManageblservice.ConsumerManageInterface;
import client.RMI.link;
import client.Vo.consumerVO;
import server.Po.consumerPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/2.
 */
public class ConsumerManageController implements ConsumerManageInterface{
    @Override
    public ArrayList<consumerVO> findConsumer(String keyword) {
        return null;
    }

    @Override
    public List show() throws RemoteException {
        List<consumerPO> list=link.getRemoteHelper().getConsumer().findAll(2);
        List<consumerVO> resultlist=new ArrayList<>();
        for(consumerPO po:list){
            consumerVO vo=new consumerVO(
                    po.getKeyno(),
                    po.getKinds(),
                    po.getLev(),
                    po.getKeyname(),
                    po.getTel(),
                    po.getMailcode(),
                    po.getEmail(),
                    po.getCapacit(),
                    po.getReceive(),
                    po.getPay(),
                    po.getServer(),
                    po.getAccoun()
            );
            resultlist.add(vo);
        }
        return resultlist;
    }

    @Override
    public ResultMessage addConsumer(consumerVO consumer) throws RemoteException {
        System.out.println(link.getRemoteHelper().getConsumer());
        return link.getRemoteHelper().getConsumer().addObject(consumer,2);
    }

    @Override
    public ResultMessage deleteConsumer(consumerVO consumer) throws RemoteException {
        return link.getRemoteHelper().getConsumer().deleteObject(consumer,2);
    }

    @Override
    public ResultMessage modifyConsumer(consumerVO consumer) throws RemoteException {
        return link.getRemoteHelper().getConsumer().modifyObject(consumer,2);
    }


    public List findbyid(String id) throws RemoteException{
        return link.getRemoteHelper().getConsumer().findbyNO(2,id);
    }

    @Override
    public Consumer VOtoconsumer(consumerVO vo) {
        return new Consumer(vo.getKeyno(),vo.getKinds().toString(),vo.getLev().toString(),vo.getKeyname(),vo.getTel(),vo.getMailcode(),vo.getEmail(),vo.getCapacit().toString(),vo.getReceive().toString(),vo.getPay().toString(),vo.getServer(),vo.getAccoun());
    }

    @Override
    public consumerVO consumerToVO(Consumer consumer) {
        return new consumerVO(consumer.getConsumerID(),Double.parseDouble(consumer.getConsumerKind()),Double.parseDouble(consumer.getConsumerLevel()),consumer.getConsumerName(),consumer.getConsumerPhone(),consumer.getConsumerMail(),consumer.getConsumerEmail(),Double.parseDouble(consumer.getConsumerReveiveMoney()),Double.parseDouble(consumer.getConsumerReceive()),Double.parseDouble(consumer.getConsumerPay()),consumer.getSalesman(),consumer.getAccout());
    }


}
