package com.xebia.starters.api;

import com.xebia.starters.domain.Order;
import com.xebia.starters.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderResource {

    private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    private OrderRepository orderRepository;

    public OrderResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping(path = "/api/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order orderWithId = orderRepository.saveOrder(order);
        System.out.println(orderWithId);
        return ResponseEntity.ok(orderWithId);
    }
}
