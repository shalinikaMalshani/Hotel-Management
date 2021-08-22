package com.example.RestaurantTest1.entity;

import javax.persistence.*;

@Entity
public class RestaurantCounterOrderDetail {

    @EmbeddedId
    private RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK;
    private int qty;
    private double unitPrice;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="restaurantCounterOrderPK",referencedColumnName = "orderId",insertable = false,updatable = false)
    private RestaurantCounterOrder restaurantCounterOrder;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="foodIdPK",referencedColumnName = "foodId",insertable = false,updatable = false)
    private FoodItem foodItem;

    public RestaurantCounterOrderDetail(){

    }
    public RestaurantCounterOrderDetail(RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK, int qty, double unitPrice) {
        this.restaurantCounterOrderDetailPK = restaurantCounterOrderDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public RestaurantCounterOrderDetail(int restaurantCounterOrderPK,int foodIdPK, int qty, double unitPrice) {
        this.restaurantCounterOrderDetailPK = new RestaurantCounterOrderDetailPK(foodIdPK,restaurantCounterOrderPK);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public RestaurantCounterOrderDetailPK getRestaurantCounterOrderDetailPK() {
        return restaurantCounterOrderDetailPK;
    }

    public void setRestaurantCounterOrderDetailPK(RestaurantCounterOrderDetailPK restaurantCounterOrderDetailPK) {
        this.restaurantCounterOrderDetailPK = restaurantCounterOrderDetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public RestaurantCounterOrder getRestaurantCounterOrder() {
        return restaurantCounterOrder;
    }

    public void setRestaurantCounterOrder(RestaurantCounterOrder restaurantCounterOrder) {
        this.restaurantCounterOrder = restaurantCounterOrder;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
