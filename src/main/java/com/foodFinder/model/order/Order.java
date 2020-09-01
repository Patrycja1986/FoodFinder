package com.foodFinder.model.order;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.restaurant.Restaurant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderedMeal> orderedMeals;

    public Order() {
    }
public Order(Customer customer,Restaurant restaurant){
        this.customer=customer;
        this.restaurant=restaurant;
}
    public Set<OrderedMeal> getOrderedMeals() {
        return orderedMeals;
    }

    public void setOrderedMeals(Set<OrderedMeal> orderedMeals) {
        this.orderedMeals = orderedMeals;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
