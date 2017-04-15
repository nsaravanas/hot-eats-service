package com.hoteats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.commons.CommonStubs;
import com.hoteats.models.User;
import com.hoteats.service.UserService;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService service;

	@Override
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User findByUserById(Long userId) {
		return this.service.findByUserById(userId);
	}

	@RequestMapping(value = "/sampleuser", method = RequestMethod.GET)
	public User testUser() {
		return CommonStubs.testUser();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public User addUser() {
		return this.service.saveUser(CommonStubs.testUser());
	}

}
