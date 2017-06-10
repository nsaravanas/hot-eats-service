package com.hoteats.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoteats.models.Orders;
import com.hoteats.models.enums.Status;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query("FROM Orders o WHERE o.user.userId = ?1 ORDER BY orderedOn DESC")
	List<Orders> ordersByUserId(Long userId);

	@Query("FROM Orders o WHERE o.user.userId = ?1 and status = ?2 ORDER BY orderedOn DESC")
	List<Orders> ordersByUserIdAndStatus(Long userId, Status status);

	@Query("FROM Orders WHERE status = ?1 ORDER BY orderedOn DESC")
	List<Orders> getOrdersByStatus(Status status);

	@Modifying
	@Query("UPDATE Orders SET status = ?2, updatedBy = ?3 , updatedOn = ?4 where orderId = ?1")
	Integer updateOrderStatus(Long orderId, Status status, String updatedBy, LocalDateTime updatedOn);

	@Query("SELECT o FROM Orders o JOIN	o.orderItems oi WHERE status = 'PLACED'")
	List<Orders> getAllUnprocessedEatOrders();

}
