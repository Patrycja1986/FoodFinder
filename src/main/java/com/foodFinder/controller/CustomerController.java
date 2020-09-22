package com.foodFinder.controller;

import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.customer.CustomerDTO;
import com.foodFinder.service.customer.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    private void addCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        customerService.save(customerDTO);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
        customerService.updateCustomer(customerDTO, id);
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    public Set<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }

}
