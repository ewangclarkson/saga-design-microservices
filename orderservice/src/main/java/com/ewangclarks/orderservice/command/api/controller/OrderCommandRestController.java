package com.ewangclarks.orderservice.command.api.controller;

import com.ewangclarks.commonlibrary.constant.OrderStatus;
import com.ewangclarks.orderservice.command.api.command.CreateOrderCommand;
import com.ewangclarks.orderservice.common.dto.OrderRestModel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderCommandRestController {

   private final CommandGateway commandGateway;

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRestModel orderRestModel) {
        return ResponseEntity.ok(commandGateway.sendAndWait(
                CreateOrderCommand.builder()
                        .orderId(UUID.randomUUID().toString())
                        .addressId(orderRestModel.getAddressId())
                        .productId(orderRestModel.getProductId())
                        .quantity(orderRestModel.getQuantity())
                        .userId(orderRestModel.getUserId())
                        .orderStatus(OrderStatus.CREATED)
                        .build()
                )
        );
    }


}
