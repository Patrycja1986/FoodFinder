package com.foodFinder.model.order;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.orderedMeals.OrderedMeals;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order extends BaseEntity {

   /* @ManyToMany
    @JoinTable(name = "ordered_meals",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private Set<Meal> meals;*/

 /* @ManyToMany(mappedBy = "CustomerOrders")
    private Set<Customer> purchaser;*/

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderedMeals> orderedMeals;


    public Order() {
    }

    public Set<OrderedMeals> getOrderedMeals() {
        return orderedMeals;
    }

    public void setOrderedMeals(Set<OrderedMeals> orderedMeals) {
        this.orderedMeals = orderedMeals;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setPurchaser(Customer customer) {
        this.customer = customer;
    }
}
