package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
public class CategoryServcieImpl implements CategoryService {
	private CategoryRepository categoryRepository;

	public CategoryServcieImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> getAll() {
		// TODO Auto-generated method stub
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();
		try {
			List<Category> entities = categoryRepository.findAll();
			for (Category category : entities) {
				CategoryDto dto = new CategoryDto(category.getId(), category.getName(), category.getIcon());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

	@Override
	public boolean insert(CategoryDto dto) {
		try {
			Category entity = new Category(dto.getName(), dto.getIcon());
			categoryRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

	@Override
	public CategoryDto getById(int id) {
		// TODO Auto-generated method stub
		Category entity = categoryRepository.findById(id).get();
		return new CategoryDto(entity.getId(), entity.getName(), entity.getIcon());
	}

	@Override
	public boolean update(int id, CategoryDto dto) {
		if (categoryRepository.existsById(id)) {
			Category entity = categoryRepository.findById(id).get();
			entity.setName(dto.getName());
			entity.setIcon(dto.getIcon());
			categoryRepository.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		if (categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
