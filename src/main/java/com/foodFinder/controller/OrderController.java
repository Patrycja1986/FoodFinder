package com.foodFinder.controller;

import com.foodFinder.model.order.Order;
import com.foodFinder.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
     this.orderService=orderService;
    }


    @PostMapping
    public void addOrder(@RequestBody Order order){
       orderService.save(order);
    }

    @GetMapping("/order/{id}")
    public Optional<Order> findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @GetMapping
    public Set<Order> findAll(){
        return orderService.findAll();
    }
    @GetMapping("/restaurant/{id}")
    public Set<Order> findByRestaurantId(@PathVariable Long id){
        return orderService.findByRestaurantId(id);
    }
}
