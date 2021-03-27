package com.myclass.dto;

import java.sql.Date;

public class CourseDto {
	private int id;
	private String title;
	private String image;
	private int lecture;
	private int hour;
	private int view;
	private float price;
	private int discount;
	private float promotionPrice;
	private String desciption;
	private String content;
	private int categoryId;
	private Date lastUpdate;
	private String cateName;
	
	public CourseDto() {}
	
	public CourseDto(int id, String title, String image, int lecture, int hour, int view, float price, int discount,
			float promotionPrice, String desciption, String content, int categoryId, Date lastUpdate , String cateName) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.lecture = lecture;
		this.hour = hour;
		this.view = view;
		this.price = price;
		this.discount = discount;
		this.promotionPrice = promotionPrice;
		this.desciption = desciption;
		this.content = content;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
		this.cateName = cateName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLecture() {
		return lecture;
	}

	public void setLecture(int lecture) {
		this.lecture = lecture;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(float promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getLastUpdate(Date date) {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String getCateName() {
		return cateName;
	}
	
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	

}
