package com.myclass.dto;

public class TargetDto {
	private int		id;
	private String	title;
	private int		courseId;
	
	public TargetDto() {}

	public TargetDto(int id, String title, int courseId) {
		super();
		this.id = id;
		this.title = title;
		this.courseId = courseId;
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

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
	
}
