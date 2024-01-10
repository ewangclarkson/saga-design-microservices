package com.ewangclarks.paymentservice.command.api.aggregate;


import com.ewangclarks.commonlibrary.command.api.command.CancelPaymentCommand;
import com.ewangclarks.commonlibrary.command.api.command.ValidatePaymentCommand;
import com.ewangclarks.commonlibrary.command.api.common.dto.CardDetailsDto;
import com.ewangclarks.commonlibrary.command.api.events.CancelPaymentProcessedEvent;
import com.ewangclarks.commonlibrary.command.api.events.PaymentProcessedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
@Data
public class ValidatePaymentAggregate {
    @AggregateIdentifier
    private String paymentId;
    private String orderId;
    private CardDetailsDto cardDetails;


    @CommandHandler
    public ValidatePaymentAggregate(ValidatePaymentCommand validatePaymentCommand) {
        PaymentProcessedEvent processedEvent = new PaymentProcessedEvent();
        BeanUtils.copyProperties(validatePaymentCommand, processedEvent);
        AggregateLifecycle.apply(processedEvent);
    }


    @EventSourcingHandler
    public void on(PaymentProcessedEvent event) {
        this.paymentId = event.getPaymentId();
        this.orderId = event.getOrderId();
        this.cardDetails = event.getCardDetails();
    }

    @CommandHandler
    public void on(CancelPaymentCommand command) {
        CancelPaymentProcessedEvent event = new CancelPaymentProcessedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

}
