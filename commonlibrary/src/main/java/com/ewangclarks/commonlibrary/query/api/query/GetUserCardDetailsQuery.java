package com.ewangclarks.commonlibrary.query.api.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserCardDetailsQuery {
    private String userId;
}
