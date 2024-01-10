package com.ewangclarks.commonlibrary.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipOrderEvent {
    private String shipmentId;
    private String orderId;
}
