package com.example.RestaurantTest1.entity.CounterTableResevation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CounterTableReservation {
    @Id
    private int counterTableReserveId;
    private String place;
    private String type;
    private Date date;

//    @OneToMany(mappedBy = "counterTableReservation", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
//    private List<CounterTableReservationDetails> orderDetails = new ArrayList<>();


    public CounterTableReservation() {
    }

    public CounterTableReservation(int counterTableReserveId, String place, String type, Date date) {
        this.counterTableReserveId = counterTableReserveId;
        this.place = place;
        this.type = type;
        this.date = date;
    }

    public int getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(int counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}