package com.jhnote.cms.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhnote.cms.model.User;
import com.jhnote.cms.service.UserService;


@RequestMapping("/user")
@RestController
public class UserController {

	
	@Resource
	private UserService userService;
	
	@GetMapping
	public List<User> index() {
		return userService.index();
	}
	
	@GetMapping("/new")
	public User create() {
		User user = new User();
		user.setName("test name");
		user.setMajor("rikei");
		user.setUniversity("AIIT");
		user.setUserKey(UUID.randomUUID().toString());
		userService.insert(user);
		return user;
	}
	
	
}
