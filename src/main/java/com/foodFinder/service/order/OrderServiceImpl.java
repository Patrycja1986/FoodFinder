package com.foodFinder.service.order;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.order.Order;
import com.foodFinder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Set<Order> findAll() {
        Iterable<Order> all = orderRepository.findAll();
        Set<Order> set = new HashSet<>();
        all.iterator().forEachRemaining(set::add);
        return set;
    }

    @Override
    public Set<Order> findByRestaurantId(Long id) {
        return orderRepository.findByRestaurantId(id);
    }


}
