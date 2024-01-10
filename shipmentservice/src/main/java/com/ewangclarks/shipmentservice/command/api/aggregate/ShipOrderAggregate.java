package com.ewangclarks.shipmentservice.command.api.aggregate;

import com.ewangclarks.commonlibrary.command.api.command.CancelShipmentCommand;
import com.ewangclarks.commonlibrary.command.api.command.ShipOrderCommand;
import com.ewangclarks.commonlibrary.command.api.events.CancelShipmentEvent;
import com.ewangclarks.commonlibrary.command.api.events.ShipOrderEvent;
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
public class ShipOrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String shipmentId;

    @CommandHandler
    public ShipOrderAggregate(ShipOrderCommand command) {
        ShipOrderEvent event = new ShipOrderEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShipOrderEvent event) {
        this.shipmentId = event.getShipmentId();
        this.orderId = event.getOrderId();
    }

    @CommandHandler
    public void on(CancelShipmentCommand command){
        CancelShipmentEvent event = new CancelShipmentEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }
}
