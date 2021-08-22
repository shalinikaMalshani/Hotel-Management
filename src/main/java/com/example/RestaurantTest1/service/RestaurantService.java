package com.example.RestaurantTest1.service;

import com.example.RestaurantTest1.dto.RestaurantCounterOrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantService {
    RestaurantCounterOrderDTO findTopByOrderByRestDesc();
    void saveCounterOrder(RestaurantCounterOrderDTO restaurantCounterOrderDTO);
}
