package com.myclass.service;

import java.util.List;

import com.myclass.dto.PasswordDto;
import com.myclass.dto.UserCourseDto;
import com.myclass.dto.UserDto;

public interface UserService {

	List<UserDto> getAll();

	boolean insert(UserDto dto);

	List<UserDto> getById(int id);

	boolean remove(int id);

	boolean edit(int id, UserDto dto);

	String changePassword(PasswordDto passwordDto);

	UserDto getProfile();
	
	UserDto findById(int id);

	boolean addToCart(int userId, int courseId);

	UserCourseDto getCart(int id);

	boolean deleteCourse(int userId, int courseId);

}
