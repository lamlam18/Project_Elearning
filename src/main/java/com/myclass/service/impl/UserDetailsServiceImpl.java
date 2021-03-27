package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDetailDto;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	private UserRepository userRepository;
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		User entity =  userRepository.findByEmail(email);
		if(entity == null) throw new UsernameNotFoundException("Email không tồn tại.");
		
		String roleName = entity.getRole().getName();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleName));
		
		UserDetails userDetails = new UserDetailDto(entity.getEmail(), entity.getPassword(), authorities);
		return userDetails;
	}
	
}
