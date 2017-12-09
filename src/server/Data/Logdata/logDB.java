package server.Data.Logdata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Logdataservice.log;

import java.util.ArrayList;
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
    public List logstockGlance(String from, String to) {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "SELECT billno from LogEntity where adddate between to_date(?,'yyyy-MM-dd HH24-mi-ss') and to_date(?,'yyyy-MM-dd HH24-mi-ss')";
        hibtools.session.close();
        return hibtools.session.createQuery(hql).setParameter(0,from).setParameter(1,to).list();
    }

    @Override
    public List showbillDetail(String from,String to, String name, String consumer, String operator, String base) {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        List ret = new ArrayList();
        String hql = "SELECT billno from LogEntity where adddate between to_date(?,'yyyy-MM-dd HH24-mi-ss') and to_date(?,'yyyy-MM-dd HH24-mi-ss') and goodsname = ? and consumer = ? and operatorno = ? and base = ?";
        List<String> strings = (List<String>)hibtools.session.createQuery(hql).setParameter(0,from).setParameter(1,to).setParameter(2,name).setParameter(3,consumer).setParameter(4,operator).setParameter(5,base).list();
        for(String i : strings){
            String str = "from BuyinEntity ,SelloutEntity ,MoneyEntity ,GiftEntity ,StockexceptionEntity ,WarningEntity where keyno = ?";
            List temp = hibtools.session.createQuery(str).setParameter(0,i).list();
            ret.addAll(temp);
        }
        return ret;
    }



}
