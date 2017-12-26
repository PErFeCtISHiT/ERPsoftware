package server.Data.Codata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Codataservice.Coaccount;
import server.Po.coPO;
import server.hibernateEntities.CoEntity;
import shared.copyclass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:02 2017/11/27
 */
public class CoaccountDB extends publicDB implements Coaccount {
    @Override
    public List findAccount(String keyword) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from CoEntity y where y.keyname like '%" + keyword + "%'" + "or y.keyno like '%" + keyword + "%'";
        List<CoEntity> goodsEntities = (List<CoEntity>) hibtools.session.createQuery(hql).list();
        List<coPO> goodsPOS = new ArrayList<>();
        for (CoEntity i : goodsEntities) {
            coPO temp = new coPO();
            copyclass.copy(i, temp);
            goodsPOS.add(temp);

        }
        hibtools.tx.commit();
        return goodsPOS;
    }

}
