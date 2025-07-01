package com.titan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Titan {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private  String name;
	private String dis;
	private String pprice;
	private String photo;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Titan [id=" + id + ", name=" + name + ", dis=" + dis + ", pprice=" + pprice + ", photo=" + photo + "]";
	}
	public Titan(long id, String name, String dis, String pprice, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.dis = dis;
		this.pprice = pprice;
		this.photo = photo;
	}
	public Titan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
