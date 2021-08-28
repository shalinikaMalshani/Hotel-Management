package com.example.RestaurantTest1.controller;

import com.example.RestaurantTest1.dto.CounterTableReservationDTO;
import com.example.RestaurantTest1.dto.FoodItemDTO;
import com.example.RestaurantTest1.dto.TableDTO;
import com.example.RestaurantTest1.service.TableService;
import com.example.RestaurantTest1.service.TableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    TableService tableService;

//    @GetMapping("/tableList")//Load Laundry Table
//    public String loginPage(Model model) {
//        model.addAttribute("tableList",tableService.displayTableList());
//
//       return "CounterTable";
//    }

    @GetMapping("/tableList")
    public String loadNewtableForm(Model model) {
        //TableDTO tableDTO=new TableDTO();
        //model.addAttribute("table", tableDTO);
        List<TableDTO> tableList= tableService.displayTableList();
        List<TableDTO> tableList2= tableService.displayTableTypeList();
        model.addAttribute("tableList",tableList);

        return "CounterTable";
    }

    @GetMapping("/table")
    public String loadTables(Model model) {
        model.addAttribute("reservationList",tableService.displayReservationList());
        return "Table";
    }

    @GetMapping("/newReservation")
    public String loadNewReservationForm(Model model) {
        CounterTableReservationDTO counterTableReservationDTO = new CounterTableReservationDTO();
        model.addAttribute("reservation", counterTableReservationDTO);
        model.addAttribute("tableList2",tableService.displayTableTypeList());
        return "Reservation";
    }

    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") CounterTableReservationDTO counterTableReservationDTO) {
//            try {
//                CounterTableReservationDTO counterTableReservationDTO1 = tableService.findHighestId();//find highest id to save
//                CounterTableReservationDTO counterTableReservationDTO2 = null;
//                try {
//                    counterTableReservationDTO1 = tableService.findResById(counterTableReservationDTO.getCounterTableReserveId());
//                }catch (NullPointerException d){
//                    int maxId = (counterTableReservationDTO2.getCounterTableReserveId());
//                    if (counterTableReservationDTO.getCounterTableReserveId()==(maxId)) {
//                        counterTableReservationDTO.setCounterTableReserveId((maxId));
//                    } else {
//                        maxId++;
//                        counterTableReservationDTO.setCounterTableReserveId((maxId));
//                    }
//                }
//            } catch (NullPointerException e){
//                counterTableReservationDTO.setCounterTableReserveId(1);//set 1 as initial round
//            }
//
//            tableService.saveReservation(counterTableReservationDTO);//save food item
//            return "redirect:/table";
//        }


        try {
            //find highest Id
            CounterTableReservationDTO top = tableService.findHighestId();
            int x = (top.getCounterTableReserveId()) + 1;
            counterTableReservationDTO.setCounterTableReserveId((x));
        } catch (NullPointerException e) {//If not found any Id

            counterTableReservationDTO.setCounterTableReserveId((1));
        }
        try {
            tableService.saveReservation(counterTableReservationDTO);//SAve
        } catch (NullPointerException d) {
            return "redirect:/saveReservation";
        }
        return "redirect:/table";
    }



    @PostMapping("/saveTable")
    public String addNewTable(@ModelAttribute ("table") TableDTO tableDTO){
        try {
            TableDTO tableDTO1 = tableService.findHighestTableId();//Find highest Id
            TableDTO tableDTO2 = null;
            try {
                tableDTO2 = tableService.findTableById(tableDTO.getTableId());//find One
            } catch (NullPointerException d) {
                int maxId = (tableDTO1.getTableId());
                if (tableDTO.getTableId() == (maxId)) {//Update
                    tableDTO.setTableId((maxId));
                } else {//New Table
                    maxId++;
                    tableDTO.setTableId((maxId));
                }
            }

        } catch (NullPointerException e) {//Initial Round
            tableDTO.setTableId(1);
        }


        tableService.saveTable(tableDTO);//Save Table
        return "redirect:/tableList";
    }

    @GetMapping(value="/deleteTable/{tableId}")
    public String deleteTable(@PathVariable("tableId") int tableId){
        tableService.deleteTable(tableId);
        return "redirect:/tableList";
    }



}



