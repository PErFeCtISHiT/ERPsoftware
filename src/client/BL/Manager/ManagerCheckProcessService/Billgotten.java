package client.BL.Manager.ManagerCheckProcessService;

import javafx.beans.property.SimpleStringProperty;

public class Billgotten {
    //类型 编号 操作员 审批状态 是否红冲
    //新增属性 账单类型
    /**
     * precisetype int 详细可见信息视角
     */
    private  int Precisetype;
    public final SimpleStringProperty Type;
    public final SimpleStringProperty Id;
    public final SimpleStringProperty Operator;
    public final SimpleStringProperty State;
    public final SimpleStringProperty IsHongChong;



    public Billgotten(int precisetype, String type, String id, String operator, String state, String ishongchong){
        this.Precisetype = precisetype;
        this.Type = new SimpleStringProperty(type);
        this.Id =new SimpleStringProperty(id);
        this.Operator =new SimpleStringProperty(operator);
        this.State =new SimpleStringProperty(state);
        this.IsHongChong =new SimpleStringProperty(ishongchong);
    }

    public int getPrecisetype(){
        return this.Precisetype;
    }
    public void setPrecisetype(int PreciseType){
        this.Precisetype =PreciseType;
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