package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.util.VeDate;

public class Supplier {
	private String supplierid = "S" + VeDate.getStringId();
	private String supname;
	private String contents;
	private List<Goods> goodsList = new ArrayList<Goods>();

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getSupname() {
		return this.supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Supplier [supplierid=" + this.supplierid + ", supname=" + this.supname + ", contents=" + this.contents + "]";
	}

}

/**
 * 
 */
