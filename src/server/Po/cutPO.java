package server.Po;
import java.io.Serializable;

public class cutPO implements Serializable{
	private String keyno;
	private Double lev;
	private Double cut;
	private String voucher;
	private String packno;
	private String fromDate;
	private String toDate;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public cutPO() {

    }

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public Double getLev() {
		return lev;
	}

	public void setLev(Double lev) {
		this.lev = lev;
	}

	public Double getCut() {
		return cut;
	}

	public void setCut(Double cut) {
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

	public cutPO(String keyno, Double lev, Double cut, String voucher, String packno) {

		this.keyno = keyno;
		this.lev = lev;
		this.cut = cut;
		this.voucher = voucher;
		this.packno = packno;
	}
}
