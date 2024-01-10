package com.ewangclarks.shipmentservice.command.api.events;


import com.ewangclarks.commonlibrary.command.api.events.CancelShipmentEvent;
import com.ewangclarks.commonlibrary.command.api.events.ShipOrderEvent;
import com.ewangclarks.shipmentservice.core.constant.ShipmentStatus;
import com.ewangclarks.shipmentservice.core.models.Shipping;
import com.ewangclarks.shipmentservice.core.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShipOrderEventHandler {

    private final ShippingRepository shippingRepository;

    @EventHandler
    public void on(ShipOrderEvent event) {
        shippingRepository.save(new Shipping(event.getShipmentId(), event.getOrderId(), ShipmentStatus.COMPLETE));
    }

    @EventHandler
    public void on(CancelShipmentEvent event) {
        Optional<Shipping> shipping = shippingRepository.findShippingByOrderId(event.getOrderId());
        shipping.ifPresent(shippingRepository::delete);
    }
}
