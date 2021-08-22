package com.example.RestaurantTest1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantCounterOrder {
    @Id
    private int orderId;
    private int qty;
    private int orderHolder;
    @OneToMany(mappedBy = "restaurantCounterOrder",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<RestaurantCounterOrderDetail> orderDetail=new ArrayList<>();

    public RestaurantCounterOrder(){

    }
    public RestaurantCounterOrder(int orderId, int qty,int orderHolder) {
        this.orderId = orderId;
        this.qty = qty;
        this.orderHolder=orderHolder;

    }

    public RestaurantCounterOrder(int orderId, int qty, List<RestaurantCounterOrderDetail> orderDetail,int orderHolder) {
        this.orderId = orderId;
        this.qty = qty;
        this.orderDetail = orderDetail;
        this.orderHolder=orderHolder;
    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(int orderHolder) {
        this.orderHolder = orderHolder;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<RestaurantCounterOrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<RestaurantCounterOrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }


}
