package com.ewangclarks.userservice.query.api.projection;


import com.ewangclarks.commonlibrary.command.api.common.dto.CardDetailsDto;
import com.ewangclarks.commonlibrary.command.api.common.dto.exception.UserNotFoundException;
import com.ewangclarks.commonlibrary.query.api.query.GetUserCardDetailsQuery;
import com.ewangclarks.userservice.common.model.User;
import com.ewangclarks.userservice.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserProjection {

    private final UserRepository userRepository;

    @QueryHandler
    public CardDetailsDto getUserPaymentDetails(GetUserCardDetailsQuery getUserCardDetailsQuery) {
        System.out.println("\n\n\n\n\n");
        System.out.println(getUserCardDetailsQuery);
        User user = userRepository.findUserByUserId(getUserCardDetailsQuery.getUserId()).get();//orElseThrow(() -> new UserNotFoundException(format("The user with id: %s could not be found", getUserCardDetailsQuery.getUserId())));
        System.out.println("\n\n\n\n\n");
        System.out.println(user);

        CardDetailsDto cardDetailsDto= CardDetailsDto.builder()
                .cardNumber(user.getCardNumber())
                .userId(user.getUserId())
                .cvc(user.getCvc())
                .name(user.getFullName())
                .validUntilMonth(user.getValidUntilMonth())
                .validUntilYear(user.getValidUntilYear())
                .build();
        return cardDetailsDto;
    }
}
