package server.Data.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import shared.ResultMessage;


public class hibtools {
    private static Configuration config = null;
    public static SessionFactory sessionFactory = null;
    public static Session session = null;
    public static Transaction tx = null;
    public hibtools(){
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }
    public ResultMessage Save(Object o){
        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
        }catch (Exception e){
            return ResultMessage.Failure;
        }
        return ResultMessage.Success;
    }
    public ResultMessage Delete(Object o){
        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
        }catch (Exception e){
            return ResultMessage.Failure;
        }
        return ResultMessage.Success;
    }
    public ResultMessage Modify(Object o){
        try {
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
        }catch (Exception e){
            return ResultMessage.Failure;
        }
        return ResultMessage.Success;
    }

}
