package com.xebia.starters.repository;

import com.xebia.starters.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class OrderRepository {
    private final HashMap<UUID, Order> orderMap;

    public OrderRepository() {
        this.orderMap = new HashMap<>();
    }

    public Order saveOrder(Order order) {
        Order orderWithId = order.toBuilder().id(UUID.randomUUID()).build();

        orderMap.put(orderWithId.getId(), orderWithId);
        return orderWithId;
    }
}
