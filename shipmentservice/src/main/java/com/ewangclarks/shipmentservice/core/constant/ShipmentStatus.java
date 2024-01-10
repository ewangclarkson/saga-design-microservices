package com.ewangclarks.shipmentservice.core.constant;

public enum ShipmentStatus {
    PENDING("PENDING"),
    COMPLETE("COMPLETE");

    private String name;

    ShipmentStatus(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
