package server.hibernateEntities;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 11:44 2017/12/2
 */
@Entity
@Table(name = "LOG", schema = "PIS")
public class LogEntity {
    private Date adddate;
    private String keyno;
    private String keyjob;
    private String operatorno;
    private String billno;
    private String opno;
    private String note;
    private String goodsname;
    private String consumer;
    private String base;

    @Basic
    @Column(name = "ADDDATE", nullable = true)
    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
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
    @Column(name = "NOTE", nullable = true, length = 2000)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "GOODSNAME", nullable = true, length = 20)
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    @Basic
    @Column(name = "CONSUMER", nullable = true, length = 20)
    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Basic
    @Column(name = "BASE", nullable = true, length = 20)
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
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
        if (goodsname != null ? !goodsname.equals(logEntity.goodsname) : logEntity.goodsname != null) return false;
        if (consumer != null ? !consumer.equals(logEntity.consumer) : logEntity.consumer != null) return false;
        return base != null ? base.equals(logEntity.base) : logEntity.base == null;
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
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (consumer != null ? consumer.hashCode() : 0);
        result = 31 * result + (base != null ? base.hashCode() : 0);
        return result;
    }
}
