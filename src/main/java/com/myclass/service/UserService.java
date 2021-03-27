package com.myclass.service;

import java.util.List;

import com.myclass.dto.LoginDto;
import com.myclass.dto.UserDto;

public interface UserService {

	List<UserDto> getAll();

	void insert(UserDto dto);

	List<UserDto> getById(int id);

	void remove(int id);

	void edit(int id, UserDto dto);

}
