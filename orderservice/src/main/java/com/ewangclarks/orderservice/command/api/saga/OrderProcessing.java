package com.ewangclarks.orderservice.command.api.saga;

import com.ewangclarks.commonlibrary.command.api.command.CancelPaymentCommand;
import com.ewangclarks.commonlibrary.command.api.command.CompleteOrderCommand;
import com.ewangclarks.commonlibrary.command.api.command.ShipOrderCommand;
import com.ewangclarks.commonlibrary.command.api.command.ValidatePaymentCommand;
import com.ewangclarks.commonlibrary.command.api.common.dto.CardDetailsDto;
import com.ewangclarks.commonlibrary.command.api.events.*;
import com.ewangclarks.commonlibrary.constant.OrderStatus;
import com.ewangclarks.commonlibrary.query.api.query.GetUserCardDetailsQuery;
import com.ewangclarks.orderservice.command.api.command.CancelOrderCommand;
import com.ewangclarks.orderservice.command.api.events.dto.OrderCreatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
@Slf4j
@NoArgsConstructor
public class OrderProcessing {

    @Autowired
    private transient CommandGateway commandGateway;
    @Autowired
    private transient QueryGateway queryGateway;

    @SagaEventHandler(associationProperty = "orderId")
    @StartSaga
    private void handle(OrderCreatedEvent orderCreatedEvent) {

        GetUserCardDetailsQuery getUserCardDetailsQuery = new GetUserCardDetailsQuery();
        getUserCardDetailsQuery.setUserId(orderCreatedEvent.getUserId());
        CardDetailsDto cardDetailsDto = null;
        try {
            cardDetailsDto = queryGateway
                    .query(getUserCardDetailsQuery, ResponseTypes.instanceOf(CardDetailsDto.class))
                    .get();
        } catch (Exception e) {
            commandGateway.sendAndWait(CancelOrderCommand.builder()
                    .orderId(orderCreatedEvent.getOrderId())
                    .build()
            );
            log.error("Failed to get user card details");
        }

        log.info("process order created event for order id {}", orderCreatedEvent.getOrderId());

        ValidatePaymentCommand validatePaymentCommand
                = new ValidatePaymentCommand();
        validatePaymentCommand.setPaymentId(UUID.randomUUID().toString());
        validatePaymentCommand.setOrderId(orderCreatedEvent.getOrderId());
        validatePaymentCommand.setCardDetails(cardDetailsDto);

        commandGateway.sendAndWait(validatePaymentCommand);

    }

    @SagaEventHandler(associationProperty = "orderId")
    private void handle(PaymentProcessedEvent event) {
        log.info("process payment process event for order id {}", event.getOrderId());
        try {
            commandGateway.sendAndWait((new ShipOrderCommand(UUID.randomUUID().toString(), event.getOrderId())));
        } catch (Exception e) {

            CancelPaymentCommand command = new CancelPaymentCommand(event.getOrderId());
            commandGateway.sendAndWait(command);

        }
    }

    @SagaEventHandler(associationProperty = "orderId")
    private void handle(ShipOrderEvent event) {
        log.info("ship order event for order id {}", event.getOrderId());
        try {
            commandGateway.sendAndWait((new CompleteOrderCommand(event.getOrderId(), OrderStatus.CREATED)));
        } catch (Exception e) {
            log.error("failed to process ship order event for order id {}", event.getOrderId());

        }
    }

    @SagaEventHandler(associationProperty = "orderId")
    private void handle(CompleteOrderEvent event) {
        log.info("completed order event for order id {}", event.getOrderId());
    }


    @SagaEventHandler(associationProperty = "orderId")
    private void handle(CancelPaymentProcessedEvent event) {

        log.info("cancel payment event calls the cancel order command id {}", event.getOrderId());

        CancelOrderCommand command = CancelOrderCommand.builder()
                .orderId(event.getOrderId())
                .build();
        commandGateway.sendAndWait(command);
    }

        @SagaEventHandler(associationProperty = "orderId")
    @EndSaga
    private void handle(CancelShipmentEvent event) {

        log.info("cancel payment event calls the cancel order command id {}", event.getOrderId());

        CancelPaymentCommand command = CancelPaymentCommand.builder()
                .orderId(event.getOrderId())
                .build();
        commandGateway.sendAndWait(command);
    }

}
