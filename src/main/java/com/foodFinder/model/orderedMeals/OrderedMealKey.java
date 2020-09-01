package com.foodFinder.model.orderedMeals;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderedMealKey implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "meal_id")
    private Long mealId;

    public OrderedMealKey() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }
}
