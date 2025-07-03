package com.titan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column(unique = true)
	private String phnumber;
	private String password;
	private String comfirmpass;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhnumber() {
		return phnumber;
	}
	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getComfirmpass() {
		return comfirmpass;
	}
	public void setComfirmpass(String comfirmpass) {
		this.comfirmpass = comfirmpass;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phnumber=" + phnumber + ", password=" + password
				+ ", comfirmpass=" + comfirmpass + "]";
	}
	public User(long id, String name, String phnumber, String password, String comfirmpass) {
		super();
		this.id = id;
		this.name = name;
		this.phnumber = phnumber;
		this.password = password;
		this.comfirmpass = comfirmpass;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
