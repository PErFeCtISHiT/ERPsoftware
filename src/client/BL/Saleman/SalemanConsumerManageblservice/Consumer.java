package client.BL.Saleman.SalemanConsumerManageblservice;


import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Leonarda on 2017/12/2.
 */
public class Consumer {
    public SimpleStringProperty ConsumerID;
    public SimpleStringProperty ConsumerKind;
    public SimpleStringProperty ConsumerLevel;
    public SimpleStringProperty ConsumerName;
    public SimpleStringProperty ConsumerPhone;
    public SimpleStringProperty ConsumerMail;
    public SimpleStringProperty ConsumerEmail;
    public SimpleStringProperty ConsumerReveiveMoney;
    public SimpleStringProperty ConsumerReceive;
    public SimpleStringProperty ConsumerPay;
    public SimpleStringProperty Salesman;
    public SimpleStringProperty accout;

    public Consumer(String id,String kind,String level,String name,String phone,String mail,String email,String capa,String reveive,String pay,String sale,String acc){
        this.ConsumerID=new SimpleStringProperty(id);
        this.ConsumerKind=new SimpleStringProperty(kind);
        this.ConsumerLevel=new SimpleStringProperty(level);
        this.ConsumerName=new SimpleStringProperty(name);
        this.ConsumerPhone=new SimpleStringProperty(phone);
        this.ConsumerMail=new SimpleStringProperty(mail);
        this.ConsumerEmail=new SimpleStringProperty(email);
        this.ConsumerReveiveMoney=new SimpleStringProperty(capa);
        this.ConsumerReceive=new SimpleStringProperty(reveive);
        this.ConsumerPay=new SimpleStringProperty(pay);
        this.Salesman=new SimpleStringProperty(sale);
        this.accout=new SimpleStringProperty(acc);
    }
    public Consumer(){}

    public String getConsumerPhone() {
        return ConsumerPhone.get();
    }

    public String getConsumerName() {
        return ConsumerName.get();
    }

    public String getConsumerLevel() {
        return ConsumerLevel.get();
    }

    public String getConsumerMail() {
        return ConsumerMail.get();
    }

    public String getConsumerID() {
        return ConsumerID.get();
    }

    public String getSalesman() {
        return Salesman.get();
    }

    public String getConsumerReveiveMoney() {
        return ConsumerReveiveMoney.get();
    }

    public String getConsumerReceive() {
        return ConsumerReceive.get();
    }

    public String getConsumerPay() {
        return ConsumerPay.get();
    }

    public String getConsumerEmail() {
        return ConsumerEmail.get();
    }

    public String getAccout() {
        return accout.get();
    }

    public String getConsumerKind() {
        return ConsumerKind.get();
    }

    public void setConsumerPhone(String consumerPhone) {
        this.ConsumerPhone.set(consumerPhone);
    }

    public void setConsumerName(String consumerName) {
        this.ConsumerName.set(consumerName);
    }

    public void setConsumerLevel(String consumerLevel) {
        this.ConsumerLevel.set(consumerLevel);
    }

    public void setConsumerMail(String consumerMail) {
        this.ConsumerMail.set(consumerMail);
    }

    public void setConsumerID(String consumerID) {
        this.ConsumerID.set(consumerID);
    }

    public void setConsumerKind(String consumerKind) {
        this.ConsumerKind.set(consumerKind);
    }

    public void setSalesman(String salesman) {
        this.Salesman.set(salesman);
    }

    public void setConsumerReveiveMoney(String consumerReveiveMoney) {
        this.ConsumerReveiveMoney.set(consumerReveiveMoney);
    }

    public void setConsumerReceive(String consumerReceive) {
        this.ConsumerReceive.set(consumerReceive);
    }

    public void setConsumerPay(String consumerPay) {
        this.ConsumerPay.set(consumerPay);
    }

    public void setConsumerEmail(String consumerEmail) {
        this.ConsumerEmail.set(consumerEmail);
    }

    public void setAccout(String accout) {
        this.accout.set(accout);
    }
}












