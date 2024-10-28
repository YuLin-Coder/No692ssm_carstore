package com.entity;

import com.util.VeDate;

public class Details {
	private String detailsid = "D" + VeDate.getStringId();
	private String ordercode;
	private String goodsid;
	private String price;
	private String num;
	private String goodsname;

	public String getDetailsid() {
		return detailsid;
	}

	public void setDetailsid(String detailsid) {
		this.detailsid = detailsid;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	@Override
	public String toString() {
		return "Details [detailsid=" + this.detailsid + ", ordercode=" + this.ordercode + ", goodsid=" + this.goodsid + ", price=" + this.price
				+ ", num=" + this.num + ", goodsname=" + this.goodsname + "]";
	}

}

/**
 * 
 */
