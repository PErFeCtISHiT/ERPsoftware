package server.Po;

import java.io.Serializable;

public class consumerPO implements Serializable{
	private String keyno;
	private Double kinds;
	private Double lev;
	private String keyname;
	private String tel;
	private String mailcode;
	private String email;
	private Double capacit;
	private Double receive;
	private Double pay;
	private String server;
	private String accoun;

	public consumerPO(String keyno, Double kinds, Double lev, String keyname, String tel, String mailcode, String email, Double capacit, Double receive, Double pay, String server, String accoun) {
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

	public consumerPO() {

    }

    public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
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

	public void setKinds(Double kinds) {
		this.kinds = kinds;
	}

	public void setLev(Double lev) {
		this.lev = lev;
	}

	public void setCapacit(Double capacit) {
		this.capacit = capacit;
	}

	public void setReceive(Double receive) {
		this.receive = receive;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}
}
