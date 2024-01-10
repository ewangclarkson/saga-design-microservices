package com.ewangclarks.orderservice.common.dto;


import lombok.Data;

@Data
public class OrderRestModel {
    private String productId;
    private String userId;
    private Long quantity;
    private String addressId;
}
