package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDetailsDto;
import com.myclass.dto.CourseDto;
import com.myclass.dto.VideoDto;
import com.myclass.entity.Course;
import com.myclass.entity.Video;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;
import com.myclass.service.VideoService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CourseServiceImpl implements CourseService {
	private CourseRepository courseRepository;
	private VideoService videoService;

	public CourseServiceImpl(CourseRepository courseRepository, VideoService videoService) {
		this.courseRepository = courseRepository;
		this.videoService = videoService;
	}

	@Override
	public List<CourseDto> getAll() {
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		try {
			List<Course> entities = courseRepository.findAll();
			for (Course entity : entities) {
				CourseDto dto = new CourseDto();
				dto.setId(entity.getId());
				dto.setTitle(entity.getTitle());
				dto.setImage(entity.getImage());
				dto.setLectureCount(videoService.getByCourseId(entity.getId()).size());
				dto.setHourCount(videoService.getTimeCount(entity.getId()));
				dto.setViewCount(entity.getViewCount());
				dto.setPrice(entity.getPrice());
				dto.setDiscount(entity.getDiscount());
				dto.setPromotionPrice(promotionPrice(entity.getPrice(), entity.getDiscount()));
				dto.setDesciption(entity.getDesciption());
				dto.setContent(entity.getContent());
				dto.setCategoryId(entity.getCategoryId());
				dto.getLastUpdate(entity.getLastUpdate());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

	@Override
	public CourseDto getById(int id) {
		CourseDto dto = new CourseDto();
		Course entity = courseRepository.findById(id).get();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setImage(entity.getImage());
		dto.setLectureCount(videoService.getByCourseId(entity.getId()).size());
		dto.setHourCount(videoService.getTimeCount(entity.getId()));
		dto.setViewCount(entity.getViewCount());
		dto.setPrice(entity.getPrice());
		dto.setDiscount(entity.getDiscount());
		dto.setPromotionPrice(promotionPrice(entity.getPrice(), entity.getDiscount()));
		dto.setDesciption(entity.getDesciption());
		dto.setContent(entity.getContent());
		dto.setCategoryId(entity.getCategoryId());
		dto.getLastUpdate(entity.getLastUpdate());
		return dto;
	}

	public float promotionPrice(float price, float discount) {
		return price - (price * discount / 100);
	}

	@Override
	public boolean remove(int id) {
		if (courseRepository.findById(id) != null) {
			courseRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean edit(int id, CourseDto dto ) {
		if (courseRepository.findById(id) != null) {
			Course entity = courseRepository.findById(id).get();
			entity.setTitle(dto.getTitle());
			entity.setImage(dto.getImage());
			entity.setViewCount(dto.getViewCount());
			entity.setPrice(dto.getPrice());
			entity.setDiscount(dto.getDiscount());
			entity.setDesciption(dto.getDesciption());
			entity.setContent(dto.getContent());
			entity.setCategoryId(dto.getCategoryId());
			entity.setLastUpdate(dto.getLastUpdate());
			courseRepository.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public List<CourseDto> findByUserCourse(int id) {
		List<CourseDto> listCourse = new ArrayList<CourseDto>();
		try {
			List<Course>entities = courseRepository.findAllById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
