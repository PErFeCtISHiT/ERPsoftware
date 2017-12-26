package server.hibernateEntities;

import javax.persistence.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 11:05 2017/11/30
 */
@Entity
@Table(name = "MONEYLIST", schema = "PIS")
public class MoneylistEntity {
    private String keyid;
    private String keyno;
    private String accountname;
    private Double sumall;
    private String note;

    @Id
    @Column(name = "KEYID", nullable = false, length = 20)
    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }


    @Basic
    @Column(name = "KEYNO", nullable = true, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "ACCOUNTNAME", nullable = true, length = 20)
    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    @Basic
    @Column(name = "SUMALL", nullable = true, precision = 0)
    public Double getSumall() {
        return sumall;
    }

    public void setSumall(Double sumall) {
        this.sumall = sumall;
    }

    @Basic
    @Column(name = "NOTE", nullable = true, length = 2000)
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

        MoneylistEntity that = (MoneylistEntity) o;

        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (accountname != null ? !accountname.equals(that.accountname) : that.accountname != null) return false;
        if (sumall != null ? !sumall.equals(that.sumall) : that.sumall != null) return false;
        return note != null ? note.equals(that.note) : that.note == null;
    }

    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (accountname != null ? accountname.hashCode() : 0);
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
