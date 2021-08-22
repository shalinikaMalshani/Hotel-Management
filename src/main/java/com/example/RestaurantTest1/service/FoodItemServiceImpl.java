package com.example.RestaurantTest1.service;

import com.example.RestaurantTest1.dao.FoodItemDAO;
import com.example.RestaurantTest1.dto.FoodItemDTO;
import com.example.RestaurantTest1.entity.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class FoodItemServiceImpl implements  FoodItemService{
    @Autowired
    FoodItemDAO foodItemDAO;

    //save food items to the database
    @Override
    public void saveFoodItem(FoodItemDTO foodItemDTO) {
        foodItemDAO.save(new FoodItem(foodItemDTO.getFoodId(), foodItemDTO.getName(), foodItemDTO.getUnitPrice()));
    }

    //get all food items from database
    @Override
    public List<FoodItemDTO> displayList() {
        Iterable<FoodItem> foodItems=foodItemDAO.findAll();
        List<FoodItemDTO> foodItemDTOList=new ArrayList<>();
        for(FoodItem item:foodItems){
            foodItemDTOList.add(new FoodItemDTO(item.getFoodId(),item.getName(),item.getUnitPrice()));
        }
    return foodItemDTOList;
    }

    @Override
    public FoodItemDTO findHighestId() {
        FoodItem lastItem=null;
        try {
            lastItem = foodItemDAO.findTopByOrderByFoodIdDesc();
        }catch(Exception e){

        }
        return new FoodItemDTO(lastItem.getFoodId());

    }

    @Override
    public FoodItemDTO findFoodById(int foodId) {
        FoodItem foodItem= foodItemDAO.findOne(foodId);
        FoodItemDTO foodItemDTO=new FoodItemDTO(foodItem.getFoodId(),foodItem.getName(),foodItem.getUnitPrice());
        return foodItemDTO ;
    }


}
