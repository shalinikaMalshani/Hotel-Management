package com.example.RestaurantTest1.controller;

import com.example.RestaurantTest1.dto.FoodItemDTO;
import com.example.RestaurantTest1.dto.RestaurantCounterOrderDTO;
import com.example.RestaurantTest1.dto.RestaurantCounterOrderDetailDTO;
import com.example.RestaurantTest1.service.FoodItemService;
import com.example.RestaurantTest1.service.FoodItemServiceImpl;
import com.example.RestaurantTest1.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurnatController {

    @Autowired
    FoodItemService foodItemService;
    @Autowired
    RestaurantService restaurantService;

    //display all the food items
    @GetMapping("/displayAll")
    public String displayAll(Model model){
        model.addAttribute("foodItemList",foodItemService.displayList());
        return "ResturantOrder";
    }

    //load food item form
    @GetMapping("/loadForm")
    public String loadFoodItemForm(Model model) {
        //create model to add form data
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        model.addAttribute("foodItems", foodItemDTO);
        return "FoodItemForm";
    }

    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute ("foodItems") FoodItemDTO foodItemDTO){
        try {
            FoodItemDTO foodItemDTO2 = foodItemService.findHighestId();//find highest id to save
            FoodItemDTO foodItemDTO1 = null;
            try {
                foodItemDTO1 = foodItemService.findFoodById(foodItemDTO.getFoodId());
            }catch (NullPointerException d){
                int maxId = (foodItemDTO2.getFoodId());
                if (foodItemDTO.getFoodId()==(maxId)) {
                    foodItemDTO.setFoodId((maxId));
                } else {
                    maxId++;
                    foodItemDTO.setFoodId((maxId));
                }
            }
        } catch (NullPointerException e){
            foodItemDTO.setFoodId(1);//set 1 as initial round
        }

        foodItemService.saveFoodItem(foodItemDTO);//save food item
        return "redirect:/displayAll";
    }
    @PostMapping("invoice")
    public String createInvoice(@ModelAttribute ("restaurantCounterOrderDTO") RestaurantCounterOrderDTO restaurantCounterOrderDTO,
                                Model model, HttpServletRequest request){
       try {
           RestaurantCounterOrderDTO top = restaurantService.findTopByOrderByRestDesc();//find highest Id to save order
           int x = (top.getOrderId()) + 1;
           restaurantCounterOrderDTO.setOrderId(x);
       }catch(NullPointerException e) {
           restaurantCounterOrderDTO.setOrderId(1);//set 1 as initial round
       }
        try {
            restaurantService.saveCounterOrder(restaurantCounterOrderDTO);

            java.util.List<RestaurantCounterOrderDetailDTO> list = new ArrayList<>();
            String arr = restaurantCounterOrderDTO.getDataValue();
            String yo[] = arr.split(" ");
            int count = 0;
            RestaurantCounterOrderDetailDTO itm = new RestaurantCounterOrderDetailDTO();
            for (String str : yo) {//Read String and add to list
                if (count == 0) {
                    itm = new RestaurantCounterOrderDetailDTO();
                    itm.setFoodId(Integer.parseInt(str));
                    count++;

                } else if (count == 1) {
                    itm.setUnitPrice(Double.parseDouble(str));
                    count++;

                } else if (count == 2) {
                    itm.setQty(Integer.parseInt(str));
                    list.add(itm);
                    count = 0;
                }
            }

            for (RestaurantCounterOrderDetailDTO d : list) {
                FoodItemDTO f = foodItemService.findFoodById(d.getFoodId());
                d.setName(f.getName());
            }

            model.addAttribute("listCounterOrders", restaurantCounterOrderDTO.getOrderId());
            model.addAttribute("listCounterOrderDetails", list);//Load Data to Payment

        } catch (Exception e) {
            System.out.print("Exception:"+e.getStackTrace());
        }
        return "invoice";
    }
    }


