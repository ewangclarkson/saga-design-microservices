package com.ewangclarks.paymentservice.core.constant;


public enum PaymentStatus {
    PENDING("PENDING"),
    COMPLETED("COMPLETED");

    private String name;

    PaymentStatus(String name) {
        this.name = this.name();
    }
    public String getName() {
        return name;
    }
}
