package com.foodFinder.service.customer;

import com.foodFinder.model.customer.Customer;

import java.util.Optional;
import java.util.Set;

public interface CustomerService {
    void save(Customer customer);

    Optional<Customer> findById(Long id);

    Set<Customer> findAll();

    void delete(Customer customer);
}
