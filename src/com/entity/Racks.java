package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.util.VeDate;

public class Racks {
	private String racksid = "R" + VeDate.getStringId();
	private String racksno;
	private String contents;
	private List<Goods> goodsList = new ArrayList<Goods>();

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public String getRacksid() {
		return racksid;
	}

	public void setRacksid(String racksid) {
		this.racksid = racksid;
	}

	public String getRacksno() {
		return this.racksno;
	}

	public void setRacksno(String racksno) {
		this.racksno = racksno;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Racks [racksid=" + this.racksid + ", racksno=" + this.racksno + ", contents=" + this.contents + "]";
	}

}

/**
 * 
 */
