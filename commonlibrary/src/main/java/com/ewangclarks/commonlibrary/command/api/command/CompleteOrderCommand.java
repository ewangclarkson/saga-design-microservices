package com.ewangclarks.commonlibrary.command.api.command;

import com.ewangclarks.commonlibrary.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompleteOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private OrderStatus orderStatus;
}
