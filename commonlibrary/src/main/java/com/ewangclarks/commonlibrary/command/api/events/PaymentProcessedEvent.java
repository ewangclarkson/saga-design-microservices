package com.ewangclarks.commonlibrary.command.api.events;


import com.ewangclarks.commonlibrary.command.api.common.dto.CardDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentProcessedEvent {
    private String paymentId;
    private String orderId;
    private CardDetailsDto cardDetails;
}
