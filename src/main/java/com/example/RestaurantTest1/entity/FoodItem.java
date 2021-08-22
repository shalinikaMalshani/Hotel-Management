package com.example.RestaurantTest1.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodItem {

    @Id
    private int foodId;
    private String name;
    private double unitPrice;
    @OneToMany(mappedBy = "foodItem" , cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private List<RestaurantCounterOrderDetail> restaurantCounterOrderDetailList=new ArrayList<>();

    public FoodItem(){

    }

    public FoodItem(int foodId, String foodName, double unitPrice) {
        this.foodId = foodId;
        this.name = foodName;
        this.unitPrice = unitPrice;
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

    public void setName(String foodName) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
