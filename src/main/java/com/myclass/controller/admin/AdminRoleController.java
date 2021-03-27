package com.myclass.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myclass.dto.RoleDto;
import com.myclass.service.RoleService;

@RestController
@RequestMapping("api/role")
public class AdminRoleController {
	private RoleService roleService;

	public AdminRoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@GetMapping("")
	public Object get() {
		try {
			List<RoleDto> dtos = roleService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("")
	public Object post(@RequestBody RoleDto dto) {
		if (roleService.insert(dto) == false)
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Object get(@PathVariable int id) {
		try {
			RoleDto dto = roleService.getByid(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/{id}")
	public Object post(@PathVariable int id, @RequestBody RoleDto dto) {
		if (roleService.edit(id, dto))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		if (roleService.remove(id))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
