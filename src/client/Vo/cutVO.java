package client.Vo;

import java.io.Serializable;

public class cutVO implements Serializable{
	private String keyno;
	private double lev;
	private double cut;
	private String voucher;
	private String packno;

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public double getLev() {
		return lev;
	}

	public void setLev(double lev) {
		this.lev = lev;
	}

	public double getCut() {
		return cut;
	}

	public void setCut(double cut) {
		this.cut = cut;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getPackno() {
		return packno;
	}

	public void setPackno(String packno) {
		this.packno = packno;
	}

	public cutVO(String keyno, double lev, double cut, String voucher, String packno) {

		this.keyno = keyno;
		this.lev = lev;
		this.cut = cut;
		this.voucher = voucher;
		this.packno = packno;
	}
}
