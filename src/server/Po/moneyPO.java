package server.Po;

import java.io.Serializable;

public class moneyPO implements Serializable{
	private Double kind;
	private String keyno;
	private String consumertype;
	private String oper;
	private Double ischeck;
	private Double isred;
	private Double isDraft;
	private String consumer;
	private String accoun;
	private Double sumall;
	private String moneyList;

    public moneyPO() {

    }

	public String getConsumertype() {
		return consumertype;
	}

	public void setConsumertype(String consumertype) {
		this.consumertype = consumertype;
	}

	public Double getKind() {
		return kind;
	}

	public void setKind(Double kind) {
		this.kind = kind;
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getMoneyList() {
		return moneyList;
	}

	public void setMoneyList(String moneyList) {
		this.moneyList = moneyList;
	}

	public Double getIscheck() {
		return ischeck;
	}

	public void setIscheck(Double ischeck) {
		this.ischeck = ischeck;
	}

	public Double getIsred() {
		return isred;
	}

	public void setIsred(Double isred) {
		this.isred = isred;
	}

    public Double getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Double isDraft) {
        this.isDraft = isDraft;
    }


	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getAccoun() {
		return accoun;
	}

	public void setAccoun(String accoun) {
		this.accoun = accoun;
	}


	public Double getSumall() {
		return sumall;
	}

	public void setSumall(Double sumall) {
		this.sumall = sumall;
	}

	public moneyPO(Double kind, String keyno, String oper, Double ischeck, Double isred, Double isDraft, String consumer, String accoun, Double sumall) {

		this.kind = kind;
		this.keyno = keyno;
		this.oper = oper;
		this.ischeck = ischeck;
		this.isred = isred;
		this.isDraft = isDraft;
		this.consumer = consumer;
		this.accoun = accoun;
		this.sumall = sumall;
	}
}
