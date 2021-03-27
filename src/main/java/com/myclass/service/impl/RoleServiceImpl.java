package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	private RoleRepository roleRepository;
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<RoleDto> getAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		List<Role> entities = roleRepository.findAll();
		for (Role role : entities) {
			RoleDto dto = new RoleDto(role.getId(), role.getName(), role.getDescription());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public Boolean insert(RoleDto dto) {
		try {
			Role entity = new Role(dto.getName(), dto.getDescripiton());
			roleRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public RoleDto getByid(int id) {
		Role entity =  roleRepository.findById(id).get();
		return new RoleDto(entity.getId(), entity.getName(), entity.getDescription());
	}

	@Override
	public void edit(int id, RoleDto dto) {
		if( roleRepository.existsById(id)) {
			Role entity = roleRepository.findById(id).get();
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescripiton());
			roleRepository.save(entity);
		}
	}

	@Override
	public void remove(int id) {
		roleRepository.deleteById(id);
	}

}
