package com.ewangclarks.commonlibrary.constant;

public enum OrderStatus {
    CREATED("CREATED"),
    CANCELLED("CANCELED"),
    APPROVED("APPROVED");

    private String name;

    OrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
