package com.ewangclarks.orderservice.command.api.events.dto;

import com.ewangclarks.commonlibrary.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {
    private String orderId;
    private String productId;
    private String userId;
    private Long quantity;
    private String addressId;
    private OrderStatus orderStatus;
}
