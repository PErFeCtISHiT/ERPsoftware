package client.BL.Administrator.Userblservice;

import javafx.beans.property.SimpleStringProperty;
import org.omg.CORBA.NO_IMPLEMENT;

public class UserMsg {
    public final SimpleStringProperty Name;
    public final SimpleStringProperty No;
    public final SimpleStringProperty Password;
    public final SimpleStringProperty Job;



    public UserMsg(String name, String num, String password, String job){
        this.Name = new SimpleStringProperty(name);
        this.No =new SimpleStringProperty(num);
        this.Password =new SimpleStringProperty(password);
        this.Job =new SimpleStringProperty(job);

    }

    public String getName(){
        return Name.get();
    }
    public void setName(String name){
        Name.set(name);
    }
    public String getNO() {
        return No.get();
    }
    public void setNo(String no){
        No.set(no);
    }

    public String getPassward() {
        return Password.get();
    }
    public void setPassword(String id){
        Password.set(id);
    }

    public String getJob() {
        return Job.get();}
    public void setJob(String jo){
        Job.set(jo);
    }


}
