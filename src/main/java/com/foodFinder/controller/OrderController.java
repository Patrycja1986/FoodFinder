package com.foodFinder.controller;

import com.foodFinder.exceptions.MealsFromDifferentRestaurantsException;
import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.order.Order;
import com.foodFinder.model.order.OrderDTO;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.service.order.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
        orderService.save(orderDTO);
    }

    @PostMapping("/order/customer/{customerId}/restaurant/{restaurantId}")
    public void addOrder(@PathVariable Long customerId, @PathVariable Long restaurantId) {
        orderService.save(customerId, restaurantId);

    }
    @PostMapping("/order/customer/{customerId}")
    public void addOrder(@PathVariable Long customerId) {
        orderService.save(customerId);
    }

    @GetMapping("/order/{id}")
    public OrderDTO findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping
    public Set<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/restaurant/{id}")
    public Set<OrderDTO> findByRestaurantId(@PathVariable Long id) {
       return orderService.findByRestaurantId(id);
    }

    @GetMapping("/customer/{id}")
    public Set<OrderDTO> findByCustomerId(@PathVariable Long id) {
        return orderService.findByCustomerId(id);
    }

    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable Long id) {

        orderService.delete(id);
    }

}
