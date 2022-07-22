package com.example.demo.empentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class user {
	
	@Id
	private String uname;
	private String upassword;
	
	
	
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "user [ uname=" + uname + ", password=" + upassword + "]";
	}
	
	
	public String getName() {
		return uname;
	}
	public void setName(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return upassword;
	}
	public void setPassword(String password) {
		this.upassword = password;
	}
	
	

}
