package com.myclass.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.VideoDto;
import com.myclass.service.VideoService;

@RestController
@RequestMapping("api/admin/video")
public class AdminVideoController {
	private VideoService videoService;

	public AdminVideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("")
	public Object get() {
		try {
			List<VideoDto> dtos = videoService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("")
	public Object post(@RequestBody VideoDto dto) {
		if (videoService.insert(dto))
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("{/id}")
	public Object get(@PathVariable int id) {
		VideoDto dto = videoService.getById(id);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}

	@DeleteMapping("{/id}")
	public Object delete(@PathVariable int id) {
		if (videoService.delete(id))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public Object put(@PathVariable int id , @RequestBody VideoDto dto) {
		if (videoService.edit(id , dto))
			return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
