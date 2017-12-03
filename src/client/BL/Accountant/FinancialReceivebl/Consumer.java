package client.BL.Accountant.FinancialReceivebl;

import javafx.beans.property.SimpleStringProperty;

public  class Consumer {

    public final SimpleStringProperty consumerID;
    public final SimpleStringProperty consumerName;
    public final SimpleStringProperty consumerLevel;
    public final SimpleStringProperty staff;
    public final SimpleStringProperty inOutGap;
    public final SimpleStringProperty dueIN;
    public final SimpleStringProperty actualIN;
    public final SimpleStringProperty duePay;

    public Consumer(String consumerID, String consumerName, String consumerLevel,String staff, String inOutGap, String dueIN,String actualIN, String duePay) {
        this.consumerID = new SimpleStringProperty(consumerID);
        this.consumerName = new SimpleStringProperty(consumerName);
        this.consumerLevel = new SimpleStringProperty(consumerLevel);
        this.staff = new SimpleStringProperty(staff);
        this.inOutGap = new SimpleStringProperty(inOutGap);
        this.dueIN = new SimpleStringProperty(dueIN);
        this.actualIN = new SimpleStringProperty(actualIN);
        this.duePay = new SimpleStringProperty(duePay);
    }

//        public String getconsumerID() {return consumerID.get();}
//
//        public void setaccountID(String fName) {consumerID.set(fName);}
//
//        public String getaccountID() {return accountID.get();}
//
//        public void setaccountID(String fName) {accountID.set(fName);}
//
//        public String getaccountID() {return accountID.get();}
//
//        public void setaccountID(String fName) {accountID.set(fName);}
//
//        public String getaccountID() {return accountID.get();}
//
//        public void setaccountID(String fName) {accountID.set(fName);}
//
//        public String getaccountID() {return accountID.get();}
//
//        public void setaccountID(String fName) {accountID.set(fName);}
//
//        public String getaccountID() {return accountID.get();}
//
//        public void setaccountID(String fName) {accountID.set(fName);}
//
//        public String getaccountID() {return accountID.get();}
//
//        public void setaccountID(String fName) {accountID.set(fName);}
//
//        public String getaccountID() {return accountID.get();}
//
//        public void setaccountID(String fName) {accountID.set(fName);}


}