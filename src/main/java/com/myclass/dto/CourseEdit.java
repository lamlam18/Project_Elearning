package com.myclass.dto;

import java.sql.Date;

public class CourseEdit {
	private int id;
	private String	title;
	private String	image;
	private float	price;
	private int		discount;
	private String	desciption;
	private String	content;
	private int		categoryId;
	private Date	lastUpdate;
	
	public CourseEdit() {}

	public CourseEdit(int id, String title, String image, float price, int discount, String desciption, String content,
			int categoryId, Date lastUpdate) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
		this.discount = discount;
		this.desciption = desciption;
		this.content = content;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
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

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
