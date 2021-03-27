package com.myclass.dto;

import java.util.List;

public class CourseDetailsDto {
	private CourseDto course;
	private List<VideoDto> videos;
	private List<TargetDto> targets;
	
	public CourseDetailsDto() {}
	
	public CourseDetailsDto(CourseDto course, List<VideoDto> videos, List<TargetDto> targets) {
		super();
		this.course = course;
		this.videos = videos;
		this.targets = targets;
	}

	public CourseDto getCourse() {
		return course;
	}

	public void setCourse(CourseDto course) {
		this.course = course;
	}

	public List<VideoDto> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoDto> videos) {
		this.videos = videos;
	}

	public List<TargetDto> getTargets() {
		return targets;
	}

	public void setTargets(List<TargetDto> targets) {
		this.targets = targets;
	}
	
	
	
	
}
