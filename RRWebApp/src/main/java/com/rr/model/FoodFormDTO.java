package com.rr.model;

public class FoodFormDTO  {

	private String name;
	private String region;
	private int taste;
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public FoodFormDTO() {
		this.name = "";
		this.region = "";
		this.taste = 50;
		this.imgUrl="";
	}
	public FoodFormDTO(String name, String region, int taste, String imgUrl) {
		this.name = name;
		this.region = region;
		this.taste = taste;
		this.imgUrl=imgUrl;
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
}

    // GETTER AND SETTER

