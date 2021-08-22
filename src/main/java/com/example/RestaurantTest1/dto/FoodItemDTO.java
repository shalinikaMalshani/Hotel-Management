package com.example.RestaurantTest1.dto;

import java.io.Serializable;

public class FoodItemDTO implements Serializable {
    private int foodId;
    private String name;
    private double unitPrice;

    public FoodItemDTO(){

    }

    public FoodItemDTO(int foodId, String name, double unitPrice) {
        this.foodId = foodId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public FoodItemDTO(int foodId) {
        this.foodId=foodId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "FoodItemDTO{" +
                "foodId='" + foodId + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
