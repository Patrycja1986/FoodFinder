package com.foodFinder.model.userLoginDetails;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserLoginDetails extends BaseEntity {
    private boolean active;
    private String password;
    private String role;
    private String userName;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public UserLoginDetails() {
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
