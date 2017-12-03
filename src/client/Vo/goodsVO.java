package client.Vo;

import java.io.Serializable;
import java.sql.Time;

public class goodsVO implements Serializable{
	private String keyno;
	private String keyname;
	private String keymodel;
	private double num;
	private double inprice;
	private double outprice;
	private double receprice;
	private double receoutprice;
	private String keybatch;
	private double batchno;
	private Time dat;
	private String kinds;

    public goodsVO() {

    }

    public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getKeymodel() {
		return keymodel;
	}

	public void setKeymodel(String keymodel) {
		this.keymodel = keymodel;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public double getInprice() {
		return inprice;
	}

	public void setInprice(double inprice) {
		this.inprice = inprice;
	}

	public double getOutprice() {
		return outprice;
	}

	public void setOutprice(double outprice) {
		this.outprice = outprice;
	}

	public double getReceprice() {
		return receprice;
	}

	public void setReceprice(double receprice) {
		this.receprice = receprice;
	}

	public String getKeybatch() {
		return keybatch;
	}

	public void setKeybatch(String keybatch) {
		this.keybatch = keybatch;
	}

	public double getBatchno() {
		return batchno;
	}

	public void setBatchno(Long batchno) {
		this.batchno = batchno;
	}

	public Time getDat() {
		return dat;
	}

	public void setDat(Time dat) {
		this.dat = dat;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public double getReceoutprice() {
		return receoutprice;
	}

	public void setReceoutprice(double receoutprice) {
		this.receoutprice = receoutprice;
	}

	public goodsVO(String keyno, String keyname, String keymodel, Long num, Long inprice, Long outprice, Long receprice, String keybatch, Long batchno, Time dat, String kinds) {

		this.keyno = keyno;
		this.keyname = keyname;
		this.keymodel = keymodel;
		this.num = num;
		this.inprice = inprice;
		this.outprice = outprice;
		this.receprice = receprice;
		this.keybatch = keybatch;
		this.batchno = batchno;
		this.dat = dat;
		this.kinds = kinds;
	}
}
