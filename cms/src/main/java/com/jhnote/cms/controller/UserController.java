package com.jhnote.cms.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhnote.cms.model.User;
import com.jhnote.cms.service.UserService;

import net.sf.json.JSONObject;


@RequestMapping("/user")
@RestController
public class UserController {

	
	@Resource
	private UserService userService;
	
	@GetMapping
	public List<User> index() {
		return userService.index();
	}
	
	@PostMapping("/new")
	public User create(@RequestBody String params) {
		JSONObject jsonObjeckt = JSONObject.fromObject(params);
		User user = (User) JSONObject.toBean(jsonObjeckt, User.class);
		user.setUserKey(UUID.randomUUID().toString());
		userService.insert(user);
		return user;
	}
	
	
}
