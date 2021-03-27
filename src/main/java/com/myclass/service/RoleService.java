package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;

public interface RoleService {

	List<RoleDto> getAll();

	Boolean insert(RoleDto dto);

	RoleDto getByid(int id);

	boolean edit(int id, RoleDto dto);

	boolean remove(int id);

}
