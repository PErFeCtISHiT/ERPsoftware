package client.Vo;

import java.io.Serializable;

public class selloutVO implements Serializable{
	private Long kind;
	private String keyno;
	private String note;
	private String oper;
	private Long ischeck;
	private Long isred;
	private String consumer;
	private String server;
	private String base;
	private String goodsoutlist;
	private Long sumall;
	private Long cut;
	private Long voucher;
	private Long finalsum;

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

	public Long getSumall() {
		return sumall;
	}

	public void setSumall(Long sumall) {
		this.sumall = sumall;
	}

	public Long getCut() {
		return cut;
	}

	public void setCut(Long cut) {
		this.cut = cut;
	}

	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

	public Long getFinalsum() {
		return finalsum;
	}

	public void setFinalsum(Long finalsum) {
		this.finalsum = finalsum;
	}

	public selloutVO(Long kind, String keyno, String note, String oper, Long ischeck, Long isred, String consumer, String server, String base, String goodsoutlist, Long sumall, Long cut, Long voucher, Long finalsum) {

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
