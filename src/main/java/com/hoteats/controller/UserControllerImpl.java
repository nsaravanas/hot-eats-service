package com.hoteats.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.commons.CommonStubs;
import com.hoteats.models.LoginResponse;
import com.hoteats.models.User;
import com.hoteats.models.UserAddress;
import com.hoteats.service.UserService;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService service;

	@Override
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User findByUserById(@PathVariable Long userId) {
		return this.service.findByUserById(userId);
	}

	@RequestMapping(value = "/sampleuser", method = RequestMethod.GET)
	public User testUser() {
		return CommonStubs.testUser();
	}

	@PostConstruct
	public User addTestUser() {
		return this.service.saveUser(CommonStubs.testUser());
	}

	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User user) {
		if (findByUsername(user.getUsername()) == null) {
			return new ResponseEntity<User>(this.service.addUser(user), HttpStatus.CREATED);
		}
		Map<String, Object> response = new HashMap<>();
		response.put("error", "username already exist");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public User findByUsername(@PathVariable String username) {
		return this.service.findByUsername(username);
	}

	@Override
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return this.service.updateUser(user);
	}

	@Override
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long userId) {
		this.service.deleteUser(userId);
	}

	@Override
	@RequestMapping(value = "/user/{userId}/address", method = RequestMethod.GET)
	public List<UserAddress> getAddress(@PathVariable Long userId) {
		return this.service.getAddress(userId);
	}

	@Override
	@RequestMapping(value = "/user/{userId}/address/add", method = RequestMethod.POST)
	public UserAddress addAddress(@PathVariable Long userId, @RequestBody UserAddress address) {
		return this.service.addAddress(userId, address);
	}

	@Override
	@RequestMapping(value = "/user/{userId}/address/update", method = RequestMethod.PUT)
	public UserAddress updateAddress(@PathVariable Long userId, @RequestBody UserAddress address) {
		return this.service.updateAddress(userId, address);
	}

	@Override
	@RequestMapping(value = "/user/{userId}/address/{addressId}", method = RequestMethod.DELETE)
	public void deleteAddress(@PathVariable Long userId, @PathVariable Long addressId) {
		this.service.deleteAddress(userId, addressId);
	}

	@Override
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse authenticateUser(@RequestBody User user) {
		return this.service.authenticateUser(user);
	}

}
