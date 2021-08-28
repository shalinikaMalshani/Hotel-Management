package com.example.RestaurantTest1.service;

import com.example.RestaurantTest1.dao.RestaurantCounterOrderDAO;
import com.example.RestaurantTest1.dao.RestaurantCounterOrderDetailDAO;
import com.example.RestaurantTest1.dto.RestaurantCounterOrderDTO;
import com.example.RestaurantTest1.dto.RestaurantCounterOrderDetailDTO;
import com.example.RestaurantTest1.entity.RestaurantCounterOrder;
import com.example.RestaurantTest1.entity.RestaurantCounterOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantCounterOrderDAO restaurantCounterOrderDAO;

    @Autowired
    RestaurantCounterOrderDetailDAO restaurantCounterOrderDetailDAO;

    @Override
    public RestaurantCounterOrderDTO findTopByOrderByRestDesc() {
        RestaurantCounterOrder order=null;
        try {
            order = restaurantCounterOrderDAO.findTopByOrderByOrderIdDesc();
        }catch(Exception e){

        }
        return new RestaurantCounterOrderDTO(order.getOrderId());

    }

    @Transactional
    @Override
    public void saveCounterOrder(RestaurantCounterOrderDTO restaurantCounterOrderDTO) {
        java.util.List<RestaurantCounterOrderDetailDTO> list=new ArrayList<>();
        String arr= restaurantCounterOrderDTO.getDataValue();
        String yo[]=arr.split("");
        int count=0;
        RestaurantCounterOrderDetailDTO item=new RestaurantCounterOrderDetailDTO();
        for(String str:yo){
            if(count==0){
                item=new RestaurantCounterOrderDetailDTO();
                item.setFoodId(Integer.parseInt(str));
                count++;
            }else if(count==1){
                item.setUnitPrice(Double.parseDouble(str));
                count ++;
            }else if(count==2){
                item.setQty(Integer.parseInt(str));
                count=0;
            }
        }
        restaurantCounterOrderDAO.save(new RestaurantCounterOrder(
                restaurantCounterOrderDTO.getOrderId(), restaurantCounterOrderDTO.getQty(),restaurantCounterOrderDTO.getOrderHolder()));
        for(RestaurantCounterOrderDetailDTO orderDetail:list){
                restaurantCounterOrderDetailDAO.save(new RestaurantCounterOrderDetail(
                        restaurantCounterOrderDTO.getOrderId(), orderDetail.getFoodId(), orderDetail.getQty(), orderDetail.getUnitPrice()));
        }
    }
}
