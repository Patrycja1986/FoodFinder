package com.foodFinder;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.repository.CustomerRepository;
import com.foodFinder.service.customer.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import java.text.ParseException;
import java.util.Optional;

@SpringBootTest
public class OptimisticLockingTest {

    @Autowired
    CustomerRepository repository;
    @Autowired
    CustomerService service;

    private Customer customer;
    private Long id;

    @BeforeEach
    public void init() {
        customer = repository.save(new Customer());
        id = customer.getId();
    }

    @AfterEach
    public void finish() {
        service.delete(id);
    }

    @Test
    public void shouldUpdate_withoutConcurrency() throws ParseException {
//checking if customers version=0
        Assertions.assertEquals(java.util.Optional.of(0L).get(), customer.getVersion());
        System.out.println(" ");

//getting customer from repository and updating the name, version should increment to 1
        Optional<Customer> byId = repository.findById(id);
        byId.get().setCustomerName("Patrycja");
        repository.save(byId.get());
//checking if update was succesful and version=1
        Optional<Customer> updatedCustomer = repository.findById(byId.get().getId());
        Assertions.assertEquals(1L, updatedCustomer.get().getVersion());
        Assertions.assertEquals("Patrycja", updatedCustomer.get().getCustomerName());
    }

    @Test
    void shouldUpdate_withOptimisticLockingHandling() throws InterruptedException {
        boolean thrown = false;
        //checking if customers version=0
        Assertions.assertEquals(java.util.Optional.of(0L).get(), customer.getVersion());
        try {
            // getting two customer object with the same id
            Optional<Customer> byId1 = repository.findById(id);
            Optional<Customer> byId2 = repository.findById(id);
            //updating customer name
            byId1.get().setCustomerName("Patrycja");
            byId2.get().setCustomerName("Pati");
            repository.save(byId1.get());
            repository.save(byId2.get());
        } catch (ObjectOptimisticLockingFailureException ex) {
    thrown=true;
        }
        Assertions.assertTrue(thrown);


    }
}
