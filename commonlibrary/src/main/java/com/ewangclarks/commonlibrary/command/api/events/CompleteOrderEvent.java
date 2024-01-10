package com.ewangclarks.commonlibrary.command.api.events;

import com.ewangclarks.commonlibrary.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompleteOrderEvent {
    private String orderId;
    private OrderStatus orderStatus;
}
