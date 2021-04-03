package com.myclass.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CourseDetailsDto;
import com.myclass.dto.CourseDto;
import com.myclass.dto.TargetDto;
import com.myclass.dto.VideoDto;
import com.myclass.service.CourseService;
import com.myclass.service.TargetService;
import com.myclass.service.VideoService;

@RestController
@RequestMapping("api/admin/course")
public class AdminCourseController {
	private CourseService courseService;
	private VideoService videoService;
	private TargetService targetService;
	public AdminCourseController(CourseService courseService , VideoService videoService , TargetService targetService) {
		this.courseService = courseService;
		this.videoService = videoService;
		this.targetService = targetService;
	}
	
	@GetMapping("")
	public Object get() {
		try {
			List<CourseDto> dtos = courseService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable int id) {
		if (courseService.remove(id))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable int id) {
		try {
			CourseDto dto = courseService.getById(id);
			List<VideoDto> videoDto = videoService.getByCourseId(id);
			List<TargetDto> targetDto = targetService.getByCourseId(id);
			CourseDetailsDto object = new CourseDetailsDto(dto, videoDto, targetDto);
			return new ResponseEntity<Object>(object , HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public Object put(@PathVariable int id , @RequestBody CourseDto dto ) {
		if(courseService.edit(id, dto ))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	
}
