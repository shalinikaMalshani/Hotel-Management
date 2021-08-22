package com.example.RestaurantTest1.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RestaurantCounterOrderDetailPK implements Serializable {
    private int foodIdPK;
    private int restaurantCounterOrderPK;

    public RestaurantCounterOrderDetailPK(){

    }

    public RestaurantCounterOrderDetailPK(int foodIdPK, int restaurantCounterOrderPK) {
        this.foodIdPK = foodIdPK;
        this.restaurantCounterOrderPK = restaurantCounterOrderPK;
    }

    public int getFoodIdPK() {
        return foodIdPK;
    }

    public void setFoodIdPK(int foodId) {
        this.foodIdPK = foodIdPK;
    }

    public int getRestaurantCounterOrderPKId() {
        return restaurantCounterOrderPK;
    }

    public void setRestaurantCounterOrderPKId(int restaurantCounterOrderId) {
        this.restaurantCounterOrderPK = restaurantCounterOrderId;
    }

    @Override
    public String toString() {
        return "RestaurantCounterOrderDetailPK{" +
                "foodIdPK='" + foodIdPK + '\'' +
                ", restaurantCounterOrderPK='" + restaurantCounterOrderPK + '\'' +
                '}';
    }
}
