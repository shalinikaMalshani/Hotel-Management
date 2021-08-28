package com.example.RestaurantTest1.service;

import com.example.RestaurantTest1.dto.CounterTableReservationDTO;
import com.example.RestaurantTest1.dto.FoodItemDTO;
import com.example.RestaurantTest1.dto.TableDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableService extends SuperService{
    void saveReservation(CounterTableReservationDTO counterTableReservationDTO);
    CounterTableReservationDTO findHighestId();
    TableDTO findHighestTableId();
    CounterTableReservationDTO findResById(int id);
    TableDTO findTableById(int tableId);
    void saveTable(TableDTO tableDTO);
    List<CounterTableReservationDTO> displayReservationList();
    List<TableDTO> displayTableList();

    List<TableDTO> displayTableTypeList();
    void deleteTable(int tableId);
}
