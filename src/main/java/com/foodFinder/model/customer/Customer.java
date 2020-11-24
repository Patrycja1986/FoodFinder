package com.foodFinder.model.customer;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.order.Order;
import com.foodFinder.model.orderedMeals.OrderedMeal;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer extends BaseEntity {

    private String customerName;
    private  String customerSurname;
    private String customerStreetName;
    private String customerStreetNumber;
    private String customerPostCode;
    private String customerCity;
    private String customerEmail;

    @OneToMany(mappedBy = "customer")
    private Set<Order> customerOrders;

    public Customer() {
    }
    public Customer(String customerName,String customerSurname,String customerStreetName,
                    String customerStreetNumber, String customerPostCode, String customerCity, String customerEmail){
        this.customerName=customerName;
        this.customerSurname=customerSurname;
        this.customerStreetName=customerStreetName;
        this.customerStreetNumber=customerStreetNumber;
        this.customerPostCode=customerPostCode;
        this.customerCity=customerCity;
        this.customerEmail=customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerStreetName() {
        return customerStreetName;
    }

    public void setCustomerStreetName(String customerStreetName) {
        this.customerStreetName = customerStreetName;
    }

    public String getCustomerStreetNumber() {
        return customerStreetNumber;
    }

    public void setCustomerStreetNumber(String customerStreetNumber) {
        this.customerStreetNumber = customerStreetNumber;
    }

    public String getCustomerPostCode() {
        return customerPostCode;
    }

    public void setCustomerPostCode(String customerPostCode) {
        this.customerPostCode = customerPostCode;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Set<Order> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Set<Order> customerOrders) {
        this.customerOrders = customerOrders;
    }

}
