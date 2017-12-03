package client.Vo;

import java.io.Serializable;

public class consumerVO implements Serializable{
	private String keyno;  //客户编号
	private Double kinds;  //分类
	private Double lev;    //级别
	private String keyname; //姓名
	private String tel;  //电话
	private String mailcode;  //邮编
	private String email;   //电子邮箱
	private Double capacit;    //应收额度
	private Double receive;    //应收
	private Double pay;     //应付
	private String server;   //业务员
	private String accoun;    //银行账户

    public consumerVO() {

    }

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public Double getKinds() {
		return kinds;
	}

	public void setKinds(Double kinds) {
		this.kinds = kinds;
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

	public Double getCapacit() {
		return capacit;
	}

	public void setCapacit(Double capacit) {
		this.capacit = capacit;
	}

	public Double getReceive() {
		return receive;
	}

	public void setReceive(Double receive) {
		this.receive = receive;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
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

	public consumerVO(String keyno, Double kinds, Double lev, String keyname, String tel, String mailcode, String email, Double capacit, Double receive, Double pay, String server, String accoun) {

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
}
