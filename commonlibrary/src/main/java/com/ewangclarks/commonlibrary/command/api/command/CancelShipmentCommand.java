package com.ewangclarks.commonlibrary.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CancelShipmentCommand {
    @TargetAggregateIdentifier
    private String orderId;
}
