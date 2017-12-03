package server.Po;
import java.io.Serializable;

public class coPO implements Serializable{
	private String keyname;
	private Double sumall;
	private String keyno;

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public coPO(String keyname, Double sumall) {
		this.keyname = keyname;
		this.sumall = sumall;
	}

    public coPO() {

    }

    public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public Double getSumall() {
		return sumall;
	}

	public void setSumall(Double sumall) {
		this.sumall = sumall;
	}
}
