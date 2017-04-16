package com.hoteats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoteats.models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query("from Orders where userId = ?1")
	List<Orders> ordersByUserId(Long userId);

}
