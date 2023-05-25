package com.rr.model;

public class Food  {
	private int id;
	private String name;
	private String region;
	private int taste;
	private int cost;
	private String imgUrl;

	public Food() {
		this.id = 0;
		this.name = "";
		this.region = "";
		this.taste = 50;
		this.cost = 4;
		this.imgUrl="";
	}
	public Food(int id, String name,String region, int taste, int cost, String imgUrl) {
		this.id = id;
		this.name = name;
		this.region = region;
		this.taste = taste;
		this.cost = cost;
		this.imgUrl= imgUrl;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getTaste() {
		return taste;
	}
	public void setTaste(int taste) {
		this.taste = taste;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

  // GETTER AND SETTER
}
