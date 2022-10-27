package com.xebia.starters.api;

import com.xebia.starters.domain.Order;
import com.xebia.starters.repository.OrderRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.xebia.starters.utils.LogUtils.logAsJsonObjet;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderResource {

    private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    private final OrderRepository orderRepository;

    public OrderResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping(path = "/api/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        logger.info("POST: /api/orders");
        Order orderWithId = orderRepository.saveOrder(order);
        logAsJsonObjet(logger, "Order with id : \n{}", new JSONObject(orderWithId));

        return ResponseEntity.ok(orderWithId);
    }

    @GetMapping(path = "/api/orders")
    public ResponseEntity<List<Order>> getAllCategories() {
        logger.info("GET: /api/orders");
        final List<Order> orders = orderRepository.findAllOrders();
        return ResponseEntity.ok(orders);
    }
}
