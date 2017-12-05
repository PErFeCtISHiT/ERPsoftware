package client.Vo;

import java.io.Serializable;

public class buyinVO implements Serializable{
	private Double kind; //收款单or付款单
	private String keyno; //单据ID
	private String note;  //备注
	private String oper;  //操作员
	private Double ischeck;  //是否审批
	private Double isred;   //是否红冲
	private String provider;  //供应商
	private String base;   //仓库
	private String goodsoutlist;  //出库商品列表
	private Double sumall;   //金额
	private Double isDraft;

	public Double getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(Double isDraft) {
		this.isDraft = isDraft;
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

	public buyinVO(Double kind, String keyno, String note, String oper, Double ischeck, Double isred, String provider, String base, String goodsoutlist, Double sumall) {

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
}
