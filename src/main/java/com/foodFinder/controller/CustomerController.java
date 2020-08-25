package com.foodFinder.controller;

import com.foodFinder.model.customer.Customer;
import com.foodFinder.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping
    private void addCustomer(@RequestBody Customer customer) {

        customerService.save(customer);
    }
    @GetMapping("/customer/{id}")
    public Optional<Customer> findById(@PathVariable Long id){
        return customerService.findById(id);
    }
    @GetMapping
    public Set<Customer> findAll(){
        return customerService.findAll();
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id).orElse(new Customer("0", "0", "0",
                "0", "0", "0", "0"));
        customerService.delete(customer);
    }
}
