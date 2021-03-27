package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDto;
import com.myclass.dto.CourseEdit;

public interface CourseService {

	List<CourseDto> getAll();

	CourseDto getById(int id);

	boolean remove(int id);

	boolean edit(int id, CourseEdit dto);

}
