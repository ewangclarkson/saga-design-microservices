package com.ewangclarks.commonlibrary.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CancelPaymentCommand {
    @TargetAggregateIdentifier
    private String orderId;
}
