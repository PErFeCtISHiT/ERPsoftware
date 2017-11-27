package client.Vo;

import java.io.Serializable;

public class moneyVO implements Serializable{
	private Long kind;
	private String keyno;
	private String note;
	private String oper;
	private Long ischeck;
	private Long isred;
	private String consumer;
	private String accoun;
	private Long num;
	private Long sumall;

	public Long getKind() {
		return kind;
	}

	public void setKind(Long kind) {
		this.kind = kind;
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Long getIscheck() {
		return ischeck;
	}

	public void setIscheck(Long ischeck) {
		this.ischeck = ischeck;
	}

	public Long getIsred() {
		return isred;
	}

	public void setIsred(Long isred) {
		this.isred = isred;
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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getSumall() {
		return sumall;
	}

	public void setSumall(Long sumall) {
		this.sumall = sumall;
	}

	public moneyVO(Long kind, String keyno, String note, String oper, Long ischeck, Long isred, String consumer, String accoun, Long num, Long sumall) {

		this.kind = kind;
		this.keyno = keyno;
		this.note = note;
		this.oper = oper;
		this.ischeck = ischeck;
		this.isred = isred;
		this.consumer = consumer;
		this.accoun = accoun;
		this.num = num;
		this.sumall = sumall;
	}
}
