package com.rr.model;

public class Food  {
	private String name;
	private String region;
	private int taste;
	private String imgUrl;

	public Food() {
		this.name = "";
		this.region = "";
		this.taste = 50;
		this.imgUrl="";
	}
	public Food(int taste,String name,String region, String imgUrl) {
		this.name = name;
		this.region = region;
		this.taste = taste;
		this.imgUrl= imgUrl;
	}

  // GETTER AND SETTER
}
