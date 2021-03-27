package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> getAll();

	boolean insert(CategoryDto dto);

	CategoryDto getById(int id);
	
	boolean update(int id, CategoryDto dto);

	boolean remove(int id);

}
