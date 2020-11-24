package com.foodFinder;

import com.foodFinder.model.customer.Customer;
import com.foodFinder.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
public class OptimisticLockingTest {

    @Autowired
    CustomerRepository repository;

@Test
   public void shouldUpdate_withoutConcurrency(){
       Customer save = repository.save(new Customer());
      Assertions.assertEquals(java.util.Optional.of(0L),save.getVersion());
   }

}
