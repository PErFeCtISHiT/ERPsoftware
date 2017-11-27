package server.Po;

import java.io.Serializable;
import java.sql.Time;

public class goodsPO implements Serializable{
	private String keyno;
	private String keyname;
	private String keymodel;
	private Long num;
	private Long inprice;
	private Long outprice;
	private Long receprice;
	private Long receoutprice;
	private String keybatch;
	private Long batchno;
	private Time dat;
	private String kinds;

    public goodsPO() {

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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getInprice() {
		return inprice;
	}

	public void setInprice(Long inprice) {
		this.inprice = inprice;
	}

	public Long getOutprice() {
		return outprice;
	}

	public void setOutprice(Long outprice) {
		this.outprice = outprice;
	}

	public Long getReceprice() {
		return receprice;
	}

	public void setReceprice(Long receprice) {
		this.receprice = receprice;
	}

	public String getKeybatch() {
		return keybatch;
	}

	public void setKeybatch(String keybatch) {
		this.keybatch = keybatch;
	}

	public Long getBatchno() {
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

	public Long getReceoutprice() {
		return receoutprice;
	}

	public void setReceoutprice(Long receoutprice) {
		this.receoutprice = receoutprice;
	}

	public goodsPO(String keyno, String keyname, String keymodel, Long num, Long inprice, Long outprice, Long receprice, String keybatch, Long batchno, Time dat, String kinds) {

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
