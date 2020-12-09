package com.foodFinder;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest

public class OptimisticLockingTest {

    @Autowired
    CustomerRepository repository;

@Test
    public void shouldUpdate_withoutConcurrency(){
        Customer save= repository.save(new Customer());
        Assert.assertEquals(java.util.Optional.of(0L),save.getVersion());
    }
}

