package com.ewangclarks.shipmentservice.core.models;

import com.ewangclarks.shipmentservice.core.constant.ShipmentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Shipping {
    @Id
    private String shipmentId;
    private String orderId;
    @Enumerated(EnumType.STRING)
   private ShipmentStatus status;
}
