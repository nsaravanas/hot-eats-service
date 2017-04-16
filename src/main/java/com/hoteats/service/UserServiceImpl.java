package com.hoteats.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.User;
import com.hoteats.models.UserAddress;
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

	@Override
	@Transactional
	public User addUser(User user) {
		return this.repository.save(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return this.repository.save(user);
	}

	@Override
	@Transactional
	public void deleteUser(Long userId) {
		this.repository.delete(userId);
	}

	@Override
	@Transactional
	public void deleteAddress(Long userId, Long addressId) {
		this.repository.deleteAddress(userId, addressId);
	}

	@Override
	@Transactional
	public UserAddress addAddress(Long userId, UserAddress address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public UserAddress updateAddress(Long userId, UserAddress address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAddress> getAddress(Long userId) {
		return this.repository.getAddress(userId);
	}

}
