package com.ewangclarks.userservice.query.api.controller;

import com.ewangclarks.commonlibrary.command.api.common.dto.CardDetailsDto;
import com.ewangclarks.commonlibrary.query.api.query.GetUserCardDetailsQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("/users/{userId}")
    ResponseEntity<CardDetailsDto> getUserCardDetails(@PathVariable String userId) {
        GetUserCardDetailsQuery getUserCardDetailsQuery = new GetUserCardDetailsQuery();
        getUserCardDetailsQuery.setUserId(userId);

        return ResponseEntity.ok(queryGateway.query(getUserCardDetailsQuery, ResponseTypes.instanceOf(CardDetailsDto.class)).join());
    }
}
