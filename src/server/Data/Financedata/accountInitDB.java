package server.Data.Financedata;

import client.Presentation.NOgenerator.NOgenerator;
import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Financedataservice.accountInit;
import server.Po.AccountInitPO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.goodsPO;
import server.hibernate.AccountInitEntity;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:29 2017/12/10
 */
public class accountInitDB extends publicDB implements accountInit {
    private publicDB publicDB = new publicDB();
    @Override
    public List getPastAccount(String year) throws RemoteException {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from AccountInitEntity where keyyear = ?";
        List<coPO> ret = new ArrayList<>();
        List<AccountInitEntity> Entities = hibtools.session.createQuery(hql).setParameter(0,year).list();
        if(Entities.size() != 0) {
            AccountInitEntity accountInitEntity = Entities.get(0);
            String lists[] = accountInitEntity.getAccountlist().split(",");
            for(String i : lists){
                List temp = publicDB.findbyNO(10,i);
                if(!temp.isEmpty())
                    ret.add((coPO) temp.get(0));
            }
        }
        hibtools.session.close();
        return ret;
    }

    @Override
    public List getPastConsumer(String year) throws RemoteException {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from AccountInitEntity where keyyear = ?";
        List<consumerPO> ret = new ArrayList<>();
        List<AccountInitEntity> Entities = hibtools.session.createQuery(hql).setParameter(0,year).list();
        if(Entities.size() != 0) {
            AccountInitEntity accountInitEntity = Entities.get(0);
            String lists[] = accountInitEntity.getConsumerlist().split(",");
            for(String i : lists){
                List temp = publicDB.findbyNO(11,i);
                if(!temp.isEmpty())
                    ret.add((consumerPO) temp.get(0));
            }
        }
        hibtools.session.close();
        return ret;
    }

    @Override
    public List getPastGoods(String year) throws RemoteException {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from AccountInitEntity where keyyear = ?";
        List<goodsPO> ret = new ArrayList<>();
        List<AccountInitEntity> Entities = hibtools.session.createQuery(hql).setParameter(0,year).list();
        if(Entities.size() != 0) {
            AccountInitEntity accountInitEntity = Entities.get(0);
            String lists[] = accountInitEntity.getGoodslist().split(",");
            for(String i : lists){
                List temp = publicDB.findbyNO(0,i);
                if(!temp.isEmpty())
                    ret.add((goodsPO) temp.get(0));
            }
        }
        hibtools.session.close();
        return ret;
    }

    @Override
    public void Build(String year) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        AccountInitPO accountInitPO = new AccountInitPO();
        accountInitPO.setKeyyear(year);
        accountInitPO.setKeyno(NOgenerator.generate(20));
        List<goodsPO> goodsPOS = publicDB.findAll(0);
        StringBuilder goodsList = new StringBuilder();
        for(goodsPO i : goodsPOS){
            goodsList.append(i.getKeyno()).append(",");
        }
        accountInitPO.setGoodslist(goodsList.toString());
        List<consumerPO> consumerPOS = publicDB.findAll(11);
        StringBuilder consumerList = new StringBuilder();
        for(consumerPO i : consumerPOS)
            consumerList.append(i.getKeyno()).append(",");
        accountInitPO.setConsumerlist(consumerList.toString());
        List<coPO> coPOS = publicDB.findAll(10);
        StringBuilder coList = new StringBuilder();
        for(coPO i : coPOS)
            coList.append(i.getKeyno());
        accountInitPO.setAccountlist(coList.toString());
        hibtools.session.close();
        publicDB.addObject(accountInitPO,20);
    }
}
