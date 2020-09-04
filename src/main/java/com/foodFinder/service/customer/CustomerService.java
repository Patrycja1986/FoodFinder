package com.foodFinder.service.customer;

import com.foodFinder.common.ConversionManager;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.customer.CustomerDTO;

import java.text.ParseException;
import java.util.Set;

public interface CustomerService {
    void save(CustomerDTO customer) throws ParseException;

    CustomerDTO findById(Long id);

    Set<CustomerDTO> findAll();

    void delete(Long customer);

    void updateCustomer(CustomerDTO customerDTO, Long id);
}
