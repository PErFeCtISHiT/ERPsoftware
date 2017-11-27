package server.Po;

import java.io.Serializable;

public class goodsOutListPO implements Serializable{
	private String keyno;
	private String goodsno;
	private String goodsname;
	private String keymodel;
	private Long num;
	private Long price;
	private Long sumall;

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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getSumall() {
		return sumall;
	}

	public void setSumall(Long sumall) {
		this.sumall = sumall;
	}

	public goodsOutListPO(String keyno, String goodsno, String goodsname, String keymodel, Long num, Long price, Long sumall) {
		this.keyno = keyno;
		this.goodsno = goodsno;
		this.goodsname = goodsname;
		this.keymodel = keymodel;
		this.num = num;
		this.price = price;
		this.sumall = sumall;
	}
}
