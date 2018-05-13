package com.cun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cun.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	@Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
	List<User> getUserByUserName(String userName);

	@Query(value = "select * from t_user where id = ?1", nativeQuery = true)
	List<User> getUserByUserId(Integer id);
}
