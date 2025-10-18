package org.fokinms.journey.room_service.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.fokinms.journey.room_service.dto.OrderDto;
import org.fokinms.journey.room_service.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{orderId}")
    public OrderDto findOrderById(@NonNull @PathVariable Long orderId) {
        return orderService.findOrderById(orderId);
    }
}
