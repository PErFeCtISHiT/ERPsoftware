package client.BL.Manager.ManagerCheckProcessService;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.SimpleStringProperty;
import sun.nio.cs.ext.ISCII91;

public class Billgotten {
    //类型 编号 操作员 审批状态 是否红冲
    public final SimpleStringProperty Type;
    public final SimpleStringProperty Id;
    public final SimpleStringProperty Operator;
    public final SimpleStringProperty State;
    public final SimpleStringProperty IsHongChong;



    public Billgotten(String type, String id, String operator, String state,String ishongchong ){
        this.Type = new SimpleStringProperty(type);
        this.Id =new SimpleStringProperty(id);
        this.Operator =new SimpleStringProperty(operator);
        this.State =new SimpleStringProperty(state);
        this.IsHongChong =new SimpleStringProperty(ishongchong);
    }

    public String getType() {
        return Type.get();
    }
    public void setType(String type){
        Type.set(type);
    }

    public String getId() {
        return Id.get();
    }
    public void setId(String id){
        Id.set(id);
    }

    public String getOperator() {
        return Operator.get();}
    public void setOperator(String operator){
        Operator.set(operator);
    }

    public String getState() {
        return State.get();
    }
    public void setState(String state){
        State.set(state);
    }

    public String getIsHongChong() {
        return IsHongChong.get();
    }
    public void setIsHongChong(String ishongChong){
        IsHongChong.set(ishongChong);
    }

}