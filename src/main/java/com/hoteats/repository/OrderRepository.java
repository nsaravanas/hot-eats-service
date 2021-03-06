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

	@Query("SELECT DISTINCT o FROM Orders o WHERE o.user.userId = ?1 ORDER BY o.orderedOn DESC")
	List<Orders> ordersByUserId(Long userId);

	@Query("SELECT DISTINCT o FROM Orders o WHERE o.user.userId = ?1 and o.status = ?2 ORDER BY o.orderedOn DESC")
	List<Orders> ordersByUserIdAndStatus(Long userId, Status status);

	@Query("SELECT DISTINCT o FROM Orders o WHERE o.status = ?1 ORDER BY o.orderedOn DESC")
	List<Orders> getOrdersByStatus(Status status);

	@Modifying
	@Query("UPDATE Orders o SET o.status = ?2, o.updatedBy = ?3 , o.updatedOn = ?4 where o.orderId = ?1")
	Integer updateOrderStatus(Long orderId, Status status, String updatedBy, LocalDateTime updatedOn);

	@Query("SELECT DISTINCT o FROM Orders o JOIN o.orderItems oi WHERE o.status = 'PLACED'")
	List<Orders> getAllUnprocessedEatOrders();

	@Query("SELECT DISTINCT o FROM Orders o WHERE o.orderId = ?1")
	List<Orders> findOneByOrderId(Long orderId);
}
