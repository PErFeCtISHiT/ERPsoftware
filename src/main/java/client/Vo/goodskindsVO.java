package client.Vo;

import java.io.Serializable;

public class goodskindsVO implements Serializable{
	private String keyno;
	private String keyname;
	private String father;
	private String son;

	public goodskindsVO() {

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

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getSon() {
		return son;
	}

	public void setSon(String son) {
		this.son = son;
	}

	public goodskindsVO(String keyno, String keyname, String father, String son) {

		this.keyno = keyno;
		this.keyname = keyname;
		this.father = father;
		this.son = son;
	}
}
