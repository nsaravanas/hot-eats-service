package com.hoteats.controller;

import java.util.List;

import com.hoteats.models.LoginResponse;
import com.hoteats.models.User;
import com.hoteats.models.UserAddress;

public interface UserController {

	User findByUserById(Long userId);

	User addUser(User user);

	User updateUser(User user);

	void deleteUser(Long userId);

	UserAddress addAddress(Long userId, UserAddress address);

	UserAddress updateAddress(Long userId, UserAddress address);

	void deleteAddress(Long userId, Long addressId);

	List<UserAddress> getAddress(Long userId);

	LoginResponse authenticateUser(User user);

}
