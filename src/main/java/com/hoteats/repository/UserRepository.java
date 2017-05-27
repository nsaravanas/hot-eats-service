package com.hoteats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoteats.models.User;
import com.hoteats.models.UserAddress;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("delete from UserAddress where userId = ?1 and addressId = ?2")
	void deleteAddress(Long userId, Long addressId);

	@Query("from UserAddress where userId = ?1")
	List<UserAddress> getAddress(Long userId);

	User getUserByUsernameAndPassword(String userame, String password);

	User findUserByUsername(String userame);
}
