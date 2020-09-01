package com.foodFinder.controller;

import com.foodFinder.exceptions.restaurant.ObjectNotFoundException;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.customer.CustomerDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;
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
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping
    private void addCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        Customer customer = convertToEntity(customerDTO);
        customerService.save(customer);
    }
    @PutMapping("/customer/{id}")
    public void updateRestaurant(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {

        Optional<Customer> byId = customerService.findById(id);
        if (byId.isPresent()) {
            Customer customer = byId.get();
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerSurname(customerDTO.getCustomerSurname());
            customer.setCustomerStreetName(customerDTO.getCustomerStreetName());
            customer.setCustomerStreetNumber(customerDTO.getCustomerStreetNumber());
            customer.setCustomerPostCode(customerDTO.getCustomerPostCode());
            customer.setCustomerCity(customerDTO.getCustomerCity());
            customer.setCustomerEmail(customerDTO.getCustomerEmail());
            customerService.save(customer);

        } else {
            throw new ObjectNotFoundException("Customer by id= " + id + " not found");
        }}

        @GetMapping("/customer/{id}")
    public CustomerDTO findById(@PathVariable Long id){
            Optional<Customer> byId = customerService.findById(id);
            if (byId.isPresent()) {
                return byId
                        .map(this::convertToDto)
                        .orElseThrow(RuntimeException::new);
            } else {
                throw new ObjectNotFoundException("Customer by id= " + id + " not found");
            }
    }

    @GetMapping
    public Set<CustomerDTO> findAll(){
        Set<Customer> all = customerService.findAll();
        return all.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id).orElse(new Customer("0", "0", "0",
                "0", "0", "0", "0"));
        customerService.delete(customer);
    }

    private CustomerDTO convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer convertToEntity(CustomerDTO customerDTO) throws ParseException {
        return modelMapper.map(customerDTO, Customer.class);
    }
}
