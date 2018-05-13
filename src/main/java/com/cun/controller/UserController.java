package com.cun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cun.dao.UserDao;
import com.cun.entity.User;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RequestMapping("/user")
@EnableSwagger2
@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	/**
	 * 查 userName
	 * @param userName
	 * @return
	 */
	@GetMapping("getUserByUserName/{userName}")
	public List<User> getUserByUserName(@PathVariable String userName) {
		return userDao.getUserByUserName(userName);
	}

	/**
	 * 查 id
	 * @param userName
	 * @return
	 */
	@GetMapping("getUserByUserId/{id}")
	public List<User> getUserByUserId(@PathVariable Integer id) {
		return userDao.getUserByUserId(id);
	}

	
	/**
	 * 删
	 * @param id
	 */
	@DeleteMapping("deleteUserById/{id}")
	public List<User> deleteUserById(@PathVariable Integer id) {
		userDao.delete(id);
		return userDao.findAll();
	}

	/**
	 * 全
	 * @return
	 */
	@GetMapping("getAllUsers")
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	/**
	 * 增
	 * @param user
	 */
	@PostMapping("insertUser/{userName}/{password}")
	public List<User> insertUser(@PathVariable String userName,@PathVariable String password) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		userDao.save(user);
		return userDao.findAll();
	}

	/**
	 * 改
	 * @param user
	 */
	@PutMapping("updateUser/{id}/{userName}/{password}")
	public List<User> updateUser(@PathVariable Integer id,@PathVariable String userName,@PathVariable String password) {
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		userDao.save(user);
		return userDao.findAll();
	}

}
