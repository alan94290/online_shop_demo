package com.alan.springboot.onlineshopdemo.model;

public class Register {

	// create register object
	private int id;
	private String email;
	private String name;
	private String account;
	private String password;
	private String cellnum;
	private String address;

	// constructor

	public Register() {
	}

	public Register(String email, String name, String account, String password, String cellnum, String address) {
		this.email = email;
		this.name = name;
		this.account = account;
		this.password = password;
		this.cellnum = cellnum;
		this.address = address;
	}

	// getter and setter

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellnum() {
		return cellnum;
	}

	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
