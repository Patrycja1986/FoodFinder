package com.foodFinder.service.customer;

import com.foodFinder.common.ConversionManager;
import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.customer.CustomerDTO;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(CustomerDTO customerDTO) throws ParseException {
        Customer customer = convertToEntity(customerDTO);
        customerRepository.save(customer);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()) {
            return byId
                    .map(this::convertToDto)
                    .orElseThrow(RuntimeException::new);
        } else {
            throw new ObjectNotFoundException("Customer by id= " + id + " not found");
        }
    }

    @Override
    public Set<CustomerDTO> findAll() {
        Set<Customer> set = new HashSet<>();
        customerRepository.findAll().iterator().forEachRemaining(set::add);
        return set.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @Override
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id).orElse(new Customer("0", "0", "0",
                "0", "0", "0", "0"));
        customerRepository.delete(customer);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO, Long id) {
        Optional<Customer> firstUpdateTry = customerRepository.findById(id);
        if (firstUpdateTry.isPresent()) {
            Customer customer1stTry=getCustomerDetails(customerDTO, firstUpdateTry);
            try{
                customerRepository.save(customer1stTry);
            }catch(ObjectOptimisticLockingFailureException ex){
               Optional<Customer> secondUpdateTry= customerRepository.findById(id);
               Customer customer2ndTry = getCustomerDetails(customerDTO, secondUpdateTry);
               customerRepository.save(customer2ndTry);
            }

        } else {
            throw new ObjectNotFoundException("Customer by id= " + id + " not found");
        }
    }

    private Customer getCustomerDetails(CustomerDTO customerDTO, Optional<Customer> firstUpdateTry) {
        Customer customer = firstUpdateTry.get();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerSurname(customerDTO.getCustomerSurname());
        customer.setCustomerStreetName(customerDTO.getCustomerStreetName());
        customer.setCustomerStreetNumber(customerDTO.getCustomerStreetNumber());
        customer.setCustomerPostCode(customerDTO.getCustomerPostCode());
        customer.setCustomerCity(customerDTO.getCustomerCity());
        customer.setCustomerEmail(customerDTO.getCustomerEmail());
        return customer;
    }

    private CustomerDTO convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer convertToEntity(CustomerDTO customerDTO) throws ParseException {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customer;
    }
}
