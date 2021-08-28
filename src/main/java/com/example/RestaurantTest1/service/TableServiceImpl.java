package com.example.RestaurantTest1.service;

import com.example.RestaurantTest1.dao.NewTableDAO;
import com.example.RestaurantTest1.dao.TableDAO;
import com.example.RestaurantTest1.dto.CounterTableReservationDTO;
import com.example.RestaurantTest1.dto.TableDTO;
import com.example.RestaurantTest1.entity.CounterTableResevation.CounterTableReservation;
import com.example.RestaurantTest1.entity.CounterTableResevation.CounterTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TableServiceImpl implements TableService{

    @Autowired
    TableDAO tableDAO;

    @Autowired
    NewTableDAO newTableDAO;

    @Override
    public void saveReservation(CounterTableReservationDTO counterTableReservationDTO) {
        tableDAO.save(new CounterTableReservation(counterTableReservationDTO.getCounterTableReserveId(), counterTableReservationDTO.getPlace(), counterTableReservationDTO.getType(),counterTableReservationDTO.getDate() ));
    }

    @Override
    public CounterTableReservationDTO findHighestId() {
        CounterTableReservation lastItem=null;
        try {
            lastItem = tableDAO.findTopByOrderByCounterTableReserveIdDesc();
        }catch(Exception e){

        }
        return new CounterTableReservationDTO(lastItem.getCounterTableReserveId());

    }

    @Override
    public TableDTO findHighestTableId() {
        CounterTable lastItem=null;
        try {
            lastItem = newTableDAO.findTopByOrderByTableIdDesc();
        }catch(Exception e){

        }
        return new TableDTO(lastItem.getTableId());

    }

    @Override
    public CounterTableReservationDTO findResById(int id) {
        CounterTableReservation counterTableReservation= tableDAO.findOne(id);
        CounterTableReservationDTO counterTableReservationDTO=new CounterTableReservationDTO(counterTableReservation.getCounterTableReserveId(), counterTableReservation.getPlace(), counterTableReservation.getType(), counterTableReservation.getDate());
        return counterTableReservationDTO ;
    }

    @Override
    public TableDTO findTableById(int tableId) {
        CounterTable table=newTableDAO.findOne(tableId);
        TableDTO tableDTO=new TableDTO(table.getTableId(), table.getTableType(), table.getTablePlace());
        return tableDTO;
    }

    @Override
    public void saveTable(TableDTO tableDTO) {
       newTableDAO.save(new CounterTable(tableDTO.getTableId(), tableDTO.getTableType(),tableDTO.getTablePlace())) ;
    }

    @Override
    public List<CounterTableReservationDTO> displayReservationList() {
        Iterable<CounterTableReservation> reservations= tableDAO.findAll();
        List<CounterTableReservationDTO> reservationDTOList=new ArrayList<>();
        for(CounterTableReservation item:reservations){
            reservationDTOList.add(new CounterTableReservationDTO(item.getCounterTableReserveId(),item.getPlace(),item.getType(),item.getDate()));
        }
        return reservationDTOList;

    }

    @Override
    public List<TableDTO> displayTableList() {
        Iterable<CounterTable> tables= newTableDAO.findAll();
        List<TableDTO> tableDTOList=new ArrayList<>();
        for(CounterTable item:tables){
            tableDTOList.add(new TableDTO(item.getTableId(),item.getTableType(),item.getTablePlace()));
        }
        return tableDTOList;

    }

    @Override
    public List<TableDTO> displayTableTypeList() {
        Iterable<CounterTable> tableTypes= newTableDAO.findAll();
        List<TableDTO> tableDTOList=new ArrayList<>();
        for(CounterTable item:tableTypes){
            tableDTOList.add(new TableDTO(item.getTableId(),item.getTableType()));
        }
        return tableDTOList;

    }

    //delete table
    @Override
    public void deleteTable(int tableId) {
        newTableDAO.delete(tableId);
    }
}
