package com.foodFinder.service.customer;

import com.foodFinder.model.customer.Customer;
import com.foodFinder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);

    }

    @Override
    public Set<Customer> findAll() {
        Set<Customer> set = new HashSet<>();
        customerRepository.findAll().iterator().forEachRemaining(set::add);
        return set;
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
