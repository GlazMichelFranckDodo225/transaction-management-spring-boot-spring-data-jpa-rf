package com.dgmf.dto.api;

import com.dgmf.dto.order.OrderDtoRequest;
import com.dgmf.dto.payment.PaymentDtoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderApiDtoRequest {
    private OrderDtoRequest orderDtoRequest;
    private PaymentDtoRequest paymentDtoRequest;
}
