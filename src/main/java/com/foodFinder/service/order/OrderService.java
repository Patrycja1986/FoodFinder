package com.foodFinder.service.order;

import com.foodFinder.model.order.Order;
import com.foodFinder.model.order.OrderDTO;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;

public interface OrderService {
    void save(OrderDTO orderDTO) throws ParseException;

    OrderDTO findById(Long id);

    Set<OrderDTO> findAll();

    Set<OrderDTO> findByRestaurantId(Long id);

    Set<OrderDTO> findByCustomerId(Long id);

    void delete(Long id);

    void save(Long customerId, Long restaurantId);
    void save(Long customerId);
}
