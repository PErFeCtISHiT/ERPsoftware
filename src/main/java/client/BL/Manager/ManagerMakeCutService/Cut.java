package client.BL.Manager.ManagerMakeCutService;

import javafx.beans.property.SimpleStringProperty;

public  class Cut{
    public final SimpleStringProperty vip;
    public final SimpleStringProperty strategy;
    public final SimpleStringProperty commodity;
    public final SimpleStringProperty begintime;
    public final SimpleStringProperty endtime;
    public final SimpleStringProperty packin;


    public Cut(String vip, String strategy, String commodity, String begintime,String endtime,String packin){
        this.vip = new SimpleStringProperty(vip);
        this.strategy =new SimpleStringProperty(strategy);
        this.commodity =new SimpleStringProperty(commodity);
        this.begintime =new SimpleStringProperty(begintime);
        this.endtime =new SimpleStringProperty(endtime);
        this.packin =new SimpleStringProperty(packin);

    }

    public String getVip() {
        return vip.get();
    }
    public void setvip(String VIP){
        vip.set(VIP);
    }

    public String getStrategy() {
        return strategy.get();
    }

    public void setStrategy(String strategy1){
        strategy.set(strategy1);
    }

    public String getCommodity() {
        return commodity.get();
    }

    public void setCommodity(String commodity1){
        commodity.set(commodity1);
    }

    public String getBegintime() {
        return begintime.get();
    }
    public void setBegintime(String begintime1){
        begintime.set(begintime1);
    }
    public String getEndtime() {
        return endtime.get();
    }
    public void setEndtime(String endtime1){
        endtime.set(endtime1);
    }

    public String getPackin() {
        return packin.get();
    }
    public void setPackin(String packin1){
        packin.set(packin1);
    }

}