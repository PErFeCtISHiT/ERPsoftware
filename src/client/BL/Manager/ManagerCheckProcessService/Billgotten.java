package client.BL.Manager.ManagerCheckProcessService;

import javafx.beans.property.SimpleStringProperty;

public class Billgotten {
    public final SimpleStringProperty Id;
    public final SimpleStringProperty BillType;
    public final SimpleStringProperty BillName;
    public final SimpleStringProperty BIllAccount;

    public Billgotten(String id, String billType, String billName, String bIllAccount){
        this.Id = new SimpleStringProperty(id);
        this.BillType =new SimpleStringProperty(billType);
        this.BillName =new SimpleStringProperty(billName);
        this.BIllAccount =new SimpleStringProperty(bIllAccount);
    }

    public String getId() {
        return Id.get();
    }
    public void setId(String id){
        Id.set(id);
    }

    public String getBillType() {
        return BillType.get();
    }
    public void setBillType(String billType){
        BillType.set(billType);
    }

    public String getBillName() {
        return BillName.get();}
    public void setBillName(String billName){
        BillName.set(billName);
    }

    public String getBIllAccount() {
        return BIllAccount.get();
    }
    public void setBIllAccount(String bIllAccount){
        BIllAccount.set(bIllAccount);
    }
}
