package com.foodFinder.model.order;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.meal.Meal;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order extends BaseEntity {

    /*@ManyToMany
    @JoinTable(name = "ordered_meals",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private Set<Meal> orderedMeals;*/

    @ManyToMany(mappedBy = "CustomerOrders")
    private Set<Customer> purchaser;

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

    public Set<Customer> getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(Set<Customer> purchaser) {
        this.purchaser = purchaser;
    }
}
