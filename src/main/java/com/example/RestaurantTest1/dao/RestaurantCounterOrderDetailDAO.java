package com.example.RestaurantTest1.dao;

import com.example.RestaurantTest1.entity.RestaurantCounterOrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCounterOrderDetailDAO extends CrudRepository<RestaurantCounterOrderDetail,Integer> {
}
