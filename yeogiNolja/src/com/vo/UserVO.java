package com.vo;

public class UserVO {
	private String email;
	private String pwd;
	private String name;

	public UserVO() {
	}

	public UserVO(String email, String pwd, String name) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", pwd=" + pwd + ", name=" + name + "]";
	}

}
