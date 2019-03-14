package com.jhnote.cms.service;

import com.jhnote.cms.mapper.UserMapper;
import com.jhnote.cms.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public void insert(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	public List<User> index() {
		// TODO Auto-generated method stub
		return userMapper.index();
	}
	
}
