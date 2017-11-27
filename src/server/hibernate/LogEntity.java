package server.hibernate;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "LOG", schema = "PIS", catalog = "")
public class LogEntity {
    private Time adddate;
    private String keyno;
    private String keyjob;
    private String operatorno;
    private String billno;
    private String opno;
    private String note;

    @Basic
    @Column(name = "ADDDATE", nullable = true)
    public Time getAdddate() {
        return adddate;
    }

    public void setAdddate(Time adddate) {
        this.adddate = adddate;
    }

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "KEYJOB", nullable = true, length = 20)
    public String getKeyjob() {
        return keyjob;
    }

    public void setKeyjob(String keyjob) {
        this.keyjob = keyjob;
    }

    @Basic
    @Column(name = "OPERATORNO", nullable = true, length = 20)
    public String getOperatorno() {
        return operatorno;
    }

    public void setOperatorno(String operatorno) {
        this.operatorno = operatorno;
    }

    @Basic
    @Column(name = "BILLNO", nullable = true, length = 20)
    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    @Basic
    @Column(name = "OPNO", nullable = true, length = 20)
    public String getOpno() {
        return opno;
    }

    public void setOpno(String opno) {
        this.opno = opno;
    }

    @Basic
    @Column(name = "NOTE", nullable = true, length = 20)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (adddate != null ? !adddate.equals(logEntity.adddate) : logEntity.adddate != null) return false;
        if (keyno != null ? !keyno.equals(logEntity.keyno) : logEntity.keyno != null) return false;
        if (keyjob != null ? !keyjob.equals(logEntity.keyjob) : logEntity.keyjob != null) return false;
        if (operatorno != null ? !operatorno.equals(logEntity.operatorno) : logEntity.operatorno != null) return false;
        if (billno != null ? !billno.equals(logEntity.billno) : logEntity.billno != null) return false;
        if (opno != null ? !opno.equals(logEntity.opno) : logEntity.opno != null) return false;
        if (note != null ? !note.equals(logEntity.note) : logEntity.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adddate != null ? adddate.hashCode() : 0;
        result = 31 * result + (keyno != null ? keyno.hashCode() : 0);
        result = 31 * result + (keyjob != null ? keyjob.hashCode() : 0);
        result = 31 * result + (operatorno != null ? operatorno.hashCode() : 0);
        result = 31 * result + (billno != null ? billno.hashCode() : 0);
        result = 31 * result + (opno != null ? opno.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
