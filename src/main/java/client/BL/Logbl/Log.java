package client.BL.Logbl;

import javafx.beans.property.SimpleStringProperty;

public class Log {

    public final SimpleStringProperty time;
    public final SimpleStringProperty staffno;
    public final SimpleStringProperty operation;

    public Log(String time, String staffno, String operation) {
        this.time = new SimpleStringProperty(time);
        this.staffno = new SimpleStringProperty(staffno);
        this.operation = new SimpleStringProperty(operation);
    }

    public Log() {
        this.time = new SimpleStringProperty();
        this.staffno = new SimpleStringProperty();
        this.operation = new SimpleStringProperty();
    }

    public String gettime() {
        return time.get();
    }

    public void settime(String fName) {
        time.set(fName);
    }

    public String getstaffno() {
        return staffno.get();
    }

    public void setstaffno(String fName) {
        staffno.set(fName);
    }

    public String getoperation() {
        return operation.get();
    }

    public void setoperation(String fName) {
        operation.set(fName);
    }
}
