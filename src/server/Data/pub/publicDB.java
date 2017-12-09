package server.Data.pub;

import server.Data.tools.hibtools;
import server.Dataservice.pubservice.pub;
import server.Po.*;
import server.hibernate.*;
import shared.ResultMessage;
import shared.copyclass;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 13:53 2017/11/26
 */
public class publicDB implements pub {
    private static hibtools hib = new hibtools();
    private Object obj;
    private String hql;
    private Object po;
    /**
    *@author:pis
    *@description: 增删改查
    *@date: 15:39 2017/11/30
    */

    @Override
    public ResultMessage addObject(Object object,int type) {
        generate(type);
        copyclass.copy(object,obj);
        return hib.Save(obj);
    }

    @Override
    public ResultMessage deleteObject(Object object,int type) {
        generate(type);
        copyclass.copy(object,obj);
        return hib.Delete(obj);
    }

    @Override
    public ResultMessage modifyObject(Object object,int type) {
        generate(type);
        copyclass.copy(object,obj);
        return hib.Modify(obj);
    }

    @Override
    public List findAll(int type) {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        generate(type);
        List Entities = hibtools.session.createQuery(hql).list();
        List POS = new ArrayList<>();
        for(Object i : Entities){
            generate(type);
            copyclass.copy(i,po);
            POS.add(po);
        }
        hibtools.session.close();
        return POS;
    }

    @Override
    public List findbyNO(int type,String no) {
        hibtools.session = hibtools.sessionFactory.openSession();
        hibtools.tx = hibtools.session.beginTransaction();
        generate(type);
        hql += "where KEYNO = ?";
        List Entities = hibtools.session.createQuery(hql).setParameter(0,no).list();
        List POS = new ArrayList<>();
        for(Object i : Entities){
            generate(type);
            copyclass.copy(i,po);
            POS.add(po);
        }
        hibtools.session.close();
        return POS;
    }

    /**
    *@author:pis
    *@description: 产生Entity对象
    *@date: 10:11 2017/11/28
    */
    private void generate(int type){
        switch (type) {
            case 0:{
                obj = new GoodsEntity();
                po = new goodsPO();
                hql = "from GoodsEntity";
                break;
            }
            case 1:{
                obj = new GoodskindsEntity();
                po = new goodskindsPO();
                hql = "from GoodskindsEntity ";
                break;
            }
            case 2:{
                obj = new ConsumerEntity();
                po = new consumerPO();
                hql = "from ConsumerEntity ";
                break;
            }
            case 3:{
                obj = new BuyinEntity();
                po = new buyinPO();
                hql = "from BuyinEntity ";
                break;
            }
            case 4:{
                obj = new SelloutEntity();
                po = new selloutPO();
                hql = "from SelloutEntity ";
                break;
            }
            case 5:{
                obj = new MoneyEntity();
                po = new moneyPO();
                hql = "from MoneyEntity ";
                break;
            }
            case 6:{
                obj = new GiftEntity();
                po = new giftPO();
                hql = "from GiftEntity ";
                break;
            }
            case 7:{
                obj = new StockexceptionEntity();
                po = new stockexceptionPO();
                hql = "from StockexceptionEntity ";
                break;
            }
            case 8:{
                obj = new StockexceptionEntity();
                po = new stockexceptionPO();
                hql = "from StockexceptionEntity ";
                break;
            }
            case 9:{
                obj = new WarningEntity();
                po = new WarningPO();
                hql = "from WarningEntity ";
                break;
            }
            case 10:{
                obj = new CoEntity();
                po = new coPO();
                hql = "from CoEntity ";
                break;
            }
            case 11:{
                obj = new ConsumerEntity();
                po = new consumerPO();
                hql = "from ConsumerEntity ";
                break;
            }
            case 12:{
                obj = new CutEntity();
                po = new cutPO();
                hql = "from CutEntity ";
                break;
            }
            case 13:{
                obj = new LogEntity();
                po = new logPO();
                hql = "from LogEntity ";
                break;
            }
            case 14:{
                obj = new PackEntity();
                po = new packPO();
                hql = "from PackEntity ";
                break;
            }
            case 15:{
                obj = new UseEntity();
                po = new userPO();
                hql = "from UseEntity ";
                break;
            }
            case 16:{
                obj = new SaleEntity();
                po = new salePO();
                hql = "from SaleEntity ";
                break;
            }
            case 17:{
                obj = new GoodsoutlistEntity();
                po = new goodsOutListPO();
                hql = "from GoodsoutlistEntity ";
                break;
            }
            case 18:{
                obj = new MoneylistEntity();
                po = new moneyListPO();
                hql = "from MoneylistEntity ";
                break;
            }
            case 19:{
                obj = new StockgoodsEntity();
                po = new stockGoodsPO();
                hql = "from StockgoodsEntity ";
                break;
            }
        }
    }


}
