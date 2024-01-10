package com.ewangclarks.commonlibrary.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CancelShipmentEvent {
    private String orderId;
}
