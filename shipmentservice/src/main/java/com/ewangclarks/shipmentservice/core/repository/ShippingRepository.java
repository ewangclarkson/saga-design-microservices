package com.ewangclarks.shipmentservice.core.repository;

import com.ewangclarks.shipmentservice.core.models.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,String> {
    Optional<Shipping> findShippingByOrderId(String orderId);
}
