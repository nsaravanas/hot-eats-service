package com.hoteats.service;

import com.hoteats.models.User;

public interface UserService {

	User findByUserById(Long userId);

	User saveUser(User testUser);

}
