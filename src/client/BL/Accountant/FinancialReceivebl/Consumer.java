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
    public Consumer( ) {
        this.consumerID = new SimpleStringProperty();
        this.consumerName = new SimpleStringProperty();
        this.consumerLevel = new SimpleStringProperty();
        this.staff = new SimpleStringProperty();
        this.inOutGap = new SimpleStringProperty();
        this.dueIN = new SimpleStringProperty();
        this.actualIN = new SimpleStringProperty();
        this.duePay = new SimpleStringProperty();
    }

        public String getconsumerID() {return consumerID.get();}

        public void setconsumerID(String fName) {consumerID.set(fName);}

        public String getconsumerName() {return consumerName.get();}

        public void setconsumerName(String fName) {consumerName.set(fName);}

        public String getconsumerLevel() {return consumerLevel.get();}

        public void setconsumerLevel(String fName) {consumerLevel.set(fName);}

        public String getstaff() {return staff.get();}

        public void setstaff(String fName) {staff.set(fName);}

        public String getinOutGap() {return inOutGap.get();}

        public void setinOutGap(String fName) {inOutGap.set(fName);}

        public String getdueIN() {return dueIN.get();}

        public void setdueIN(String fName) {dueIN.set(fName);}

        public String getactualIN() {return actualIN.get();}

        public void setactualIN(String fName) {actualIN.set(fName);}

        public String getduePay() {return duePay.get();}

        public void setduePay(String fName) {duePay.set(fName);}


}