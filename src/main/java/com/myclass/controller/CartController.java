package com.myclass.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.UserCourseDto;
import com.myclass.dto.UserDto;
import com.myclass.service.CourseService;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/cart")
public class CartController {
	private UserService userService;
	private CourseService courseService;

	public CartController(UserService userService, CourseService courseService) {
		this.userService = userService;
		this.courseService = courseService;
	}

	@GetMapping("/{id}")
	public Object get(@PathVariable int id) {
		try {
			UserCourseDto dto = userService.getCart(id);
			return new ResponseEntity<Object>(dto , HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/{userID} , /{courseId}")
	public Object post(@PathVariable int userId , @PathVariable int courseId) {
			if (userService.addToCart(userId , courseId))
				return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{userId},/{courseId}")
	public Object delete(@PathVariable int userId , @PathVariable int courseId) {
		try {
			if (userService.deleteCourse(userId , courseId))
				return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
