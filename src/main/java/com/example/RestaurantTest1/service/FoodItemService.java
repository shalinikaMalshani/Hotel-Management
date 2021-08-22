package com.example.RestaurantTest1.service;

import com.example.RestaurantTest1.dto.FoodItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodItemService extends SuperService {
    void saveFoodItem(FoodItemDTO foodItemDTO);
    List<FoodItemDTO> displayList();
    FoodItemDTO findHighestId();
    FoodItemDTO findFoodById(int foodId);
}
