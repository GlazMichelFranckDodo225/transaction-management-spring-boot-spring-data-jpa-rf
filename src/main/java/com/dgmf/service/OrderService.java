package com.dgmf.service;

import com.dgmf.dto.api.OrderApiDtoRequest;
import com.dgmf.dto.api.OrderApiDtoResponse;

public interface OrderService {
    OrderApiDtoResponse placeOrder(OrderApiDtoRequest orderApiDtoRequest);
}
