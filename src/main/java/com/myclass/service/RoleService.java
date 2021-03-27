package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;

public interface RoleService {

	List<RoleDto> getAll();

	Boolean insert(RoleDto dto);

	RoleDto getByid(int id);

	void edit(int id, RoleDto dto);

	void remove(int id);

}
