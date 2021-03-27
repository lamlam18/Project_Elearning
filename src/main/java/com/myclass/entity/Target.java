package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "targets")
public class Target {
	@Id
	@Column(name = "id" , length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	id;
	
	@Column(name = "title" , length = 255)
	private String title;
	
	@Column(name = "course_id" , length = 11)
	private int courseId;
	
	@ManyToOne
	@JoinColumn(name = "course_id" , insertable = false , updatable = false)
	private Course course;
	
	public Target() {}

	public Target(int id, String title, int courseId, Course course) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
