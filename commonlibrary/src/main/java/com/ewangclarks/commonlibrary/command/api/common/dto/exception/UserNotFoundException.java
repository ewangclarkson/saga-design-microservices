package com.ewangclarks.commonlibrary.command.api.common.dto.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
