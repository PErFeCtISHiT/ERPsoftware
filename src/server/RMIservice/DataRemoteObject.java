package server.RMIservice;
import server.Data.Billdata.*;
import server.Data.Codata.CoaccountDB;
import server.Data.Consumerdata.ConsumerDB;
import server.Data.Cutdata.cutDB;
import server.Data.Goodsdata.GoodsDB;
import server.Data.Goodsdata.GoodsKindsDB;
import server.Data.Logdata.logDB;
import server.Data.Packdata.packDB;
import server.Data.Userdata.userDB;
import server.Data.pub.publicDB;
import server.Dataservice.Billdataservice.*;
import server.Dataservice.Codataservice.Coaccount;
import server.Dataservice.Consumerdataservice.Consumer;
import server.Dataservice.Cutdataservice.cut;
import server.Dataservice.Goodsdataservice.Goods;
import server.Dataservice.Goodsdataservice.GoodsKinds;
import server.Dataservice.Logdataservice.log;
import server.Dataservice.Packdataservice.pack;
import server.Dataservice.Userdataservice.user;
import server.Dataservice.pubservice.pub;
import server.Po.buyinPO;
import server.Po.selloutPO;
import shared.ResultMessage;


import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;

import java.util.List;


public class DataRemoteObject extends UnicastRemoteObject implements
        moneyBill, selloutBill,stockDamageBill,stockOverflowBill,stockwarningBill,
        Coaccount,Consumer,Goods,GoodsKinds,log,cut,pack,user, buyinBill,giftBill, pub {

    /**

     *

     */

    private static final long serialVersionUID = 4029039744279087114L;
    private buyinBill buyinBill;
    private giftBill giftBill;
    private moneyBill moneyBill;
    private selloutBill selloutBill;
    private stockDamageBill stockDamageBill;
    private stockOverflowBill stockOverflowBill;
    private stockwarningBill stockwarningBill;
    private Coaccount coaccount;
    private Consumer consumer;
    private cut cut;
    private Goods goods;
    private GoodsKinds goodsKinds;
    private log log;
    private pack pack;
    private pub pub;
    private user user;

    protected DataRemoteObject() throws RemoteException {

        buyinBill = new BuyinBillDB();
        giftBill = new giftBillDB();
        moneyBill = new moneyBillDB();
        selloutBill = new SelloutBillDB();
        stockDamageBill = new stockDamageBillDB();
        stockOverflowBill = new stockOverflowBillDB();
        stockwarningBill = new stockwarningBillDB();
        coaccount = new CoaccountDB();
        consumer = new ConsumerDB();
        cut = new cutDB();
        goods = new GoodsDB();
        goodsKinds = new GoodsKindsDB();
        log = new logDB();
        pack = new packDB();
        pub = new publicDB();
        user = new userDB();



    }


    @Override
    public buyinPO buyinfindByNO(String No)throws RemoteException {
        return buyinBill.buyinfindByNO(No);
    }

    @Override
    public selloutPO selloutfindByNO(String No)throws RemoteException {
        return selloutBill.selloutfindByNO(No);
    }

    @Override
    public List goodsfindGoods(String keyword)throws RemoteException {
        return goods.goodsfindGoods(keyword);
    }

    @Override
    public List goodsfindByKind(String kind)throws RemoteException {
        return goods.goodsfindByKind(kind);
    }

    @Override
    public List goodsfindAll()throws RemoteException {
        return goods.goodsfindAll();
    }

    @Override
    public List goodsKindsFindAll()throws RemoteException {
        return goodsKinds.goodsKindsFindAll();
    }

    @Override
    public List goodsKindsFind(String keyword)throws RemoteException {
        return goodsKinds.goodsKindsFind(keyword);
    }


    @Override
    public List<String> logstockGlance(String from, String to)throws RemoteException {
        return log.logstockGlance(from,to);
    }

    @Override
    public ResultMessage addObject(Object object,int type) throws RemoteException{
        return pub.addObject(object,type);
    }

    @Override
    public ResultMessage deleteObject(Object object,int type)throws RemoteException {
        return pub.deleteObject(object,type);
    }

    @Override
    public ResultMessage modifyObject(Object object,int type)throws RemoteException {
        return pub.modifyObject(object,type);
    }
}