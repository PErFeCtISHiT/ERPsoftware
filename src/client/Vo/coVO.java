package client.Vo;

import java.io.Serializable;

public class coVO implements Serializable{
	private String keyname;
	private Long sumall;

	public coVO(String keyname, Long sumall) {
		this.keyname = keyname;
		this.sumall = sumall;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public Long getSumall() {
		return sumall;
	}

	public void setSumall(Long sumall) {
		this.sumall = sumall;
	}
}
