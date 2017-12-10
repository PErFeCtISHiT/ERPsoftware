package server.Data.Financedata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Financedataservice.accountInit;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.goodsPO;
import server.hibernate.AccountInitEntity;

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
}
