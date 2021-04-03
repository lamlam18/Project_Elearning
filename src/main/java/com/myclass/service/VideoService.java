package com.myclass.service;

import java.util.List;

import com.myclass.dto.VideoDto;

public interface VideoService {

	List<VideoDto> getAll();

	boolean insert(VideoDto dto);

	VideoDto getById(int id);

	boolean delete(int id);
	
	List<VideoDto> getByCourseId(int courseId);
	
	int getTimeCount(int courseId);

	boolean edit(int id, VideoDto dto);

}
