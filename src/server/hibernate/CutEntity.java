package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "CUT", schema = "PIS", catalog = "")
public class CutEntity {
    private String keyno;
    private Double lev;
    private Double cut;
    private String voucher;
    private String packno;

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "LEV", nullable = true, precision = 0)
    public Double getLev() {
        return lev;
    }

    public void setLev(Double lev) {
        this.lev = lev;
    }

    @Basic
    @Column(name = "CUT", nullable = true, precision = 0)
    public Double getCut() {
        return cut;
    }

    public void setCut(Double cut) {
        this.cut = cut;
    }

    @Basic
    @Column(name = "VOUCHER", nullable = true, length = 20)
    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    @Basic
    @Column(name = "PACKNO", nullable = true, length = 200)
    public String getPackno() {
        return packno;
    }

    public void setPackno(String packno) {
        this.packno = packno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CutEntity cutEntity = (CutEntity) o;

        if (keyno != null ? !keyno.equals(cutEntity.keyno) : cutEntity.keyno != null) return false;
        if (lev != null ? !lev.equals(cutEntity.lev) : cutEntity.lev != null) return false;
        if (cut != null ? !cut.equals(cutEntity.cut) : cutEntity.cut != null) return false;
        if (voucher != null ? !voucher.equals(cutEntity.voucher) : cutEntity.voucher != null) return false;
        if (packno != null ? !packno.equals(cutEntity.packno) : cutEntity.packno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (lev != null ? lev.hashCode() : 0);
        result = 31 * result + (cut != null ? cut.hashCode() : 0);
        result = 31 * result + (voucher != null ? voucher.hashCode() : 0);
        result = 31 * result + (packno != null ? packno.hashCode() : 0);
        return result;
    }
}
