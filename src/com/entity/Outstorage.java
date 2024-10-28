package com.entity;

import com.util.VeDate;

public class Outstorage {
	private String outstorageid = "O" + VeDate.getStringId();
	private String ordersid;
	private String goodsid;
	private String num;
	private String adminid;
	private String addtime;
	private String ordercode;
	private String goodsname;

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	private String username;

	public String getOutstorageid() {
		return outstorageid;
	}

	public void setOutstorageid(String outstorageid) {
		this.outstorageid = outstorageid;
	}

	public String getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Outstorage [outstorageid=" + this.outstorageid + ", ordersid=" + this.ordersid + ", goodsid=" + this.goodsid + ", num=" + this.num
				+ ", adminid=" + this.adminid + ", addtime=" + this.addtime + ", ordercode=" + this.ordercode + ", goodsname=" + this.goodsname
				+ ", username=" + this.username + "]";
	}

}

/**
 * 
 */
