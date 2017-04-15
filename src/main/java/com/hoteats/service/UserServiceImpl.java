package com.hoteats.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.User;
import com.hoteats.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	@Transactional
	public User findByUserById(Long userId) {
		return this.repository.findOne(userId);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return this.repository.save(user);
	}
}
