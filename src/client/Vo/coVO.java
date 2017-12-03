package client.Vo;

import java.io.Serializable;

public class coVO implements Serializable {
	private String keyname;
	private double sumall;
	private String keyno;


	public coVO(String keyname, double sumall, String keyno) {
		this.keyname = keyname;
		this.sumall = sumall;
		this.keyno = keyno;
	}

	public coVO() {

	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public double getSumall() {
		return sumall;
	}

	public void setSumall(double sumall) {
		this.sumall = sumall;
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

}