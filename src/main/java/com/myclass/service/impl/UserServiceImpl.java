package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDto;
import com.myclass.dto.PasswordDto;
import com.myclass.dto.UserCourseDto;
import com.myclass.dto.UserDto;
import com.myclass.entity.Course;
import com.myclass.entity.User;
import com.myclass.repository.CourseRepository;
import com.myclass.repository.UserRepository;
import com.myclass.service.CourseService;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private CourseRepository courseRepository;
	private CourseService courseService;

	public UserServiceImpl(UserRepository userRepository , CourseRepository courseRepository , CourseService courseService) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
		this.courseService = courseService;
	}

	@Override
	public List<UserDto> getAll() {
		List<UserDto> dtos = userRepository.findAllUserRole();
		return dtos;
	}

	@Override
	public boolean insert(UserDto dto) {
		if (userRepository.findByEmail(dto.getEmail()) == null) {
			String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12));
			User entity = new User(dto.getId(), dto.getEmail(), dto.getFullname(), hashed, dto.getAvatar(),
					dto.getPhone(), dto.getAddress(), dto.getRoleId());
			userRepository.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public List<UserDto> getById(int id) {
		List<UserDto> dtos = userRepository.findByIdUserRole(id);
		return dtos;
	}

	@Override
	public boolean remove(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean edit(int id, UserDto dto) {
		if (userRepository.existsById(id)) {
			User entity = userRepository.findById(id).get();
			entity.setId(id);
			entity.setEmail(dto.getEmail());
			entity.setAddress(dto.getAddress());
			entity.setAvatar(dto.getAvatar());
			entity.setFullname(dto.getFullname());
			entity.setPassword(dto.getPassword());
			entity.setPhone(dto.getPhone());
			entity.setRoleId(dto.getRoleId());
			userRepository.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public UserDto getProfile() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		UserDetails userDetails = (UserDetails)principal;
//		String email = userDetails.getUsername();
		String email = ((UserDetails) principal).getUsername();

		User user = userRepository.findByEmail(email);

		return new UserDto(user.getId(), user.getEmail(), user.getFullname(), user.getRoleId());
	}

	@Override
	public String changePassword(PasswordDto passwordDto) {

		if (passwordDto.getNewPassword().equals(passwordDto.getOldPassword())) {
			return "Mật khẩu cũ và mới không được trùng nhau!";
		}

		User user = userRepository.findByEmail(passwordDto.getEmail());
		// So mật khẩu cũ với mật khẩu lưu trong db
		if (!BCrypt.checkpw(passwordDto.getOldPassword(), user.getPassword())) {
			return "Mật khẩu cũ không đúng!";
		}
		// Mã hóa mật khẩu
		String hashed = BCrypt.hashpw(passwordDto.getNewPassword(), BCrypt.gensalt());
		// Cập nhật lại mật khẩu
		user.setPassword(hashed);
		userRepository.save(user);

		return null;
	}

	@Override
	public UserDto findById(int id) {
		UserDto dto = null;
		try {
			User entity = userRepository.findById(id).get();
			dto.setId(id);
			dto.setEmail(entity.getEmail());
			dto.setAddress(entity.getAddress());
			dto.setAvatar(entity.getAvatar());
			dto.setFullname(entity.getFullname());
			dto.setPassword(entity.getPassword());
			dto.setPhone(entity.getPhone());
			dto.setRoleId(entity.getRoleId());
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}

	@Override
	public boolean addToCart(int userId, int courseId) {
		if (userRepository.findById(userId) == null || courseRepository.findById(courseId) == null)
			return false;
		User entity = userRepository.findById(userId).get();
		entity.getCourses().add(courseRepository.findById(courseId).get());
		return true;
	}

	@Override
	public UserCourseDto getCart(int id) {
		UserCourseDto dto = new UserCourseDto();
		try {
			if(userRepository.findById(id) != null) {
				List<CourseDto> listCourseDto = new ArrayList<>();
				User user = userRepository.findById(id).get();
				List<Course> listCourse = user.getCourses();
				for (Course course : listCourse) {
					CourseDto courseDto = courseService.getById(course.getId());
					listCourseDto.add(courseDto);
				}
				UserDto userDto = findById(id);
				dto.setListCourse(listCourseDto);
				dto.setUserDto(userDto);
				dto.setRoleId(userDto.getRoleId());
				return dto;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
		
	}

	@Override
	public boolean deleteCourse(int userId, int courseId) {
		if (userRepository.findById(userId) != null) {
			User entity = userRepository.findById(userId).get();
			entity.getCourses().remove(courseId);
			return true;
		}
		return false;
	}

}
