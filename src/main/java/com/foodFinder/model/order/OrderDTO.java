package com.foodFinder.model.order;

import com.foodFinder.model.customer.CustomerDTO;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;
import com.foodFinder.model.restaurant.RestaurantDTO;

import java.util.Set;

public class OrderDTO {
private Long id;
private Long version;
    private CustomerDTO customer;
    private RestaurantDTO restaurant;
    private Set<OrderedMealDTO> meals;

    public Long getVersion() {
        return version;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    public Set<OrderedMealDTO> getMeals() {
        return meals;
    }

    public void setMeals(Set<OrderedMealDTO> meals) {
        this.meals = meals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
