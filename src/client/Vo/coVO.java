package client.Vo;

import java.io.Serializable;

public class coVO implements Serializable {
	private String keyname;
	private Double sumall;
	private String keyno;


	public coVO(String keyname, Double sumall, String keyno) {
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

	public Double getSumall() {
		return sumall;
	}

	public void setSumall(Double sumall) {
		this.sumall = sumall;
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

}