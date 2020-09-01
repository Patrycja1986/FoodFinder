package com.foodFinder.service.order;

import com.foodFinder.model.order.Order;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;

import java.util.Optional;
import java.util.Set;

public interface OrderService {
    void save(Order order);

    Optional<Order> findById(Long id);

    Set<Order> findAll();

    Set<Order> findByRestaurantId(Long id);

    Set<Order> findByCustomerId(Long id);

    void delete(Order byId);

    void save(Long customerId, Long restaurantId);
}
