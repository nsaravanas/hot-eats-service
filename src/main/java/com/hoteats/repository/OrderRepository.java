package com.hoteats.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoteats.models.Orders;
import com.hoteats.models.enums.Status;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query("from Orders where userId = ?1")
	List<Orders> ordersByUserId(Long userId);

	@Query("update Orders set status = ?2, updatedBy = ?3 , updatedOn = ?4 where orderId = ?1")
	Orders updateOrderStatus(Long orderId, Status status, String updatedBy, LocalDateTime updatedOn);

	@Query("from Orders as o where o.status = 'PLACED' and o.orderItems.eatItemId is null")
	List<Orders> getAllUnprocessedEatOrders();

}
