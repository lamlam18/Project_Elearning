package com.myclass.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.myclass.entity.Course;

public class VideoDto {
	private int id;
	private String title;
	private String url;
	private int timeCount;
	private int courseId;
	private String courseName;
	
	public VideoDto() {}
	
	public VideoDto(int id, String title, String url, int timeCount, int courseId, String courseName) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.timeCount = timeCount;
		this.courseId = courseId;
		this.courseName = courseName;
		
		
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(int timeCount) {
		this.timeCount = timeCount;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	

	
	
}
