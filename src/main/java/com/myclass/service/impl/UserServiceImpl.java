package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<UserDto> getAll() {
		// TODO Auto-generated method stub
		List<UserDto> dtos = userRepository.findAllUserRole();
		return dtos;
	}

	@Override
	public void insert(UserDto dto) {
		try {
			
			if (userRepository.findByEmail(dto.getEmail()) == null) {
				String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12));
				User entity = new  User(dto.getId(), dto.getEmail(), dto.getFullname(),
						hashed, dto.getAvatar(), dto.getPhone(),
						dto.getAddress() , dto.getRoleId());
				userRepository.save(entity);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<UserDto> getById(int id) {
		// TODO Auto-generated method stub
		List<UserDto>  dtos = userRepository.findByIdUserRole(id);
//		UserDto dto = new UserDto(entity.getId(), entity.getEmail(), entity.getFullname(),
//					entity.getPassword(), entity.getAvatar(), entity.getPhone(),
//					entity.getAddress() , entity.getRoleId());
		return dtos;
	}

	@Override
	public void remove(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public void edit(int id, UserDto dto) {
		if (userRepository.existsById(id)) {
			User entity =  userRepository.findById(id).get();
			entity.setId(id);
			entity.setEmail(dto.getEmail());
			entity.setAddress(dto.getAddress());
			entity.setAvatar(dto.getAvatar());
			entity.setFullname(dto.getFullname());
			entity.setPassword(dto.getPassword());
			entity.setPhone(dto.getPhone());
			entity.setRoleId(dto.getRoleId());
			userRepository.save(entity);
		}
	}
}
