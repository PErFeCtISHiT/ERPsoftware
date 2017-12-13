package server.Data.Consumerdata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Consumerdataservice.Consumer;
import server.Po.coPO;
import server.Po.consumerPO;
import server.hibernate.CoEntity;
import server.hibernate.ConsumerEntity;
import shared.copyclass;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:03 2017/11/27
 */
public class ConsumerDB extends publicDB implements Consumer{

    @Override
    public List findConsumer(String keyword) throws RemoteException {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from ConsumerEntity where keyno like ? or keyname like ?";
        List<ConsumerEntity> goodsEntities = (List<ConsumerEntity>)hibtools.session.createQuery(hql)
                .setParameter(0,keyword).setParameter(1,keyword).list();
        List<consumerPO> goodsPOS = new ArrayList<>() ;
        for(ConsumerEntity i : goodsEntities){
            consumerPO temp = new consumerPO();
            copyclass.copy(i,temp);
            goodsPOS.add(temp);

        }
        hibtools.session.close();
        return goodsPOS;
    }
}
