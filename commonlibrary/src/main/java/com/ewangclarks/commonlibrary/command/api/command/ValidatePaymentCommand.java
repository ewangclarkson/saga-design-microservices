package com.ewangclarks.commonlibrary.command.api.command;

import com.ewangclarks.commonlibrary.command.api.common.dto.CardDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidatePaymentCommand {
    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
    private CardDetailsDto cardDetails;
}
