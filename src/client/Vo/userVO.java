package client.Vo;

import java.io.Serializable;

public class userVO implements Serializable{
	private String keyjob;
	private String keyno;
	private Double lev;
	private String keyname;
	private String tel;
	private String address;
	private String postcode;
	private String email;
	private Double keyyear;
	private String passwor;

	public String getKeyjob() {
		return keyjob;
	}

	public void setKeyjob(String keyjob) {
		this.keyjob = keyjob;
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

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getKeyyear() {
		return keyyear;
	}

	public void setKeyyear(Double keyyear) {
		this.keyyear = keyyear;
	}

	public String getPasswor() {
		return passwor;
	}

	public void setPasswor(String passwor) {
		this.passwor = passwor;
	}

	public userVO(String keyjob, String keyno, Double lev, String keyname, String tel, String address, String postcode, String email, Double keyyear, String passwor) {

		this.keyjob = keyjob;
		this.keyno = keyno;
		this.lev = lev;
		this.keyname = keyname;
		this.tel = tel;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.keyyear = keyyear;
		this.passwor = passwor;
	}
}
