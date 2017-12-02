package server.Dataservice.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "CONSUMER", schema = "PIS", catalog = "")
public class ConsumerEntity {
    private String keyno;
    private Long kinds;
    private Long lev;
    private String keyname;
    private String tel;
    private String mailcode;
    private String email;
    private Long capacit;
    private Long receive;
    private Long pay;
    private String server;
    private String accoun;

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "KINDS", nullable = true, precision = 0)
    public Long getKinds() {
        return kinds;
    }

    public void setKinds(Long kinds) {
        this.kinds = kinds;
    }

    @Basic
    @Column(name = "LEV", nullable = true, precision = 0)
    public Long getLev() {
        return lev;
    }

    public void setLev(Long lev) {
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
    @Column(name = "MAILCODE", nullable = true, length = 20)
    public String getMailcode() {
        return mailcode;
    }

    public void setMailcode(String mailcode) {
        this.mailcode = mailcode;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "CAPACIT", nullable = true, precision = 0)
    public Long getCapacit() {
        return capacit;
    }

    public void setCapacit(Long capacit) {
        this.capacit = capacit;
    }

    @Basic
    @Column(name = "RECEIVE", nullable = true, precision = 0)
    public Long getReceive() {
        return receive;
    }

    public void setReceive(Long receive) {
        this.receive = receive;
    }

    @Basic
    @Column(name = "PAY", nullable = true, precision = 0)
    public Long getPay() {
        return pay;
    }

    public void setPay(Long pay) {
        this.pay = pay;
    }

    @Basic
    @Column(name = "SERVER", nullable = true, length = 20)
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Basic
    @Column(name = "ACCOUN", nullable = true, length = 20)
    public String getAccoun() {
        return accoun;
    }

    public void setAccoun(String accoun) {
        this.accoun = accoun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumerEntity that = (ConsumerEntity) o;

        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (kinds != null ? !kinds.equals(that.kinds) : that.kinds != null) return false;
        if (lev != null ? !lev.equals(that.lev) : that.lev != null) return false;
        if (keyname != null ? !keyname.equals(that.keyname) : that.keyname != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (mailcode != null ? !mailcode.equals(that.mailcode) : that.mailcode != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (capacit != null ? !capacit.equals(that.capacit) : that.capacit != null) return false;
        if (receive != null ? !receive.equals(that.receive) : that.receive != null) return false;
        if (pay != null ? !pay.equals(that.pay) : that.pay != null) return false;
        if (server != null ? !server.equals(that.server) : that.server != null) return false;
        if (accoun != null ? !accoun.equals(that.accoun) : that.accoun != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (kinds != null ? kinds.hashCode() : 0);
        result = 31 * result + (lev != null ? lev.hashCode() : 0);
        result = 31 * result + (keyname != null ? keyname.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (mailcode != null ? mailcode.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (capacit != null ? capacit.hashCode() : 0);
        result = 31 * result + (receive != null ? receive.hashCode() : 0);
        result = 31 * result + (pay != null ? pay.hashCode() : 0);
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (accoun != null ? accoun.hashCode() : 0);
        return result;
    }
}
