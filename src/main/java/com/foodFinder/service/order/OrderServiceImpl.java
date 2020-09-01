package com.foodFinder.service.order;

import com.foodFinder.exceptions.restaurant.ObjectNotFoundException;
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

        Optional<Restaurant> byId = restaurantRepository.findById(id);
        if(byId.isPresent()){
            return orderRepository.findByRestaurantId(id);
        }else{
            throw new ObjectNotFoundException("Restaurant by id= "+id+ " not found");
        }
    }

    @Override
    public Set<Order> findByCustomerId(Long id) {

        Optional<Customer> byId = customerRepository.findById(id);
        if(byId.isPresent()){
            return orderRepository.findByCustomerId(id);
        }else{
            throw new ObjectNotFoundException("Customer by id= "+id+ " not found");
        }
    }

    @Override
    public void delete(Order byId) {
        orderRepository.delete(byId);
    }

    @Override
    public void save(Long customerId, Long restaurantId) {
        Optional<Customer> customerById = customerRepository.findById(customerId);
        Optional<Restaurant> restaurantById = restaurantRepository.findById(restaurantId);

        if(customerById.isPresent()){
            if(restaurantById.isPresent()){
                Order order= new Order(customerById.get(), restaurantById.get());
                orderRepository.save(order);
            }else{
                throw new ObjectNotFoundException("Restaurant by id= "+restaurantId+ " not found");
            }
        }else{
            throw new ObjectNotFoundException("Customer by id= "+customerId+ " not found");
        }
    }

}
