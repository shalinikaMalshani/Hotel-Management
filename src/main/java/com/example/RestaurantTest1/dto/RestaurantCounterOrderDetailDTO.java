package com.example.RestaurantTest1.dto;

public class RestaurantCounterOrderDetailDTO {
    private int foodId;
    private int qty;
    private String name;
    private double unitPrice;

    public RestaurantCounterOrderDetailDTO() {
    }

    public RestaurantCounterOrderDetailDTO(int foodId, int qty, double unitPrice) {
        this.foodId = foodId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public RestaurantCounterOrderDetailDTO(int foodId, int qty, String name, double unitPrice) {
        this.foodId = foodId;
        this.qty = qty;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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
        return "RestaurantCounterOrderDetailDTO{" +
                "foodId='" + foodId + '\'' +
                ", qty=" + qty+
                ", unitPrice=" + unitPrice +
                '}';
    }
}
