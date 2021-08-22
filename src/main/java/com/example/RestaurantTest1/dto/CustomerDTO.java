package com.example.RestaurantTest1.dto;

public class CustomerDTO {
    private int customerId;
    private int age;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, int age) {
        this.customerId = customerId;
        this.age = age;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
