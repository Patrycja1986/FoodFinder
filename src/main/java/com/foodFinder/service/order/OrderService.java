package com.foodFinder.service.order;

import com.foodFinder.model.order.Order;

import java.util.Optional;
import java.util.Set;

public interface OrderService {
    void save(Order order);

    Optional<Order> findById(Long id);

    Set<Order> findAll();

    Set<Order> findByRestaurantId(Long id);
}
