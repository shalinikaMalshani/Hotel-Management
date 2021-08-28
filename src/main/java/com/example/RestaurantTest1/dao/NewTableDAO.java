package com.example.RestaurantTest1.dao;

import com.example.RestaurantTest1.entity.CounterTableResevation.CounterTable;
import org.springframework.data.repository.CrudRepository;

public interface NewTableDAO extends CrudRepository<CounterTable,Integer> {
    CounterTable findTopByOrderByTableIdDesc();
}
