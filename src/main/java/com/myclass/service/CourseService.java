package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDto;

public interface CourseService {

	List<CourseDto> getAll();

	CourseDto getById(int id);

	boolean remove(int id);

}
