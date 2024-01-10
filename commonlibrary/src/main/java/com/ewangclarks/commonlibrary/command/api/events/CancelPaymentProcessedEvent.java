package com.ewangclarks.commonlibrary.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CancelPaymentProcessedEvent {
    private String orderId;
}
