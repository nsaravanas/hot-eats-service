package com.hoteats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteats.models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
