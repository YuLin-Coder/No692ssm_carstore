package com.entity;

import com.util.VeDate;

public class Instorage {
	private String instorageid = "I" + VeDate.getStringId();
	private String goodsid;
	private String num;
	private String adminid;
	private String addtime;
	private String goodsname;
	private String username;

	public String getInstorageid() {
		return instorageid;
	}

	public void setInstorageid(String instorageid) {
		this.instorageid = instorageid;
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

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Instorage [instorageid=" + this.instorageid + ", goodsid=" + this.goodsid + ", num=" + this.num + ", adminid=" + this.adminid
				+ ", addtime=" + this.addtime + ", goodsname=" + this.goodsname + ", username=" + this.username + "]";
	}

}

/**
 * 
 */
