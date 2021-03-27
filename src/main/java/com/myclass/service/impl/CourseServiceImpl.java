package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;
import com.myclass.service.VideoService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CourseServiceImpl implements CourseService{
	private CourseRepository courseRepository;
	private VideoService videoService;
	public CourseServiceImpl(CourseRepository courseRepository , VideoService videoService) {
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
				dto.setLecture(videoService.getByCourseId(entity.getId()).size());
				dto.setHour(videoService.getTimeCount(entity.getId()));
				dto.setView(entity.getView());
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
		dto.setLecture(videoService.getByCourseId(entity.getId()).size());
		dto.setHour(videoService.getTimeCount(entity.getId()));
		dto.setView(entity.getView());
		dto.setPrice(entity.getPrice());
		dto.setDiscount(entity.getDiscount());
		dto.setPromotionPrice(promotionPrice(entity.getPrice(), entity.getDiscount()));
		dto.setDesciption(entity.getDesciption());
		dto.setContent(entity.getContent());
		dto.setCategoryId(entity.getCategoryId());
		dto.getLastUpdate(entity.getLastUpdate());
		return dto;
	}
	
	public float promotionPrice(float price , float discount) {
		return  price - (price * discount / 100);
	}

	@Override
	public boolean remove(int id) {
		if (courseRepository.findById(id) != null) {
			courseRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
