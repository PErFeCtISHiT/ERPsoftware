package server.Po;

import java.io.Serializable;

public class salePO implements Serializable{
	private String keyno;
	private Long kind;
	private Long lev;
	private String accoun;
	private String base;
	private String goodsinlist;
	private String goodsoutlist;
	private Long presum;
	private Long cut;
	private Long voucher;
	private Long sumall;
	private String dateandtime;

	public String getDateandtime() {
		return dateandtime;
	}

	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public Long getKind() {
		return kind;
	}

	public void setKind(Long kind) {
		this.kind = kind;
	}

	public Long getLev() {
		return lev;
	}

	public void setLev(Long lev) {
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

	public Long getPresum() {
		return presum;
	}

	public void setPresum(Long presum) {
		this.presum = presum;
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

	public Long getSumall() {
		return sumall;
	}

	public void setSumall(Long sumall) {
		this.sumall = sumall;
	}

	public salePO(String keyno, Long kind, Long lev, String accoun, String base, String goodsinlist, String goodsoutlist, Long presum, Long cut, Long voucher, Long sumall) {

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
	}
}
