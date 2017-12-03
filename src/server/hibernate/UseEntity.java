package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "USE", schema = "PIS", catalog = "")
public class UseEntity {
    private String keyjob;
    private String keyno;
    private Double lev;
    private String keyname;
    private String tel;
    private String address;
    private String postcode;
    private String email;
    private Double keyyear;
    private String passwor;

    @Basic
    @Column(name = "KEYJOB", nullable = true, length = 20)
    public String getKeyjob() {
        return keyjob;
    }

    public void setKeyjob(String keyjob) {
        this.keyjob = keyjob;
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
    @Column(name = "LEV", nullable = true, precision = 0)
    public Double getLev() {
        return lev;
    }

    public void setLev(Double lev) {
        this.lev = lev;
    }

    @Basic
    @Column(name = "KEYNAME", nullable = true, length = 20)
    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    @Basic
    @Column(name = "TEL", nullable = true, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "POSTCODE", nullable = true, length = 20)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "KEYYEAR", nullable = true, precision = 0)
    public Double getKeyyear() {
        return keyyear;
    }

    public void setKeyyear(Double keyyear) {
        this.keyyear = keyyear;
    }

    @Basic
    @Column(name = "PASSWOR", nullable = true, length = 50)
    public String getPasswor() {
        return passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UseEntity useEntity = (UseEntity) o;

        if (keyjob != null ? !keyjob.equals(useEntity.keyjob) : useEntity.keyjob != null) return false;
        if (keyno != null ? !keyno.equals(useEntity.keyno) : useEntity.keyno != null) return false;
        if (lev != null ? !lev.equals(useEntity.lev) : useEntity.lev != null) return false;
        if (keyname != null ? !keyname.equals(useEntity.keyname) : useEntity.keyname != null) return false;
        if (tel != null ? !tel.equals(useEntity.tel) : useEntity.tel != null) return false;
        if (address != null ? !address.equals(useEntity.address) : useEntity.address != null) return false;
        if (postcode != null ? !postcode.equals(useEntity.postcode) : useEntity.postcode != null) return false;
        if (email != null ? !email.equals(useEntity.email) : useEntity.email != null) return false;
        if (keyyear != null ? !keyyear.equals(useEntity.keyyear) : useEntity.keyyear != null) return false;
        if (passwor != null ? !passwor.equals(useEntity.passwor) : useEntity.passwor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyjob != null ? keyjob.hashCode() : 0;
        result = 31 * result + (keyno != null ? keyno.hashCode() : 0);
        result = 31 * result + (lev != null ? lev.hashCode() : 0);
        result = 31 * result + (keyname != null ? keyname.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (keyyear != null ? keyyear.hashCode() : 0);
        result = 31 * result + (passwor != null ? passwor.hashCode() : 0);
        return result;
    }
}
