package com.ewangclarks.orderservice.command.api.events;

import com.ewangclarks.commonlibrary.command.api.common.dto.exception.ResourceNotFoundException;
import com.ewangclarks.commonlibrary.command.api.events.CompleteOrderEvent;
import com.ewangclarks.commonlibrary.constant.OrderStatus;
import com.ewangclarks.orderservice.command.api.events.dto.CancelOrderEvent;
import com.ewangclarks.orderservice.command.api.events.dto.OrderCreatedEvent;
import com.ewangclarks.orderservice.command.api.saga.OrderProcessing;
import com.ewangclarks.orderservice.common.model.Order;
import com.ewangclarks.orderservice.common.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderEventsHandler {

    private final OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        Order order = new Order();
        BeanUtils.copyProperties(event, order);
        orderRepository.save(order);
    }


    @EventHandler
    public void on(CompleteOrderEvent event) {
        Order order = orderRepository.findOrderByOrderId(event.getOrderId()).orElseThrow(() -> new ResourceNotFoundException("Cannot find the order with id " + event.getOrderId()));
        order.setOrderStatus(OrderStatus.APPROVED);
        orderRepository.save(order);
    }

    @EventHandler
    public void on(CancelOrderEvent event) {
        Optional<Order> order = orderRepository.findOrderByOrderId(event.getOrderId());
        order.ifPresent(orderRepository::delete);
    }


}
