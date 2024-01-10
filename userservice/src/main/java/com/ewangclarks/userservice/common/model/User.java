package com.ewangclarks.userservice.common.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String userId;
    private String fullName;
    private String cardNumber;
    private Integer validUntilMonth;
    private Integer validUntilYear;
    private Integer cvc;
}
