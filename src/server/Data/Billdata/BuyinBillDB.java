package server.Data.Billdata;

import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Billdataservice.buyinBill;
import server.Po.buyinPO;
import server.hibernate.BuyinEntity;
import shared.copyclass;

import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:29 2017/11/26
 */
public class BuyinBillDB extends publicDB implements buyinBill {

    /**
     *@author:pis
     *@description: 各种操作的持久化
     *@date: 10:30 2017/11/26
     */


    @Override
    public buyinPO buyinfindByNO(String No) {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from BuyinEntity where keyno = ?";
        List<BuyinEntity> BuyinEntitys = (List<BuyinEntity>)hibtools.session.createQuery(hql)
                .setParameter(0,No).list();
        hibtools.session.close();
        if(BuyinEntitys.size() == 0)
            return null;
        BuyinEntity ret = BuyinEntitys.get(0);
        buyinPO buyinpo = new buyinPO();
        copyclass.copy(ret,buyinpo);
        return buyinpo;
    }
}

