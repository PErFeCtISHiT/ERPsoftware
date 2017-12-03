package client.Vo;

import java.io.Serializable;

public class consumerVO implements Serializable{
	private String keyno;
	private Long kinds;
	private Long lev;
	private String keyname;
	private String tel;
	private String mailcode;
	private String email;
	private Long capacit;
	private Long receive;
	private Long pay;
	private String server;
	private String accoun;

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public Long getKinds() {
		return kinds;
	}

	public void setKinds(Long kinds) {
		this.kinds = kinds;
	}

	public Long getLev() {
		return lev;
	}

	public void setLev(Long lev) {
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

	public String getMailcode() {
		return mailcode;
	}

	public void setMailcode(String mailcode) {
		this.mailcode = mailcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCapacit() {
		return capacit;
	}

	public void setCapacit(Long capacit) {
		this.capacit = capacit;
	}

	public Long getReceive() {
		return receive;
	}

	public void setReceive(Long receive) {
		this.receive = receive;
	}

	public Long getPay() {
		return pay;
	}

	public void setPay(Long pay) {
		this.pay = pay;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getAccoun() {
		return accoun;
	}

	public void setAccoun(String accoun) {
		this.accoun = accoun;
	}

	public consumerVO(String keyno, Long kinds, Long lev, String keyname, String tel, String mailcode, String email, Long capacit, Long receive, Long pay, String server, String accoun) {
		this.keyno = keyno;
		this.kinds = kinds;
		this.lev = lev;
		this.keyname = keyname;

		this.tel = tel;
		this.mailcode = mailcode;
		this.email = email;
		this.capacit = capacit;
		this.receive = receive;
		this.pay = pay;
		this.server = server;
		this.accoun = accoun;
	}

	public consumerVO(){}
}
