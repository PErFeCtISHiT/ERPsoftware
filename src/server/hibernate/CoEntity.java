package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "CO", schema = "PIS", catalog = "")
public class CoEntity {
    private String keyname;
    private Long sumall;

    @Id
    @Column(name = "KEYNAME", nullable = false, length = 20)
    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    @Basic
    @Column(name = "SUMALL", nullable = true, precision = 0)
    public Long getSumall() {
        return sumall;
    }

    public void setSumall(Long sumall) {
        this.sumall = sumall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoEntity coEntity = (CoEntity) o;

        if (keyname != null ? !keyname.equals(coEntity.keyname) : coEntity.keyname != null) return false;
        if (sumall != null ? !sumall.equals(coEntity.sumall) : coEntity.sumall != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyname != null ? keyname.hashCode() : 0;
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        return result;
    }
}
