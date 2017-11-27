package server.Po;

import java.io.Serializable;
import java.sql.Time;

public class logPO implements Serializable{
	private Time adddate;
	private String keyno;
	private String keyjob;
	private String operatorno;
	private String billno;
	private String opno;
	private String note;

	public Time getAdddate() {
		return adddate;
	}

	public void setAdddate(Time adddate) {
		this.adddate = adddate;
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public String getKeyjob() {
		return keyjob;
	}

	public void setKeyjob(String keyjob) {
		this.keyjob = keyjob;
	}

	public String getOperatorno() {
		return operatorno;
	}

	public void setOperatorno(String operatorno) {
		this.operatorno = operatorno;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getOpno() {
		return opno;
	}

	public void setOpno(String opno) {
		this.opno = opno;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public logPO(Time adddate, String keyno, String keyjob, String operatorno, String billno, String opno, String note) {

		this.adddate = adddate;
		this.keyno = keyno;
		this.keyjob = keyjob;
		this.operatorno = operatorno;
		this.billno = billno;
		this.opno = opno;
		this.note = note;
	}
}
