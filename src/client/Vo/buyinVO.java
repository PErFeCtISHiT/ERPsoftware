package client.Vo;

import java.io.Serializable;

public class buyinVO implements Serializable{
	private double kind; //收款单or付款单
	private String keyno; //单据ID
	private String note;  //备注
	private String oper;  //操作员
	private double ischeck;  //是否审批
	private double isred;   //是否红冲
	private String provider;  //供应商
	private String base;   //仓库
	private String goodsoutlist;  //出库商品列表
	private double sumall;   //金额

	public buyinVO(double kind, String keyno, String note, String oper, double ischeck, double isred, String provider, String base, String goodsoutlist, double sumall) {
		this.kind = kind;
		this.keyno = keyno;
		this.note = note;
		this.oper = oper;
		this.ischeck = ischeck;
		this.isred = isred;
		this.provider = provider;
		this.base = base;
		this.goodsoutlist = goodsoutlist;
		this.sumall = sumall;
	}

	public double getKind() {
		return kind;
	}

	public void setKind(double kind) {
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

	public double getIscheck() {
		return ischeck;
	}

	public void setIscheck(double ischeck) {
		this.ischeck = ischeck;
	}

	public double getIsred() {
		return isred;
	}

	public void setIsred(double isred) {
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

	public double getSumall() {
		return sumall;
	}

	public void setSumall(double sumall) {
		this.sumall = sumall;
	}
}
