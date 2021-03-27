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

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.service.CategoryService;

@RestController
@RequestMapping("api/admin/category")
public class AdminCategoryController {
	private CategoryService categoryService;

	public AdminCategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("")
	public Object get() {
		try {
			List<CategoryDto> dtos = categoryService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("")
	public Object post(@RequestBody CategoryDto dto) {
		if (categoryService.insert(dto) == false) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Object get(@PathVariable int id) {
		try {
			CategoryDto dto = categoryService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Object put(@PathVariable int id, @RequestBody CategoryDto dto) {
		if (categoryService.update(id, dto))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		if (categoryService.remove(id))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
