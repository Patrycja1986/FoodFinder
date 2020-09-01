package com.foodFinder.repository;

import com.foodFinder.model.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    Set<Order> findByRestaurantId(Long id);
    Set<Order> findByCustomerId(Long id);
}
