package com.example.demo.security;

public class AuthVO {

	
	/*create table auth_member(
email varchar(200) not null,
auth varchar(100)not null,
foreign key(email) references member(email)); */
	
	private String email,auth;
	
	public AuthVO() {}

	public AuthVO(String email, String auth) {
		super();
		this.email = email;
		this.auth = auth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "AuthVO [email=" + email + ", auth=" + auth + "]";
	}
	

}
