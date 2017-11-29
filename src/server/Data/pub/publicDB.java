package server.Data.pub;

import server.Data.tools.hibtools;
import server.Dataservice.pubservice.pub;
import server.hibernate.*;
import shared.ResultMessage;
import shared.copyclass;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 13:53 2017/11/26
 */
public class publicDB implements pub {
    hibtools hib = new hibtools();
    Object obj;

    @Override
    public ResultMessage addObject(Object object,int type) {
        generateobj(type);

        copyclass.copy(object,obj);
        return hib.Save(obj);
    }

    @Override
    public ResultMessage deleteObject(Object object,int type) {
        generateobj(type);
        copyclass.copy(object,obj);
        return hib.Delete(obj);
    }

    @Override
    public ResultMessage modifyObject(Object object,int type) {
        generateobj(type);
        copyclass.copy(object,obj);
        return hib.Modify(obj);
    }
    /**
    *@author:pis
    *@description: 产生Entity对象
    *@date: 10:11 2017/11/28
    */
    private void generateobj(int type){
        switch (type) {
            case 0:{
                obj = new GoodsEntity();
                break;
            }
            case 1:{
                obj = new GoodskindsEntity();
                break;
            }
            case 2:{
                obj = new ConsumerEntity();
                break;
            }
            case 3:{
                obj = new BuyinEntity();
                break;
            }
            case 4:{
                obj = new SelloutEntity();
                break;
            }
            case 5:{
                obj = new MoneyEntity();
                break;
            }
            case 6:{
                obj = new GiftEntity();
                break;
            }
            case 7:{
                obj = new StockexceptionEntity();
                break;
            }
            case 8:{
                obj = new StockexceptionEntity();
                break;
            }
            case 9:{
                obj = new WarningEntity();
                break;
            }
            case 10:{
                obj = new CoEntity();
                break;
            }
            case 11:{
                obj = new ConsumerEntity();
                break;
            }
            case 12:{
                obj = new CutEntity();
                break;
            }
            case 13:{
                obj = new LogEntity();
                break;
            }
            case 14:{
                obj = new PackEntity();
                break;
            }
            case 15:{
                obj = new UseEntity();
                break;
            }
        }
    }
}
