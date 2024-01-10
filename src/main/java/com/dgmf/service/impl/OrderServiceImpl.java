package com.dgmf.service.impl;

import com.dgmf.dto.api.OrderApiDtoRequest;
import com.dgmf.dto.api.OrderApiDtoResponse;
import com.dgmf.dto.order.OrderDtoRequest;
import com.dgmf.dto.payment.PaymentDtoRequest;
import com.dgmf.entity.Order;
import com.dgmf.entity.Payment;
import com.dgmf.exception.PaymentException;
import com.dgmf.repository.OrderRepository;
import com.dgmf.repository.PaymentRepository;
import com.dgmf.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;


    @Override
    public OrderApiDtoResponse placeOrder(
            OrderApiDtoRequest orderApiDtoRequest
    ) {
        /* SAVING ORDER DETAILS */
        // Extraction of the OrderDtoRequest
        OrderDtoRequest orderDtoRequest =
                orderApiDtoRequest.getOrderDtoRequest();
        orderDtoRequest.setStatus("IN PROGRESS");
        orderDtoRequest.setOrderTrackingNumber(UUID.randomUUID().toString());

        // Mapping DTO to Entity
        Order order = modelMapper.map(orderDtoRequest, Order.class);

        // Saving Order
        Order savedOrder = orderRepository.save(order);

        /* SAVING PAYMENT DETAILS */
        // Extraction of the PaymentDtoRequest
        PaymentDtoRequest paymentDtoRequest =
                orderApiDtoRequest.getPaymentDtoRequest();
        paymentDtoRequest.setOrderId(savedOrder.getId());

        // We support only "Debit Card"
        // If Payment Failed: Card Type different to "Debit Card"
        if(!paymentDtoRequest.getCardType().equals("DEBIT")) {
            throw new PaymentException("Payment Card Type Do Not Support");
        }

        // Mapping DTO to Entity
        Payment payment = modelMapper.map(paymentDtoRequest, Payment.class);

        // Saving Payment
        Payment savedPayment = paymentRepository.save(payment);

        // ORDER API RESPONSE
        OrderApiDtoResponse orderApiDtoResponse =
                OrderApiDtoResponse.builder()
                        .orderDtoResponseTrackingNumber(
                                savedOrder.getOrderTrackingNumber()
                        )
                        .orderDtoResponseStatus(savedOrder.getStatus())
                        .orderDtoResponseMessage("SUCCESS")
                        .build();

        return orderApiDtoResponse;
    }
}
