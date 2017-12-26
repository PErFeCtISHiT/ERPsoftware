package server.Data.Financedata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Financedataservice.accountInit;
import server.Po.AccountInitPO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.goodsPO;
import server.hibernateEntities.AccountInitEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:29 2017/12/10
 */
public class accountInitDB extends publicDB implements accountInit {
    private publicDB publicDB = new publicDB();

    @Override
    public List getPastAccount(String year) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from AccountInitEntity where keyyear = ?";
        List<coPO> ret = new ArrayList<>();
        List<AccountInitEntity> Entities = hibtools.session.createQuery(hql).setParameter(0, year).list();
        if (Entities.size() != 0) {
            AccountInitEntity accountInitEntity = Entities.get(0);
            String lists[] = accountInitEntity.getAccountlist().split(",");
            for (String i : lists) {
                List temp = publicDB.findbyNO(10, i);
                if (!temp.isEmpty())
                    ret.add((coPO) temp.get(0));
            }
        }
        hibtools.tx.commit();
        return ret;
    }

    @Override
    public List getPastConsumer(String year) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from AccountInitEntity where keyyear = ?";
        List<consumerPO> ret = new ArrayList<>();
        List<AccountInitEntity> Entities = hibtools.session.createQuery(hql).setParameter(0, year).list();
        if (Entities.size() != 0) {
            AccountInitEntity accountInitEntity = Entities.get(0);
            String lists[] = accountInitEntity.getConsumerlist().split(",");
            for (String i : lists) {
                List temp = publicDB.findbyNO(11, i);
                if (!temp.isEmpty())
                    ret.add((consumerPO) temp.get(0));
            }
        }
        hibtools.tx.commit();
        return ret;
    }

    @Override
    public List getPastGoods(String year) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from AccountInitEntity where keyyear = ?";
        List<goodsPO> ret = new ArrayList<>();
        List<AccountInitEntity> Entities = hibtools.session.createQuery(hql).setParameter(0, year).list();
        if (Entities.size() != 0) {
            AccountInitEntity accountInitEntity = Entities.get(0);
            String lists[] = accountInitEntity.getGoodslist().split(",");
            for (String i : lists) {
                List temp = publicDB.findbyNO(0, i);
                if (!temp.isEmpty())
                    ret.add((goodsPO) temp.get(0));
            }
        }
        hibtools.tx.commit();
        return ret;
    }


    @Override
    public void Build(String year) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        AccountInitPO accountInitPO = new AccountInitPO();
        accountInitPO.setKeyyear(year);
        accountInitPO.setKeyno(generateNO());
        List<goodsPO> goodsPOS = publicDB.findAll(0);
        StringBuilder goodsList = new StringBuilder();
        for (goodsPO i : goodsPOS) {
            goodsList.append(i.getKeyno()).append(",");
        }
        accountInitPO.setGoodslist(goodsList.toString());
        List<consumerPO> consumerPOS = publicDB.findAll(11);
        StringBuilder consumerList = new StringBuilder();
        for (consumerPO i : consumerPOS)
            consumerList.append(i.getKeyno()).append(",");
        accountInitPO.setConsumerlist(consumerList.toString());
        List<coPO> coPOS = publicDB.findAll(10);
        StringBuilder coList = new StringBuilder();
        for (coPO i : coPOS)
            coList.append(i.getKeyno());
        accountInitPO.setAccountlist(coList.toString());
        publicDB.addObject(accountInitPO, 20);
        hibtools.tx.commit();
    }

    private String generateNO() {
        StringBuilder no;
        List<AccountInitPO> POS = publicDB.findAll(20);
        if (POS.isEmpty())
            no = new StringBuilder("00001");
        else {
            int temp;
            int maxint = 0;
            for (AccountInitPO i : POS) {
                temp = Integer.parseInt(i.getKeyno().split("-")[2]);
                if (temp > maxint)
                    maxint = temp;
            }
            maxint++;
            no = new StringBuilder(String.valueOf(maxint));
            while (no.length() < 5)
                no.insert(0, "0");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        return "QCJZ" + "-" + df.format(new Date()) + "-" + no.toString();
    }
}
