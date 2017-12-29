package client.BL.Accountant.FinancialBuildAccountbl;

import javafx.beans.property.SimpleStringProperty;

public class AccountList {

    public final SimpleStringProperty year;

    AccountList() {
        this.year = new SimpleStringProperty();
    }

    public AccountList(String fName) {
        this.year = new SimpleStringProperty(fName);
    }

    public String getYear() {
        return year.get();
    }

    public void setYear(String fName) {
        year.set(fName);
    }
}