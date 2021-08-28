package com.example.RestaurantTest1.dao;

import com.example.RestaurantTest1.entity.CounterTableResevation.CounterTableReservation;
import org.springframework.data.repository.CrudRepository;

public interface TableDAO extends CrudRepository<CounterTableReservation,Integer> {
    CounterTableReservation findTopByOrderByCounterTableReserveIdDesc();

}
