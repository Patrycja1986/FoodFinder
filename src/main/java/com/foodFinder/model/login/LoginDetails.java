package com.foodFinder.model.login;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LoginDetails extends BaseEntity {

    private String email;
    private char password;

@OneToOne
@JoinColumn(name = "customer_id")
    private Customer customer;

    public LoginDetails(){}
    public LoginDetails(String email,char password){
        this.email=email;
        this.password=password;
    }



}
