package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDto;

public interface UserService {

	List<UserDto> getAll();

	boolean insert(UserDto dto);

	List<UserDto> getById(int id);

	boolean remove(int id);

	boolean edit(int id, UserDto dto);

}
