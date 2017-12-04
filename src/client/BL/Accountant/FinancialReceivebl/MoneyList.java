package client.BL.Accountant.FinancialReceivebl;

import javafx.beans.property.SimpleStringProperty;

public class MoneyList {

    public final SimpleStringProperty listNO;
    public final SimpleStringProperty account;
    public final SimpleStringProperty money;
    public final SimpleStringProperty comment;


    public MoneyList(String listNO, String account, String money, String comment) {
        this.listNO= new SimpleStringProperty(listNO);
        this.account = new SimpleStringProperty(account);
        this.money = new SimpleStringProperty(money);
        this.comment = new SimpleStringProperty(comment);
    }

    public MoneyList() {
        this.listNO= new SimpleStringProperty();
        this.account = new SimpleStringProperty();
        this.money = new SimpleStringProperty();
        this.comment = new SimpleStringProperty();
    }

    public String getlistNO() {
        return listNO.get();
    }

    public void setlistNO(String fName) {
        listNO.set(fName);
    }

    public String getAccount() {
        return account.get();
    }

    public void setAccount(String fName) {
        account.set(fName);
    }

    public String getMoney() {
        return money.get();
    }

    public void setMoney(String fName) {
        money.set(fName);
    }

    public String getComment() {
        return comment.get();
    }

    public void setComment(String fName) {
        comment.set(fName);
    }


}
