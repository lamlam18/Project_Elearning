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

import com.myclass.dto.TargetDto;
import com.myclass.service.TargetService;

@RestController
@RequestMapping("api/admin/target")
public class AdminTargetController {
	private TargetService targetService;

	public AdminTargetController(TargetService targetService) {
		this.targetService = targetService;
	}

	@GetMapping("")
	public Object get() {
		try {
			List<TargetDto> dtos = targetService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("")
	public Object post(@RequestBody TargetDto dto) {
		if (targetService.insert(dto))
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	public Object get(@PathVariable int id) {
		try {
			TargetDto dto = targetService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		if (targetService.delete(id))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public Object put(@PathVariable int id , @RequestBody TargetDto dto) {
		if (targetService.edit(id, dto))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
