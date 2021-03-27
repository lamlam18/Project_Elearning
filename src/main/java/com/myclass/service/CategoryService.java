package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;

public interface CategoryService {

	List<CategoryDto> getAll();

	boolean insert(CategoryDto dto);

	CategoryDto getById(int id);

	
	void update(int id, CategoryDto dto);

	void remove(int id);

}
