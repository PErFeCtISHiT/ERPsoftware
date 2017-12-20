package server.Po;

import java.io.Serializable;
import java.sql.Date;

public class goodsPO implements Serializable{
	private String keyno;
	private String keyname;
	private String keymodel;
	private Double num;
	private Double inprice;
	private Double outprice;
	private Double receprice;
	private Double receoutprice;
	private String keybatch;
	private String batchno;
	private Date dat;
	private String kinds;
	private Double warningnum;

	public Double getWarningnum() {
		return warningnum;
	}

	public void setWarningnum(Double warningnum) {
		this.warningnum = warningnum;
	}

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

	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	public Double getInprice() {
		return inprice;
	}

	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}

	public Double getOutprice() {
		return outprice;
	}

	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}

	public Double getReceprice() {
		return receprice;
	}

	public void setReceprice(Double receprice) {
		this.receprice = receprice;
	}

	public Double getReceoutprice() {
		return receoutprice;
	}

	public void setReceoutprice(Double receoutprice) {
		this.receoutprice = receoutprice;
	}

	public String getKeybatch() {
		return keybatch;
	}

	public void setKeybatch(String keybatch) {
		this.keybatch = keybatch;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Date getDat() {
		return dat;
	}

	public void setDat(Date dat) {
		this.dat = dat;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public goodsPO(String keyno, String keyname, String keymodel, Double num, Double inprice, Double outprice, Double receprice, Double receoutprice, String keybatch, String batchno, Date dat, String kinds) {

		this.keyno = keyno;
		this.keyname = keyname;
		this.keymodel = keymodel;
		this.num = num;
		this.inprice = inprice;
		this.outprice = outprice;
		this.receprice = receprice;
		this.receoutprice = receoutprice;
		this.keybatch = keybatch;
		this.batchno = batchno;
		this.dat = dat;
		this.kinds = kinds;
	}
}
