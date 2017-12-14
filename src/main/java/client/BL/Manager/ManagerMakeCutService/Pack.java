package client.BL.Manager.ManagerMakeCutService;

import javafx.beans.property.SimpleStringProperty;

public class Pack {
    public SimpleStringProperty Id;
    public SimpleStringProperty CutRate;
    public Pack(String id,String cutrate){
        this.Id =new SimpleStringProperty(id);
        this.CutRate =new SimpleStringProperty(cutrate);
    }

    public String getCutRate() {
        return CutRate.get();
    }

    public String getId() {
        return Id.get();
    }
    public void setCutRate(String rate){
        CutRate.set(rate);
    }
    public void setId(String id){
        Id.set(id);
    }
}
