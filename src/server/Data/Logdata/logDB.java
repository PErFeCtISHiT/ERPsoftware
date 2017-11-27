package server.Data.Logdata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Logdataservice.log;
import server.Po.logPO;
import server.hibernate.LogEntity;
import shared.ResultMessage;
import shared.copyclass;

import java.sql.Time;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 13:46 2017/11/26
 */
public class logDB extends publicDB implements log {
    /**
    *@author:pis
    *@description: 从时间段返回单据编号
    *@date: 13:48 2017/11/26
    */
    @Override
    public List<String> logstockGlance(String from, String to) {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "SELECT billno from LogEntity where adddate between to_date(?,'yyyy-MM-dd HH24-mi-ss') and to_date(?,'yyyy-MM-dd HH24-mi-ss')";
        List<String> strings = (List<String>) hibtools.session.createQuery(hql).setParameter(0,from).setParameter(1,to).list();
        return strings;
    }

}
