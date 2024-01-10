package com.ewangclarks.paymentservice.core;

import com.ewangclarks.paymentservice.core.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String> {
    Optional<Payment> findPaymentByOrderId(String orderID);
}
