package com.example.RestaurantTest1.entity.CounterTableResevation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CounterTable {
    @Id
    private int tableId;
    private String tableType;
    private String tablePlace;

    public CounterTable() {
    }

    public CounterTable(int tableId, String tableType, String tablePlace) {
        this.tableId = tableId;
        this.tableType = tableType;
        this.tablePlace = tablePlace;
    }

    public CounterTable(int tableId, String tableType) {
        this.tableId = tableId;
        this.tableType = tableType;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getTablePlace() {
        return tablePlace;
    }

    public void setTablePlace(String tablePlace) {
        this.tablePlace = tablePlace;
    }
}
