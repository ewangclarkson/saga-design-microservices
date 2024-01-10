package com.ewangclarks.orderservice.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class CancelOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
}
