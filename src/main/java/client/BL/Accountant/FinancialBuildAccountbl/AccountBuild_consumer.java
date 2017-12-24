package client.BL.Accountant.FinancialBuildAccountbl;

import javafx.beans.property.SimpleStringProperty;


/**
 * 期初建账——客户 领域对象
 *
 * 包含客户ID，客户名称，客户类型，收支差，应收金额，应付金额
 */


public class AccountBuild_consumer {
    public final SimpleStringProperty consumerID;
    public final SimpleStringProperty consumerName;
    public final SimpleStringProperty consumerType;
    public final SimpleStringProperty inOutGap;
    public final SimpleStringProperty dueIN;
    public final SimpleStringProperty duePay;

    public AccountBuild_consumer(String consumerID, String consumerName, String consumerType, String inOutGap, String dueIN, String duePay) {
        this.consumerID = new SimpleStringProperty(consumerID);
        this.consumerName = new SimpleStringProperty(consumerName);
        this.consumerType = new SimpleStringProperty(consumerType);
        this.inOutGap = new SimpleStringProperty(inOutGap);
        this.dueIN = new SimpleStringProperty(dueIN);
        this.duePay = new SimpleStringProperty(duePay);
    }
    public AccountBuild_consumer( ) {
        this.consumerID = new SimpleStringProperty();
        this.consumerName = new SimpleStringProperty();
        this.consumerType = new SimpleStringProperty();
        this.inOutGap = new SimpleStringProperty();
        this.dueIN = new SimpleStringProperty();
        this.duePay = new SimpleStringProperty();
    }

    public String getconsumerID() {return consumerID.get();}

    public void setconsumerID(String fName) {consumerID.set(fName);}

    public String getconsumerName() {return consumerName.get();}

    public void setconsumerName(String fName) {consumerName.set(fName);}

    public String getconsumerType() {return consumerType.get();}

    public void setconsumerType(String fName) {consumerType.set(fName);}

    public String getinOutGap() {return inOutGap.get();}

    public void setinOutGap(String fName) {inOutGap.set(fName);}

    public String getdueIN() {return dueIN.get();}

    public void setdueIN(String fName) {dueIN.set(fName);}

    public String getduePay() {return duePay.get();}

    public void setduePay(String fName) {duePay.set(fName);}

}
