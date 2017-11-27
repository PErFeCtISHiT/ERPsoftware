package server.Data.Goodsdata;

import server.Data.pub.publicDB;
import shared.copyclass;
import server.Data.tools.hibtools;
import server.Dataservice.Goodsdataservice.GoodsKinds;
import server.Po.goodskindsPO;
import server.hibernate.GoodskindsEntity;
import shared.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class GoodsKindsDB extends publicDB implements GoodsKinds{

    @Override
    public List goodsKindsFindAll() {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from GoodskindsEntity ";
        List<GoodskindsEntity> goodskindsEntities = (List<GoodskindsEntity>)hibtools.session.createQuery(hql).list();
        List<goodskindsPO> goodskindsPOS = new ArrayList<>();
        for(GoodskindsEntity i : goodskindsEntities){
            goodskindsPO temp = new goodskindsPO();
            copyclass.copy(i,temp);
            goodskindsPOS.add(temp);
        }
        hibtools.session.close();
        return goodskindsPOS;
    }

    @Override
    public List goodsKindsFind(String keyword) {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from GoodskindsEntity where keyno like ? or keyname like ?";
        List<GoodskindsEntity> goodsEntities = (List<GoodskindsEntity>)hibtools.session.createQuery(hql)
                .setParameter(0,keyword).setParameter(1,keyword).list();
        List<goodskindsPO> goodskindsPOS = new ArrayList<>() ;
        for(GoodskindsEntity i : goodsEntities){
            goodskindsPO temp = new goodskindsPO();
            copyclass.copy(i,temp);
            goodskindsPOS.add(temp);

        }
        hibtools.session.close();
        return goodskindsPOS;
    }
}
