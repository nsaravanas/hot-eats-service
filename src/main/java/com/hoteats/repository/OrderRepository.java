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

	@Query("from Orders where userId = ?1")
	List<Orders> ordersByUserId(Long userId);

	@Modifying
	@Query("update Orders set status = ?2, updatedBy = ?3 , updatedOn = ?4 where orderId = ?1")
	Integer updateOrderStatus(Long orderId, Status status, String updatedBy, LocalDateTime updatedOn);

	@Query(nativeQuery = true, value = "SELECT O FROM ORDERS O INNER JOIN ORDER_ITEM OI ON OI.ORDER_ID = O.ORDER_ID WHERE O.STATUS = 'PLACED' AND OI.EAT_ITEM_ID IS NOT NULL")
	List<Orders> getAllUnprocessedEatOrders();

}
