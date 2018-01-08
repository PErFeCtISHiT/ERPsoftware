package client.BL.Accountant.FinancialAccountbl;

import javafx.beans.property.SimpleStringProperty;

/**
 * Account 领域对象
 * 包含：ID 名称 金额
 */

public class Account {

    //ID 名称 金额

    public final SimpleStringProperty accountID;
    public final SimpleStringProperty accountName;
    public final SimpleStringProperty money;

    public Account(String accountID, String accountName, String money) {
        this.accountID = new SimpleStringProperty(accountID);
        this.accountName = new SimpleStringProperty(accountName);
        this.money = new SimpleStringProperty(money);
    }

    public Account() {
        this.accountID = new SimpleStringProperty();
        this.accountName = new SimpleStringProperty();
        this.money = new SimpleStringProperty();
    }

    public String getaccountID() {
        return accountID.get();
    }

    public void setaccountID(String fName) {
        accountID.set(fName);
    }

    public String getaccountName() {
        return accountName.get();
    }

    public void setaccountName(String fName) {
        accountName.set(fName);
    }

    public String getmoney() {
        return money.get();
    }

    public void setmoney(String fName) {
        money.set(fName);
    }
}

