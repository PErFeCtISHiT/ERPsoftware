package server.Data.Userdata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Userdataservice.user;
import server.Po.userPO;
import server.hibernateEntities.UseEntity;
import shared.copyclass;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:05 2017/11/27
 */
public class userDB extends publicDB implements user {
    @Override
    public List login(String username, String password) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from UseEntity where keyname = ? and passwor = ?";
        List temp = hibtools.session.createQuery(hql).setParameter(0, username).setParameter(1, password).list();
        hibtools.tx.commit();
        List POS = new ArrayList<>();
        for (Object i : temp) {
            userPO userPO = new userPO();
            copyclass.copy(i, userPO);
            POS.add(userPO);
        }
        return POS;
    }

    @Override
    public String getpasswordByName(String username) throws RemoteException {
            hibtools.session = hibtools.sessionFactory.getCurrentSession();
            hibtools.tx = hibtools.session.beginTransaction();
            String hql = "from UseEntity where keyname like ?";
            List<UseEntity> useEntities = (List<UseEntity>) hibtools.session.createQuery(hql)
                    .setParameter(0, username).list();
            String password = useEntities.get(0).getPasswor();
            hibtools.tx.commit();
            return password;
        }
}
