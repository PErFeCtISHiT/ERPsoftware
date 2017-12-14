package server.Po;

import java.io.Serializable;

public class goodsOutListPO implements Serializable{
	private String keyno;
	private String goodsno;
	private String goodsname;
	private String keymodel;
	private Double num;
	private Double price;
	private Double sumall;

    public goodsOutListPO() {

    }

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

	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSumall() {
		return sumall;
	}

	public void setSumall(Double sumall) {
		this.sumall = sumall;
	}

	public goodsOutListPO(String keyno, String goodsno, String goodsname, String keymodel, Double num, Double price, Double sumall) {

		this.keyno = keyno;
		this.goodsno = goodsno;
		this.goodsname = goodsname;
		this.keymodel = keymodel;
		this.num = num;
		this.price = price;
		this.sumall = sumall;
	}
}
