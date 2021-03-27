package com.myclass.controller.admin;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.LoginDto;
import com.myclass.service.AuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api/admin/login")
public class AdminLoginController {
	private AuthService authService;
	public AdminLoginController(AuthService authService) {
		this.authService = authService;
	}
	
	
	@PostMapping("")
	public Object post(@RequestBody LoginDto loginDto) {
		try {
			String token =  authService.login(loginDto);
			return new ResponseEntity<Object>(token, HttpStatus.OK);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
