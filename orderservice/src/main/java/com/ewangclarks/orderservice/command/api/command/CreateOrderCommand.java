package com.ewangclarks.orderservice.command.api.command;


import com.ewangclarks.commonlibrary.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private Long quantity;
    private String addressId;
    private OrderStatus orderStatus;
}
