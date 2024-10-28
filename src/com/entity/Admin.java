package com.entity;

import com.util.VeDate;

public class Admin {
	private String adminid = "A" + VeDate.getStringId();
	private String username;
	private String password;
	private String realname;
	private String contact;
	private String addtime;
	private String role;

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + this.adminid + ", username=" + this.username + ", password=" + this.password + ", realname=" + this.realname
				+ ", contact=" + this.contact + ", addtime=" + this.addtime + ", role=" + this.role + "]";
	}

}

/**
 * 
 */
