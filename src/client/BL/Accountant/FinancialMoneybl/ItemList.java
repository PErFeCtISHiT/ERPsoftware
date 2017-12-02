package client.BL.Accountant.FinancialMoneybl;

import javafx.beans.property.SimpleStringProperty;

public class ItemList {
    public final SimpleStringProperty item;
    public final SimpleStringProperty money;
    public final SimpleStringProperty comment;


    public ItemList(String item, String money, String comment) {
        this.item = new SimpleStringProperty(item);
        this.money = new SimpleStringProperty(money);
        this.comment = new SimpleStringProperty(comment);
    }

    public String getAccount() {
        return item.get();
    }

    public void setAccount(String fName) {
        item.set(fName);
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
