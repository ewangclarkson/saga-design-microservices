package com.ewangclarks.paymentservice.core.model;

import com.ewangclarks.paymentservice.core.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "payment_details")
public class Payment {
    @Id
    private String paymentId;
    private String orderId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
