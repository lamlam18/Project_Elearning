package com.myclass.dto;

import java.util.List;

public class UserCourseDto {
	private UserDto userDto;
	private List<CourseDto> listCourse;
	private int	roleId;
	
	public UserCourseDto() {}
	
	public UserCourseDto(UserDto userDto, List<CourseDto> listCourse , int roleId) {
		super();
		this.userDto = userDto;
		this.listCourse = listCourse;
		this.roleId = roleId;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public List<CourseDto> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<CourseDto> listCourse) {
		this.listCourse = listCourse;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
