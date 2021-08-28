package com.example.RestaurantTest1.dao;

import com.example.RestaurantTest1.dto.FoodItemDTO;
import com.example.RestaurantTest1.entity.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemDAO extends CrudRepository<FoodItem,Integer> {
    FoodItem findTopByOrderByFoodIdDesc();
}
