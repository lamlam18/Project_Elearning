package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT new com.myclass.dto.UserDto (u.id , u.email , u.fullname , u.password , u.avatar , u.phone , u.address ,u.roleId , r.name)"
			+ " FROM User u JOIN u.role r")
	List<UserDto> findAllUserRole();
	
	@Query("SELECT new com.myclass.dto.UserDto (u.id , u.email , u.fullname , u.password , u.avatar , u.phone , u.address ,u.roleId , r.name)"
			+ " FROM User u JOIN u.role r where u.id = ?1")
	List<UserDto> findByIdUserRole(int id);
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findByEmail(@Param("email")String email);
	
}
