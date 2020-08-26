package com.foodFinder.model.order;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.orderedMeals.OrderedMeals;
import com.foodFinder.model.restaurant.Restaurant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

   /* @ManyToMany
    @JoinTable(name = "ordered_meals",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private Set<Meal> meals;*/

 /* @ManyToMany(mappedBy = "CustomerOrders")
    private Set<Customer> purchaser;*/

 /*  @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;*/

   @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

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

  /*  public Customer getCustomer() {
        return customer;
    }

    public void setPurchaser(Customer customer) {
        this.customer = customer;
    }*/

   /* public Set<Restaurant> getRestaurantOrders() {
        return restaurantOrders;
    }

    public void setRestaurantOrders(Set<Restaurant> restaurantOrders) {
        this.restaurantOrders = restaurantOrders;
    }*/

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
