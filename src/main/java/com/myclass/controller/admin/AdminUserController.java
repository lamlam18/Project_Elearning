package com.myclass.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.UserDto;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/admin/user")
public class AdminUserController {
	private UserService userService;

	public AdminUserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("")
	public Object get() {
		try {
			List<UserDto> dtos = userService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("")
	public Object post(@RequestBody UserDto dto) {
		if (userService.insert(dto))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	public Object get(@PathVariable int id) {
		try {
			List<UserDto> dtos = userService.getById(id);
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Object put(@PathVariable int id, @RequestBody UserDto dto) {
		if (userService.edit(id, dto))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		if (userService.remove(id))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
