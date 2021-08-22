package com.example.RestaurantTest1.dto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantCounterOrderDTO {
    private int orderId;
    private String foodName;
    private int qty;

    private String dataValue;
    private int customerId;
    private int orderHolder;
    private List<RestaurantCounterOrderDTO> orderDetail=new ArrayList<>();

    public RestaurantCounterOrderDTO(){

    }

    public RestaurantCounterOrderDTO(int orderId, String foodName, int qty, String dataValue, List<RestaurantCounterOrderDTO> orderDetail,int orderHolder,int customerId) {
        this.orderId = orderId;
        this.foodName = foodName;
        this.qty = qty;
        this.dataValue = dataValue;
        this.orderDetail = orderDetail;
        this.orderHolder=orderHolder;
        this.customerId=customerId;

    }

    public RestaurantCounterOrderDTO(int orderId, String foodName, int qty, String dataValue, List<RestaurantCounterOrderDTO> orderDetail,int orderHolder) {
        this.orderId = orderId;
        this.foodName = foodName;
        this.qty = qty;
        this.dataValue = dataValue;
        this.orderDetail = orderDetail;
        this.orderHolder=orderHolder;


    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(int orderHolder) {
        this.orderHolder = orderHolder;
    }

    public RestaurantCounterOrderDTO(int orderId) {
        this.orderId=orderId;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public List<RestaurantCounterOrderDTO> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<RestaurantCounterOrderDTO> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "RestaurantCounterOrderDTO{" +
                "orderId=" + orderId +
                ", qty=" + qty+
                ", dataValue='" + dataValue + '\'' +
                ", orderDetail=" + orderDetail+
                '}';
    }
}
