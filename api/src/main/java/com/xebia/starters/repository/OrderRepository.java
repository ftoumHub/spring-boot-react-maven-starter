package com.xebia.starters.repository;

import com.xebia.starters.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private final ConcurrentHashMap<UUID, Order> orderMap;

    public OrderRepository() {
        this.orderMap = new ConcurrentHashMap<>();
    }

    public Order saveOrder(Order order) {
        Order orderWithId = order.toBuilder().id(UUID.randomUUID()).build();

        orderMap.put(orderWithId.getId(), orderWithId);
        return orderWithId;
    }

    public List<Order> findAllOrders() {
        return new ArrayList<>(orderMap.values());
    }
}
