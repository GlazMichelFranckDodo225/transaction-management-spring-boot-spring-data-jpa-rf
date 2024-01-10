package com.dgmf.controller;

import com.dgmf.dto.api.OrderApiDtoRequest;
import com.dgmf.dto.api.OrderApiDtoResponse;
import com.dgmf.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // Place Order REST API
    @PostMapping
    public ResponseEntity<OrderApiDtoResponse> placeOrder (
            @RequestBody OrderApiDtoRequest orderApiDtoRequest
    ) {
        return ResponseEntity.ok(orderService.placeOrder(orderApiDtoRequest));
    }
}
