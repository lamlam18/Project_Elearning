package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.VideoDto;
import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
import com.myclass.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
	private VideoRepository videoRepository;

	public VideoServiceImpl(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	@Override
	public List<VideoDto> getAll() {
		List<VideoDto> dtos = new ArrayList<VideoDto>();
		try {
			List<Video> entities = videoRepository.findAll();
			for (Video video : entities) {
				VideoDto dto = new VideoDto();
				dto.setId(video.getId());
				dto.setTitle(video.getTitle());
				dto.setUrl(video.getUrl());
				dto.setTimeCount(video.getTimeCount());
				dto.setCourseId(video.getCourseId());
				dto.setCourseName(video.getCourse().getTitle());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

	@Override
	public boolean insert(VideoDto dto) {
		if (videoRepository.findByTitle(dto.getTitle()) != null)
			return false;
		Video entity = new Video();
		entity.setTitle(dto.getTitle());
		entity.setUrl(dto.getUrl());
		entity.setTimeCount(entity.getTimeCount());
		entity.setCourseId(dto.getCourseId());
		videoRepository.save(entity);
		return true;
	}

	@Override
	public VideoDto getById(int id) {
		VideoDto dto = new VideoDto();
		try {
			Video entity = videoRepository.findById(id).get();
			dto.setId(entity.getId());
			dto.setTitle(entity.getTitle());
			dto.setUrl(entity.getUrl());
			dto.setTimeCount(entity.getTimeCount());
			dto.setCourseId(entity.getCourseId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public boolean delete(int id) {
		if (videoRepository.existsById(id)) {
			videoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<VideoDto> getByCourseId(int courseId) {
		List<VideoDto> dtos = new ArrayList<VideoDto>();
		try {
			List<Video> entities = videoRepository.findAllByCourseId(courseId);
			for (Video video : entities) {
				VideoDto dto = new VideoDto();
				dto.setId(video.getId());
				dto.setTitle(video.getTitle());
				dto.setUrl(video.getUrl());
				dto.setTimeCount(video.getTimeCount());
				dto.setCourseId(video.getCourseId());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

	public int getTimeCount(int courseId) {
		int timeCount = 0;
		try {
			List<Video> entities = videoRepository.findAllByCourseId(courseId);
			for (Video video : entities) {
				timeCount += video.getTimeCount();
			}
			return timeCount;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return timeCount;
	}

	@Override
	public boolean edit(int id, VideoDto dto) {
		if (videoRepository.findById(id) != null) {
			Video entity = videoRepository.findById(id).get();
			entity.setTitle(dto.getTitle());
			entity.setUrl(dto.getUrl());
			entity.setCourseId(dto.getCourseId());
			videoRepository.save(entity);
			return true;
		}
		return false;
	}

}
