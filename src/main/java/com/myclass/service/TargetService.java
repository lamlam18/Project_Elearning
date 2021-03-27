package com.myclass.service;

import java.util.List;

import com.myclass.dto.TargetDto;

public interface TargetService {

	List<TargetDto> getAll();
	
	List<TargetDto> getByCourseId(int courseId);

	boolean insert(TargetDto dto);

	TargetDto getById(int id);

	boolean delete(int id);

	boolean edit(int id, TargetDto dto);
}
