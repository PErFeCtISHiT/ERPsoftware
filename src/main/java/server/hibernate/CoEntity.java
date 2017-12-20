package server.hibernate;

import javax.persistence.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 12:08 2017/12/2
 */
@Entity
@Table(name = "CO", schema = "PIS")
public class CoEntity {
    private String keyname;
    private Double sumall;
    private String keyno;

    @Basic
    @Column(name = "KEYNAME", length = 20)
    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    @Basic
    @Column(name = "SUMALL")
    public Double getSumall() {
        return sumall;
    }

    public void setSumall(Double sumall) {
        this.sumall = sumall;
    }

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoEntity coEntity = (CoEntity) o;

        return (keyname != null ? keyname.equals(coEntity.keyname) : coEntity.keyname == null) && (sumall != null ? sumall.equals(coEntity.sumall) : coEntity.sumall == null) && (keyno != null ? keyno.equals(coEntity.keyno) : coEntity.keyno == null);
    }

    @Override
    public int hashCode() {
        int result = keyname != null ? keyname.hashCode() : 0;
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        result = 31 * result + (keyno != null ? keyno.hashCode() : 0);
        return result;
    }
}
