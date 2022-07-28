package com.example.demo.empentity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class User {
	@Id
	private int id;

	public int getUid() {
		return id;
	}
	public void setUid(int uid) {
		this.id = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String username;
	private String password;

	
	
	

}
