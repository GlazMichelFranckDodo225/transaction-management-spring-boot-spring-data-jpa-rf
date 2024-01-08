package com.dgmf.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderApiDtoResponse {
    private String orderDtoResponseTrackingNumber;
    private String orderDtoResponseStatus;
    private String orderDtoResponseMessage;
}
