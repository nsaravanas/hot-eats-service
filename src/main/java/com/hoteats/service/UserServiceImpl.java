package com.hoteats.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.LoginResponse;
import com.hoteats.models.User;
import com.hoteats.models.UserAddress;
import com.hoteats.models.UserInfo;
import com.hoteats.models.enums.LoginStatus;
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
		return null;
	}

	@Override
	@Transactional
	public UserAddress updateAddress(Long userId, UserAddress address) {
		return null;
	}

	@Override
	public List<UserAddress> getAddress(Long userId) {
		return this.repository.getAddress(userId);
	}

	@Override
	public LoginResponse authenticateUser(User user) {
		LoginResponse ret = new LoginResponse();
		User response = this.repository.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (response != null) {
			ret.setStatus(LoginStatus.SUCCESS);
			ret.setUserame(response.getUsername());
			ret.setUserId(response.getUserId());
			UserInfo info = response.getUserInfo();
			if (info != null)
				ret.setName(info.getFirstName());
		}
		return ret;
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		return this.repository.findUserByUsername(username);
	}

}
