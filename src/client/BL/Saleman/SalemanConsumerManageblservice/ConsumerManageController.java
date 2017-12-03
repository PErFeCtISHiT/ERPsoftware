package client.BL.Saleman.SalemanConsumerManageblservice;

import client.BLservice.Saleman.SalemanConsumerManageblservice.ConsumerManageInterface;
import client.RMI.link;
import client.Vo.consumerVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/2.
 */
public class ConsumerManageController implements ConsumerManageInterface{
    @Override
    public ArrayList<consumerVO> findConsumer(String keyword) {
        return null;
    }

    @Override
    public ArrayList<consumerVO> show() {
        return null;
    }

    @Override
    public ResultMessage addConsumer(consumerVO consumer) throws RemoteException {
        System.out.println(link.getRemoteHelper().getConsumer());
        return link.getRemoteHelper().getConsumer().addObject(consumer,2);
    }

    @Override
    public ResultMessage deleteConsumer(consumerVO consumer) throws RemoteException {
        return link.getRemoteHelper().getConsumer().deleteObject(consumer,2);
    }

    @Override
    public ResultMessage modifyConsumer(consumerVO consumer) throws RemoteException {
        return link.getRemoteHelper().getConsumer().modifyObject(consumer,2);
    }

    @Override
    public Consumer VOtoconsumer(consumerVO vo) {

        String ConsumerID=vo.getKeyno();
        String ConsumerStockin="0";
        String ConsumerSell="0";
        String ConsumerLevel=String.valueOf(vo.getLev());
        String ConsumerName=vo.getKeyname();
        String ConsumerPhone=vo.getTel();
        String ConsumerAddress="0";
        String ConsumerMail=vo.getMailcode();
        String ConsumerEmail=vo.getEmail();
        String ConsumerReveiveMoney=String.valueOf(vo.getCapacit());
        String ConsumerReceive=String.valueOf(vo.getReceive());
        String ConsumerPay=String.valueOf(vo.getPay());
        String Salesman=vo.getServer();

        return new Consumer(ConsumerID,ConsumerStockin,ConsumerSell,ConsumerLevel,ConsumerName,ConsumerPhone,ConsumerAddress,ConsumerMail,ConsumerEmail,ConsumerReveiveMoney,ConsumerReceive,ConsumerPay,Salesman);

    }

    @Override
    public consumerVO consumerToVO(Consumer consumer) {

        String keyno=consumer.getConsumerID();  //客户编号
        double kinds=0;  //分类
        double lev=Double.parseDouble(consumer.getConsumerLevel());    //级别
        String keyname=consumer.getConsumerName(); //姓名
        String tel=consumer.getConsumerPhone();  //电话
        String mailcode=consumer.getConsumerMail();  //邮编
        String email=consumer.getConsumerEmail();   //电子邮箱
        double capacit=Double.parseDouble(consumer.getConsumerReveiveMoney());    //应收额度
        double receive=Double.parseDouble(consumer.getConsumerReceive());    //应收
        double pay=Double.parseDouble(consumer.getConsumerPay());     //应付
        String server=consumer.getSalesman();   //业务员
        String accoun="ssss";    //银行账户

        return new consumerVO(keyno,kinds,lev,keyname,tel,mailcode,email,capacit,receive,pay,server,accoun);
    }


}
