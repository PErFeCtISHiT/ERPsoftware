package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "MONEY", schema = "PIS")
public class MoneyEntity {
    private Double kind;
    private String keyno;
    private String oper;
    private Double ischeck;
    private Double isred;
    private String consumer;
    private String accoun;
    private String moneyList;
    private Double sumall;
    private String consumertype;

    private Double isDraft;
    @Basic
    @Column(name = "ISDRAFT", nullable = true, precision = 0)
    public Double getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Double isDraft) {
        this.isDraft = isDraft;
    }

    @Basic
    @Column(name = "KIND", nullable = true, precision = 0)
    public Double getKind() {
        return kind;
    }

    public void setKind(Double kind) {
        this.kind = kind;
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
    @Column(name = "consumertype", nullable = true, length = 2000)
    public String getConsumertype() {
        return consumertype;
    }

    public void setConsumertype(String consumertype) {
        this.consumertype = consumertype;
    }

    @Basic
    @Column(name = "OPER", nullable = true, length = 20)
    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Basic
    @Column(name = "ISCHECK", nullable = true, precision = 0)
    public Double getIscheck() {
        return ischeck;
    }

    public void setIscheck(Double ischeck) {
        this.ischeck = ischeck;
    }

    @Basic
    @Column(name = "ISRED", nullable = true, precision = 0)
    public Double getIsred() {
        return isred;
    }

    public void setIsred(Double isred) {
        this.isred = isred;
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
    @Column(name = "ACCOUN", nullable = true, length = 20)
    public String getAccoun() {
        return accoun;
    }

    public void setAccoun(String accoun) {
        this.accoun = accoun;
    }

    @Basic
    @Column(name = "moneylist", nullable = true, length = 2000)
    public String getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(String moneyList) {
        this.moneyList = moneyList;
    }

    @Basic
    @Column(name = "SUMALL", nullable = true, precision = 0)
    public Double getSumall() {
        return sumall;
    }

    public void setSumall(Double sumall) {
        this.sumall = sumall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoneyEntity that = (MoneyEntity) o;

        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (consumertype != null ? !consumertype.equals(that.consumertype) : that.consumertype != null) return false;
        if (oper != null ? !oper.equals(that.oper) : that.oper != null) return false;
        if (ischeck != null ? !ischeck.equals(that.ischeck) : that.ischeck != null) return false;
        if (isred != null ? !isred.equals(that.isred) : that.isred != null) return false;
        if (consumer != null ? !consumer.equals(that.consumer) : that.consumer != null) return false;
        if (accoun != null ? !accoun.equals(that.accoun) : that.accoun != null) return false;
        if (moneyList != null ? !moneyList.equals(that.moneyList) : that.moneyList != null) return false;
        return sumall != null ? sumall.equals(that.sumall) : that.sumall == null;
    }

    @Override
    public int hashCode() {
        int result = kind != null ? kind.hashCode() : 0;
        result = 31 * result + (keyno != null ? keyno.hashCode() : 0);
        result = 31 * result + (consumertype != null ? consumertype.hashCode() : 0);
        result = 31 * result + (oper != null ? oper.hashCode() : 0);
        result = 31 * result + (ischeck != null ? ischeck.hashCode() : 0);
        result = 31 * result + (isred != null ? isred.hashCode() : 0);
        result = 31 * result + (consumer != null ? consumer.hashCode() : 0);
        result = 31 * result + (accoun != null ? accoun.hashCode() : 0);
        result = 31 * result + (moneyList != null ? moneyList.hashCode() : 0);
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        return result;
    }
}
