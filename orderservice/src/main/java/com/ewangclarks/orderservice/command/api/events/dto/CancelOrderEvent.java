package com.ewangclarks.orderservice.command.api.events.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CancelOrderEvent {
    private String orderId;
}
