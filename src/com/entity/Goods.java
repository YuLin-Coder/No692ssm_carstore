package com.entity;

import com.util.VeDate;

public class Goods {
	private String goodsid = "G" + VeDate.getStringId();
	private String cateid;
	private String brand;
	private String type;
	private String size;
	private String seating;
	private String image;
	private String color;
	private String supplierid;
	private String racksid;
	private String price;
	private String storage;
	private String sellnum;
	private String hits;
	private String recommend;
	private String special;
	private String addtime;
	private String catename;
	private String supname;
	private String racksno;
	private String goodsname;
	private String contents;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSeating() {
		return this.seating;
	}

	public void setSeating(String seating) {
		this.seating = seating;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getRacksid() {
		return this.racksid;
	}

	public void setRacksid(String racksid) {
		this.racksid = racksid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getSellnum() {
		return this.sellnum;
	}

	public void setSellnum(String sellnum) {
		this.sellnum = sellnum;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getSupname() {
		return this.supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

	public String getRacksno() {
		return this.racksno;
	}

	public void setRacksno(String racksno) {
		this.racksno = racksno;
	}

	@Override
	public String toString() {
		return "Goods [goodsid=" + this.goodsid + ", cateid=" + this.cateid + ", brand=" + this.brand + ", type=" + this.type + ", size=" + this.size
				+ ", seating=" + this.seating + ", image=" + this.image + ", color=" + this.color + ", supplierid=" + this.supplierid + ", racksid="
				+ this.racksid + ", price=" + this.price + ", storage=" + this.storage + ", sellnum=" + this.sellnum + ", hits=" + this.hits
				+ ", recommend=" + this.recommend + ", special=" + this.special + ", addtime=" + this.addtime + ", catename=" + this.catename
				+ ", supname=" + this.supname + ", racksno=" + this.racksno + "]";
	}

}

/**
 * 
 */
