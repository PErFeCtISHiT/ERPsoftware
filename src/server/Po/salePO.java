package server.Po;

import java.io.Serializable;

public class salePO implements Serializable{
	private String keyno;
	private Double kind;
	private Double lev;
	private String accoun;
	private String base;
	private String goodsinlist;
	private String goodsoutlist;
	private Double presum;
	private Double cut;
	private Double voucher;
	private Double sumall;
	private String dateandtime;
	private String consumer;
	private String operater;

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getOperater() {
		return operater;
	}

	public void setOperater(String operater) {
		this.operater = operater;
	}

	public salePO() {

    }

    public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public Double getKind() {
		return kind;
	}

	public void setKind(Double kind) {
		this.kind = kind;
	}

	public Double getLev() {
		return lev;
	}

	public void setLev(Double lev) {
		this.lev = lev;
	}

	public String getAccoun() {
		return accoun;
	}

	public void setAccoun(String accoun) {
		this.accoun = accoun;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getGoodsinlist() {
		return goodsinlist;
	}

	public void setGoodsinlist(String goodsinlist) {
		this.goodsinlist = goodsinlist;
	}

	public String getGoodsoutlist() {
		return goodsoutlist;
	}

	public void setGoodsoutlist(String goodsoutlist) {
		this.goodsoutlist = goodsoutlist;
	}

	public Double getPresum() {
		return presum;
	}

	public void setPresum(Double presum) {
		this.presum = presum;
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

	public Double getSumall() {
		return sumall;
	}

	public void setSumall(Double sumall) {
		this.sumall = sumall;
	}

	public String getDateandtime() {
		return dateandtime;
	}

	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}

	public salePO(String keyno, Double kind, Double lev, String accoun, String base, String goodsinlist, String goodsoutlist, Double presum, Double cut, Double voucher, Double sumall, String dateandtime) {

		this.keyno = keyno;
		this.kind = kind;
		this.lev = lev;
		this.accoun = accoun;
		this.base = base;
		this.goodsinlist = goodsinlist;
		this.goodsoutlist = goodsoutlist;
		this.presum = presum;
		this.cut = cut;
		this.voucher = voucher;
		this.sumall = sumall;
		this.dateandtime = dateandtime;
	}
}
