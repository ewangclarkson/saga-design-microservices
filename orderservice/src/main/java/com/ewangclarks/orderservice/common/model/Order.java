package com.ewangclarks.orderservice.common.model;

import com.ewangclarks.commonlibrary.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders")
public class Order {
    @Id
    @Column(nullable = false)
    private String orderId;
    @Column(nullable = false)
    private String productId;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private String addressId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;
}
