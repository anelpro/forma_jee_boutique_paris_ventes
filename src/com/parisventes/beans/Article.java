package com.parisventes.beans;

public class Article {
	String title ="";
	String linkImg ="";
	String description = "";
	Float price = 0.0f;
	
	
	
	
	public Article(String title, String linkImg, String description, Float price) {
		super();
		this.title = title;
		this.linkImg = linkImg;
		this.description = description;
		this.price = price;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
	
}
