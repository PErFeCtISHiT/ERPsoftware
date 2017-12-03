package client.Vo;

import java.io.Serializable;

public class goodsOutListVO implements Serializable{
	private String keyno;
	private String goodsno;
	private String goodsname;
	private String keymodel;
	private double num;
	private double price;
	private double sumall;

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public String getGoodsno() {
		return goodsno;
	}

	public void setGoodsno(String goodsno) {
		this.goodsno = goodsno;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getKeymodel() {
		return keymodel;
	}

	public void setKeymodel(String keymodel) {
		this.keymodel = keymodel;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSumall() {
		return sumall;
	}

	public void setSumall(double sumall) {
		this.sumall = sumall;
	}

	public goodsOutListVO(String keyno, String goodsno, String goodsname, String keymodel, double num, double price, double sumall) {
		this.keyno = keyno;
		this.goodsno = goodsno;
		this.goodsname = goodsname;
		this.keymodel = keymodel;
		this.num = num;
		this.price = price;
		this.sumall = sumall;
	}
}
