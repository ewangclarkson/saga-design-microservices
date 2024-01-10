package com.ewangclarks.commonlibrary.command.api.common.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDetailsDto {
    private String userId;
    private String name;
    private String cardNumber;
    private Integer validUntilMonth;
    private Integer  validUntilYear;
    private Integer cvc;
}
