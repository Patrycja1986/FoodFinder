package com.foodFinder.controller;

import com.foodFinder.model.order.Order;
import com.foodFinder.model.order.OrderDTO;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;
import com.foodFinder.service.order.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void addOrder(@RequestBody OrderDTO orderDTO) throws ParseException {
        Order order = convertToEntity(orderDTO);
        orderService.save(order);
    }

    @PostMapping("/order/{customerId}/{restaurantId}")
    public void addOrder(@PathVariable Long customerId, @PathVariable Long restaurantId){
        orderService.save(customerId,restaurantId);

    }

    @GetMapping("/order/{id}")
    public Optional<Order> findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping
    public Set<OrderDTO> findAll() {
        Set<Order> all = orderService.findAll();
        return all.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @GetMapping("/restaurant/{id}")
    public Set<Order> findByRestaurantId(@PathVariable Long id) {
        return orderService.findByRestaurantId(id);
    }

    @GetMapping("/customer/{id}")
    public Set<Order> findByCustomerId(@PathVariable Long id) {
        return orderService.findByCustomerId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Order byId = orderService.findById(id)
                .orElse(new Order());
       orderService.delete(byId);
    }

    private OrderDTO convertToDto(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private Order convertToEntity(OrderDTO orderDTO) throws ParseException {
        return modelMapper.map(orderDTO, Order.class);
    }

}
