package com.ewangclarks.orderservice.command.api.aggregates;

import com.ewangclarks.commonlibrary.command.api.command.CompleteOrderCommand;
import com.ewangclarks.commonlibrary.command.api.events.CompleteOrderEvent;
import com.ewangclarks.commonlibrary.constant.OrderStatus;
import com.ewangclarks.orderservice.command.api.command.CancelOrderCommand;
import com.ewangclarks.orderservice.command.api.command.CreateOrderCommand;
import com.ewangclarks.orderservice.command.api.events.dto.CancelOrderEvent;
import com.ewangclarks.orderservice.command.api.events.dto.OrderCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@Data
public class CreateOrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private Long quantity;
    private String addressId;
    private OrderStatus orderStatus;

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.productId = event.getProductId();
        this.userId = event.getUserId();
        this.quantity = event.getQuantity();
        this.addressId = this.getAddressId();
        this.orderStatus = this.getOrderStatus();
    }

    @CommandHandler
    public CreateOrderAggregate(CreateOrderCommand command) {
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        BeanUtils.copyProperties(command, orderCreatedEvent);
        apply(orderCreatedEvent);
    }

    @EventSourcingHandler
    public void on(CompleteOrderEvent event){
       this.orderStatus = this.getOrderStatus();
    }

    @CommandHandler
    public void handle(CompleteOrderCommand command) {
        CompleteOrderEvent event = new CompleteOrderEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(CancelOrderCommand command){
        CancelOrderEvent event  = new CancelOrderEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }
}
