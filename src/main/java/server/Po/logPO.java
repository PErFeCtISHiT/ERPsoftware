package server.Po;

import client.Presentation.NOgenerator.NOgenerator;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class logPO implements Serializable{
	private Date adddate;
	private String keyno;
	private String keyjob;
	private String operatorno;
	private String billno;
	private String opno;
	private String note;
	private String goodsname;
	private String consumer;
	private String base;

	public logPO(){

	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}


    public Date getAdddate() {
		return adddate;
	}

	public void setAdddate(Date adddate) {
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

	public logPO(Date adddate, String keyno, String keyjob, String operatorno, String billno, String opno, String note) {

		this.adddate = adddate;
		this.keyno = keyno;
		this.keyjob = keyjob;
		this.operatorno = operatorno;
		this.billno = billno;
		this.opno = opno;
		this.note = note;
	}
}
