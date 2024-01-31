package com.example.demo.security;

import java.util.List;

public class MemberVO {
	
	/*member table구성
create table member(
email varchar(200) not null,
pwd varchar(256) not null,
nick_name varchar(100),
reg_at datetime default now(),
last_login datetime,
primary key(email));*/
	
	private String email, pwd,nickName,regAt,lastLogin;
	private List<AuthVO> authList;
	
	public MemberVO() {}

	public MemberVO(String email, String pwd, String nickName, String regAt, String lastLogin, List<AuthVO> authList) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.authList = authList;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<AuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}

	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pwd=" + pwd + ", nickName=" + nickName + ", regAt=" + regAt
				+ ", lastLogin=" + lastLogin + ", authList=" + authList + "]";
	}
}
