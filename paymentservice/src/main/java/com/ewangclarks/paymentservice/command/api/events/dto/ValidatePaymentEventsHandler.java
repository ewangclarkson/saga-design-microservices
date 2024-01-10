package com.ewangclarks.paymentservice.command.api.events.dto;

import com.ewangclarks.commonlibrary.command.api.events.CancelPaymentProcessedEvent;
import com.ewangclarks.commonlibrary.command.api.events.PaymentProcessedEvent;
import com.ewangclarks.paymentservice.core.PaymentRepository;
import com.ewangclarks.paymentservice.core.constant.PaymentStatus;
import com.ewangclarks.paymentservice.core.model.Payment;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ValidatePaymentEventsHandler {

    private final PaymentRepository paymentRepository;

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        Payment payment = new Payment(event.getPaymentId(), event.getOrderId(), PaymentStatus.COMPLETED);
        paymentRepository.save(payment);
    }

    @EventHandler
    public void on(CancelPaymentProcessedEvent event){
        Optional<Payment> payment = paymentRepository.findPaymentByOrderId(event.getOrderId());
        payment.ifPresent(paymentRepository::delete);
    }
}
