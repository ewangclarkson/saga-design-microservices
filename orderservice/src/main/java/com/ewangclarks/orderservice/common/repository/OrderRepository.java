package com.ewangclarks.orderservice.common.repository;

import com.ewangclarks.orderservice.common.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    Optional<Order> findOrderByOrderId(String orderId);
}
