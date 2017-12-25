package client.BL.Accountant.FinancialBuildAccountbl;

import javafx.beans.property.SimpleStringProperty;

/**
 * 期初建账——账户 领域对象
 *
 * 包含账户ID，账户名称，金额
 */

public class AccountBuild_account {
    public final SimpleStringProperty accountID;
    public final SimpleStringProperty accountName;
    public final SimpleStringProperty money;

    public AccountBuild_account(String accountID, String accountName, String money) {
        this.accountID = new SimpleStringProperty(accountID);
        this.accountName = new SimpleStringProperty(accountName);
        this.money = new SimpleStringProperty(money);
    }

    public AccountBuild_account() {
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
