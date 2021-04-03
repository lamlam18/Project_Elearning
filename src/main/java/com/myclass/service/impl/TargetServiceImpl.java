package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.TargetDto;
import com.myclass.entity.Target;
import com.myclass.repository.TargetRepository;
import com.myclass.service.TargetService;

@Service
public class TargetServiceImpl implements TargetService{
	private TargetRepository targetRepository;
	public TargetServiceImpl(TargetRepository targetRepository) {
		this.targetRepository = targetRepository;
	}
	
	@Override
	public List<TargetDto> getAll() {
		List<TargetDto> dtos = new ArrayList<TargetDto>();
		try {
			List<Target> entities = targetRepository.findAll();
			for (Target target : entities) {
				TargetDto dto = new TargetDto();
				dto.setId(target.getId());
				dto.setTitle(target.getTitle());
				dto.setCourseId(target.getCourseId());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

	@Override
	public List<TargetDto> getByCourseId(int courseId) {
		List<TargetDto> dtos = new ArrayList<TargetDto>();
		try {
			List<Target> entities = targetRepository.findByCourseId(courseId);
			for (Target target : entities) {
				TargetDto dto = new TargetDto();
				dto.setId(target.getId());
				dto.setTitle(target.getTitle());
				dto.setCourseId(target.getCourseId());
				dtos.add(dto);
				return dtos;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

	@Override
	public boolean insert(TargetDto dto) {
		if (targetRepository.findById(dto.getId()) != null) 
			return false;
		Target entity = new Target();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setCourseId(dto.getCourseId());
		targetRepository.save(entity);
		return true;
	}

	@Override
	public TargetDto getById(int id) {
		Target entity = targetRepository.findById(id).get();
		TargetDto dto = new TargetDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setCourseId(entity.getCourseId());
		return dto;
	}

	@Override
	public boolean delete(int id) {
		if(targetRepository.findById(id) != null)
			return false;
		targetRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean edit(int id, TargetDto dto) {
		if(targetRepository.findById(id) != null) {
			Target entity = targetRepository.findById(id).get();
			entity.setTitle(dto.getTitle());
			entity.setCourseId(dto.getCourseId());
			targetRepository.save(entity);
			return true;
		}
		return false;
	}
}
