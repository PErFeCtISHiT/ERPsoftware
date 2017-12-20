package server.Data.Financedata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Financedataservice.moneyList;
import server.Po.moneyListPO;
import shared.copyclass;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 14:01 2017/12/5
 */
public class moneyListDB extends publicDB implements moneyList {
    @Override
    public void deleteByNO(String no) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from MoneylistEntity where keyno = ?";
        publicDB publicDB = new publicDB();
        List Entities = hibtools.session.createQuery(hql).setParameter(0,no).list();
        hibtools.session.close();
        for(Object i : Entities) {
            moneyListPO moneyListPO = new moneyListPO();
            copyclass.copy(i, moneyListPO);
            publicDB.deleteObject(moneyListPO, 18);
        }
        hibtools.tx.commit();
    }
}
