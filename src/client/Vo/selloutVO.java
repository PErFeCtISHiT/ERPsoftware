package client.Vo;

import java.io.Serializable;

public class selloutVO implements Serializable{
	private Double kind;
	private String keyno;
	private String note;
	private String oper;
	private Double ischeck;
	private Double isred;
	private String consumer;
	private String server;
	private String base;
	private String goodsoutlist;
	private Double sumall;
	private Double cut;
	private Double voucher;
	private Double finalsum;
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

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
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

	public Double getCut() {
		return cut;
	}

	public void setCut(Double cut) {
		this.cut = cut;
	}

	public Double getVoucher() {
		return voucher;
	}

	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}

	public Double getFinalsum() {
		return finalsum;
	}

	public void setFinalsum(Double finalsum) {
		this.finalsum = finalsum;
	}

	public selloutVO(Double kind, String keyno, String note, String oper, Double ischeck, Double isred, String consumer, String server, String base, String goodsoutlist, Double sumall, Double cut, Double voucher, Double finalsum) {

		this.kind = kind;
		this.keyno = keyno;
		this.note = note;
		this.oper = oper;
		this.ischeck = ischeck;
		this.isred = isred;
		this.consumer = consumer;
		this.server = server;
		this.base = base;
		this.goodsoutlist = goodsoutlist;
		this.sumall = sumall;
		this.cut = cut;
		this.voucher = voucher;
		this.finalsum = finalsum;
	}
}
