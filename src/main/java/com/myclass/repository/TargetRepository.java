package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Target;

@Repository
public interface TargetRepository extends JpaRepository<Target, Integer>{

	List<Target> findByCourseId(int courseId);

}
