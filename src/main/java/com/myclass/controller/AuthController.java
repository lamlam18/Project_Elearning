package com.myclass.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.LoginDto;
import com.myclass.dto.UserDto;
import com.myclass.service.AuthService;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	private AuthService authService;
	private UserService userService;
	public AuthController(UserService userService , AuthService authService) {
		this.userService = userService;
		this.authService = authService;
	}
	
	@PostMapping("login")
	public Object post(@RequestBody LoginDto loginDto) {
		try {
			String token = authService.login(loginDto);
			return new ResponseEntity<Object>(token , HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
