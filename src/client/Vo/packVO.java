package client.Vo;

import java.io.Serializable;

public class packVO implements Serializable{
	private String keyno;
	private String goodsno;
	private String goodsname;
	private Long price;

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public packVO(String keyno, String goodsno, String goodsname, Long price) {

		this.keyno = keyno;
		this.goodsno = goodsno;
		this.goodsname = goodsname;
		this.price = price;
	}
}
