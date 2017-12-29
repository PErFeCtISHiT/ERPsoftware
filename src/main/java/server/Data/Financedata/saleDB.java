package server.Data.Financedata;

import client.Vo.saleVO;
import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Financedataservice.sale;
import server.Po.goodsOutListPO;
import server.Po.salePO;
import server.hibernateEntities.SaleEntity;
import shared.copyclass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 21:25 2017/12/3
 */
public class saleDB extends publicDB implements sale {
    publicDB publicDB = new publicDB();

    public List findbySaleVO(saleVO saleVO) {
        String[] str;
        List<goodsOutListPO> ret = new ArrayList<>();
        if (saleVO.getKind() == 0) {//入库类sale
            str = saleVO.getGoodsoutlist().split(",");

        } else//出库类sale
            str = saleVO.getGoodsoutlist().split(",");
        for (String s : str) {
            List temp = publicDB.findbyNO(17, s);
            if (!temp.isEmpty())
                ret.add((goodsOutListPO) temp.get(0));
        }
        return ret;
    }

    /**
     * @author:pis
     * @description: 时间，操作员，仓库查询
     * @date: 16:45 2017/12/11
     */
    @Override
    public List search(String detail) {
        String temp[] = detail.split(",");
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        String hql = "from SaleEntity where operater like ? and base like ?";
        List<SaleEntity> Entities = (List<SaleEntity>) hibtools.session.createQuery(hql)
                .setParameter(0, temp[2]).setParameter(1, temp[3]).list();
        Long from = dateToLong(temp[0]);
        Long to = dateToLong(temp[1]);
        List<salePO> ret = new ArrayList<>();
        for (SaleEntity i : Entities) {
            Long between = dateToLong(i.getDateandtime());
            if (between >= from && between <= to) {
                salePO salePO = new salePO();
                copyclass.copy(i, salePO);
                ret.add(salePO);
            }
        }
        hibtools.tx.commit();
        return ret;

    }

    private Long dateToLong(String s) {
        String temp[] = s.split("-");
        return Long.parseLong(temp[0]) * 10000 + Long.parseLong(temp[1]) * 100 + Long.parseLong(temp[2]);
    }
}
