package com.ewangclarks.commonlibrary.command.api.common.dto.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
