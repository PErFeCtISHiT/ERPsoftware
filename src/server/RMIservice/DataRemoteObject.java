package server.RMIservice;
import client.Vo.saleVO;
import server.Data.Billdata.*;
import server.Data.Codata.CoaccountDB;
import server.Data.Consumerdata.ConsumerDB;
import server.Data.Cutdata.cutDB;
import server.Data.Financedata.accountInitDB;
import server.Data.Financedata.goodsoutListDB;
import server.Data.Financedata.moneyListDB;
import server.Data.Financedata.saleDB;
import server.Data.Goodsdata.GoodsDB;
import server.Data.Goodsdata.GoodsKindsDB;
import server.Data.Goodsdata.stockGoodsDB;
import server.Data.Logdata.logDB;
import server.Data.Packdata.packDB;
import server.Data.Userdata.userDB;
import server.Data.pub.publicDB;
import server.Dataservice.Billdataservice.*;
import server.Dataservice.Codataservice.Coaccount;
import server.Dataservice.Consumerdataservice.Consumer;
import server.Dataservice.Cutdataservice.cut;
import server.Dataservice.Financedataservice.accountInit;
import server.Dataservice.Financedataservice.goodsoutList;
import server.Dataservice.Financedataservice.moneyList;
import server.Dataservice.Financedataservice.sale;
import server.Dataservice.Goodsdataservice.Goods;
import server.Dataservice.Goodsdataservice.GoodsKinds;
import server.Dataservice.Goodsdataservice.stockGoods;
import server.Dataservice.Logdataservice.log;
import server.Dataservice.Packdataservice.pack;
import server.Dataservice.Userdataservice.user;
import server.Dataservice.pubservice.pub;
import server.Po.buyinPO;
import server.Po.selloutPO;
import shared.ResultMessage;


import java.io.IOException;
import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;

import java.util.List;


public class DataRemoteObject extends UnicastRemoteObject implements accountInit,
        moneyBill, selloutBill,stockOverflowBill,stockwarningBill,moneyList,stockGoods,
        Coaccount,Consumer,Goods,GoodsKinds,log,cut,pack,user, buyinBill,giftBill, pub ,sale,goodsoutList {

    /**

     *

     */

    private static final long serialVersionUID = 4029039744279087114L;
    private moneyList moneyList;
    private buyinBill buyinBill;
    private giftBill giftBill;
    private moneyBill moneyBill;
    private selloutBill selloutBill;
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
    private goodsoutList goodsoutList;
    private sale sale;
    private stockGoods stockGoods;
    private accountInit accountInit;

    DataRemoteObject() throws RemoteException {

        moneyList = new moneyListDB();
        buyinBill = new BuyinBillDB();
        giftBill = new giftBillDB();
        moneyBill = new moneyBillDB();
        selloutBill = new SelloutBillDB();
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
        goodsoutList = new goodsoutListDB() ;
        sale = new saleDB();
        stockGoods = new stockGoodsDB();
        accountInit = new accountInitDB();



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
    public List goodsKindsFind(String keyword)throws RemoteException {
        return goodsKinds.goodsKindsFind(keyword);
    }


    @Override
    public List logstockGlance(String from, String to)throws RemoteException {
        return log.logstockGlance(from,to);
    }

    @Override
    public List showbillDetail(String from, String to, String name, String consumer, String operator, String base) throws RemoteException{
        return log.showbillDetail(from,to,name,consumer,operator,base);
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

    @Override
    public List findAll(int type) throws RemoteException {
        return pub.findAll(type);
    }

    @Override
    public List findbyNO(int type, String no) throws RemoteException {
        return pub.findbyNO(type,no);
    }

    @Override
    public ResultMessage exportToExcel(int type, String path) throws RemoteException,IOException {
        return pub.exportToExcel(type,path);
    }


    @Override
    public List findbySaleVO(saleVO saleVO) throws RemoteException {
        return sale.findbySaleVO(saleVO);
    }

    @Override
    public List login(String username, String password) throws RemoteException{
        return user.login(username,password);
    }

    @Override
    public List getPastAccount(String year) throws RemoteException {
        return accountInit.getPastAccount(year);
    }

    @Override
    public List getPastConsumer(String year) throws RemoteException {
        return accountInit.getPastConsumer(year);
    }

    @Override
    public List getPastGoods(String year) throws RemoteException {
        return accountInit.getPastGoods(year);
    }
}