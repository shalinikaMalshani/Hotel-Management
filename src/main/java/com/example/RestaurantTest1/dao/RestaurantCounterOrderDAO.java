package com.example.RestaurantTest1.dao;

import com.example.RestaurantTest1.dto.RestaurantCounterOrderDTO;
import com.example.RestaurantTest1.entity.RestaurantCounterOrder;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCounterOrderDAO extends CrudRepository<RestaurantCounterOrder,Integer> {
    RestaurantCounterOrder findTopByOrderByOrderIdDesc();
}
