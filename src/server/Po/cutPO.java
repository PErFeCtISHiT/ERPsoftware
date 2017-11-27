package server.Po;
import java.io.Serializable;

public class cutPO implements Serializable{
	private String keyno;
	private Long lev;
	private Long cut;
	private String voucher;
	private String packno;

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public Long getLev() {
		return lev;
	}

	public void setLev(Long lev) {
		this.lev = lev;
	}

	public Long getCut() {
		return cut;
	}

	public void setCut(Long cut) {
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

	public cutPO(String keyno, Long lev, Long cut, String voucher, String packno) {

		this.keyno = keyno;
		this.lev = lev;
		this.cut = cut;
		this.voucher = voucher;
		this.packno = packno;
	}
}
