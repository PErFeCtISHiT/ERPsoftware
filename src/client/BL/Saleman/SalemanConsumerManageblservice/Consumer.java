package client.BL.Saleman.SalemanConsumerManageblservice;


import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Leonarda on 2017/12/2.
 */
public class Consumer {
    public SimpleStringProperty ConsumerID;
    public SimpleStringProperty ConsumerStockin;
    public SimpleStringProperty ConsumerSell;
    public SimpleStringProperty ConsumerLevel;
    public SimpleStringProperty ConsumerName;
    public SimpleStringProperty ConsumerPhone;
    public SimpleStringProperty ConsumerAddress;
    public SimpleStringProperty ConsumerMail;
    public SimpleStringProperty ConsumerEmail;
    public SimpleStringProperty ConsumerReveiveMoney;
    public SimpleStringProperty ConsumerReceive;
    public SimpleStringProperty ConsumerPay;
    public SimpleStringProperty Salesman;
    public String name;
    public String level;

    public Consumer(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m){
        this.ConsumerID=new SimpleStringProperty(a);
        this.ConsumerStockin=new SimpleStringProperty(b);
        this.ConsumerSell=new SimpleStringProperty(c);
        this.ConsumerLevel=new SimpleStringProperty(d);
        this.ConsumerName=new SimpleStringProperty(e);
        this.ConsumerPhone=new SimpleStringProperty(f);
        this.ConsumerAddress=new SimpleStringProperty(g);
        this.ConsumerMail=new SimpleStringProperty(h);
        this.ConsumerEmail=new SimpleStringProperty(i);
        this.ConsumerReveiveMoney=new SimpleStringProperty(j);
        this.ConsumerReceive=new SimpleStringProperty(k);
        this.ConsumerPay=new SimpleStringProperty(l);
        this.Salesman=new SimpleStringProperty(m);
    }

    public Consumer(String a,String b){
        this.name=a;
        this.level=b;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConsumerID(String consumerID) {
        this.ConsumerID.set(consumerID);
    }

    public void setConsumerLevel(String consumerLevel) {
        this.ConsumerLevel.set(consumerLevel);
    }

    public void setConsumerName(String consumerName) {
        this.ConsumerName.set(consumerName);
    }

    public void setConsumerSell(String consumerSell) {
        this.ConsumerSell.set(consumerSell);
    }

    public void setConsumerPhone(String consumerPhone) {
        this.ConsumerPhone.set(consumerPhone);
    }

    public void setConsumerStockin(String consumerStockin) {
        this.ConsumerStockin.set(consumerStockin);
    }

    public void setConsumerAddress(String consumerAddress) {
        this.ConsumerAddress.set(consumerAddress);
    }

    public void setConsumerEmail(String consumerEmail) {
        this.ConsumerEmail.set(consumerEmail);
    }

    public void setConsumerMail(String consumerMail) {
        this.ConsumerMail.set(consumerMail);
    }

    public void setConsumerPay(String consumerPay) {
        this.ConsumerPay.set(consumerPay);
    }

    public void setConsumerReceive(String consumerReceive) {
        this.ConsumerReceive.set(consumerReceive);
    }

    public void setConsumerReveiveMoney(String consumerReveiveMoney) {
        this.ConsumerReveiveMoney.set(consumerReveiveMoney);
    }

    public void setSalesman(String salesman) {
        this.Salesman.set(salesman);
    }

    public String getConsumerAddress() {
        return ConsumerAddress.get();
    }

    public String getConsumerEmail() {
        return ConsumerEmail.get();
    }

    public String getConsumerID() {
        return ConsumerID.get();
    }

    public String getConsumerLevel() {
        return ConsumerLevel.get();
    }

    public String getConsumerMail() {
        return ConsumerMail.get();
    }

    public String getConsumerName() {
        return ConsumerName.get();
    }

    public String getConsumerPay() {
        return ConsumerPay.get();
    }

    public String getConsumerPhone() {
        return ConsumerPhone.get();
    }

    public String getConsumerReceive() {
        return ConsumerReceive.get();
    }

    public String getConsumerReveiveMoney() {
        return ConsumerReveiveMoney.get();
    }

    public String getConsumerSell() {
        return ConsumerSell.get();
    }

    public String getConsumerStockin() {
        return ConsumerStockin.get();
    }

    public String getSalesman() {
        return Salesman.get();
    }


}












