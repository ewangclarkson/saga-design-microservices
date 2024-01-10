package com.ewangclarks.commonlibrary.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShipOrderCommand {
    @TargetAggregateIdentifier
    private String shipmentId;
    private String orderId;
}
