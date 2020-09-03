package com.vo;

public class UserVO {
	private String email;
	private String pwd;
	private String name;
	private String admin_yn;

	public UserVO() {
	}

	public UserVO(String email, String pwd, String name) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
	}

	public UserVO(String email, String pwd, String name, String admin_yn) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.admin_yn = admin_yn;
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

	public String getadmin_yn() {
		return admin_yn;
	}

	public void setadmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}

	@Override
	public String toString() {
		return "UserVO [email=" + email + ", pwd=" + pwd + ", name=" + name + ", admin_yn=" + admin_yn + "]";
	}



}
