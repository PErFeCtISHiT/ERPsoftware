package server.Po;

import java.io.Serializable;

public class buyinPO implements Serializable{
	private Long kind;
	private String keyno;
	private String note;
	private String oper;
	private Long ischeck;
	private Long isred;
	private String provider;
	private String base;
	private String goodsoutlist;
	private Long sumall;

    public buyinPO(Long kind, String keyno, String note, String oper, Long ischeck, Long isred, String consumer, String server, String base, String goodsoutlist, Long sumall, Long cut, Long voucher, Long finalsum) {
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

	public buyinPO() {

	}

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

	public Long getSumall() {
		return sumall;
	}

	public void setSumall(Long sumall) {
		this.sumall = sumall;
	}
}
