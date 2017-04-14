package com.hoteats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteats.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
