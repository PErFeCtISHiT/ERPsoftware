package server.Po;

import java.io.Serializable;

public class buyinPO implements Serializable{
	private Double kind;
	private String keyno;
	private String note;
	private String oper;
	private Double ischeck;
	private Double isred;
	private String provider;
	private String base;
	private String goodsoutlist;
	private Double sumall;


	public buyinPO() {

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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getGoodsoutlist() {
		return goodsoutlist;
	}

	public void setGoodsoutlist(String goodsoutlist) {
		this.goodsoutlist = goodsoutlist;
	}

	public Double getSumall() {
		return sumall;
	}

	public void setSumall(Double sumall) {
		this.sumall = sumall;
	}
}
