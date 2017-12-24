package client.BL.Accountant.FinancialReceivebl;

import javafx.beans.property.SimpleStringProperty;

public class AccountBill {

    public final SimpleStringProperty kind;
    public final SimpleStringProperty keyno;
    public final SimpleStringProperty consumertype;
    public final SimpleStringProperty oper;
    public final SimpleStringProperty ischeck;
    public final SimpleStringProperty isred;
    public final SimpleStringProperty isDraft;
    public final SimpleStringProperty consumer;
    public final SimpleStringProperty accoun;
    public final SimpleStringProperty sumall;
    public final SimpleStringProperty moneyList;

    public AccountBill(String kind, String keyno, String consumertype,String oper,
                       String ischeck, String isred,String isDraft, String consumer,String accoun,String sumall, String moneyList) {
        this.kind = new SimpleStringProperty(kind);
        this.keyno = new SimpleStringProperty(keyno);
        this.consumertype = new SimpleStringProperty(consumertype);
        this.oper = new SimpleStringProperty(oper);
        this.ischeck = new SimpleStringProperty(ischeck);
        this.isred = new SimpleStringProperty(isred);
        this.isDraft = new SimpleStringProperty(isDraft);
        this.consumer = new SimpleStringProperty(consumer);
        this.accoun = new SimpleStringProperty(accoun);
        this.sumall = new SimpleStringProperty(sumall);
        this.moneyList = new SimpleStringProperty(moneyList);

    }
    public AccountBill( ) {
        this.kind = new SimpleStringProperty();
        this.keyno = new SimpleStringProperty();
        this.consumertype = new SimpleStringProperty();
        this.oper = new SimpleStringProperty();
        this.ischeck = new SimpleStringProperty();
        this.isred = new SimpleStringProperty();
        this.isDraft = new SimpleStringProperty();
        this.consumer = new SimpleStringProperty();
        this.accoun = new SimpleStringProperty();
        this.sumall = new SimpleStringProperty();
        this.moneyList = new SimpleStringProperty();
    }





    public String getConsumertype() {
        return consumertype.get();
    }

    public void setConsumertype(String consumertype) {
        this.consumertype.set(consumertype);
    }

    public String getMoneyList() {
        return moneyList.get();
    }

    public void setMoneyList(String moneyList) { this.moneyList.set(moneyList);}

    public String getKind() {
        return kind.get();
    }

    public void setKind(String kind) {
        this.kind.set(kind);
    }

    public String getKeyno() {
        return keyno.get();
    }

    public void setKeyno(String keyno) {
        this.keyno.set(keyno);
    }

    public String getOper() {
        return oper.get();
    }

    public void setOper(String oper) {
        this.oper.set(oper);
    }

    public String getIscheck() {
        return ischeck.get();
    }

    public void setIscheck(String ischeck) { this.ischeck.set(ischeck); }

    public String getIsred() {
        return isred.get();
    }

    public void setIsred(String isred) {
        this.isred.set(isred);
    }

    public String getIsDraft() {
        return isDraft.get();
    }

    public void setIsDraft(String isDraft) { this.isDraft.set(isDraft); }

    public String getConsumer() {
        return consumer.get();
    }

    public void setConsumer(String consumer) {
        this.consumer.set(consumer);
    }

    public String getAccoun() {
        return accoun.get();
    }

    public void setAccoun(String accoun) {
        this.accoun.set(accoun);
    }

    public String getSumall() {
        return sumall.get();
    }

    public void setSumall(String sumall) {
        this.sumall.set(sumall);
    }


}
