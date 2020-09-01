package com.foodFinder.service.order;

import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.order.Order;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.CustomerRepository;
import com.foodFinder.repository.OrderRepository;
import com.foodFinder.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CustomerRepository customerRepository;

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

    @Override
    public Set<Order> findByCustomerId(Long id) {
        return orderRepository.findByCustomerId(id);
    }

    @Override
    public void delete(Order byId) {
        orderRepository.delete(byId);
    }

    @Override
    public void save(Long customerId, Long restaurantId) {
        Customer customer = customerRepository.findById(customerId).get();
        Restaurant restaurant=restaurantRepository.findById(restaurantId).get();
        Order order= new Order(customer,restaurant);
        orderRepository.save(order);

    }

}
