package com.finalproject.demo.service;

import com.finalproject.demo.dao.BusScheduleDAO;
import com.finalproject.demo.model.BusSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BusScheduleService {
    @Autowired
    private BusScheduleDAO busScheduleDAO;

    public void addSchedule(BusSchedule busSchedule) {
        busScheduleDAO.insertSchedule(busSchedule);
    }

    public List<BusSchedule> seeBusSchedules() {
        return busScheduleDAO.selectAll();
    }

    public void deleteSchedule(int id) {
        BusSchedule busSchedule = busScheduleDAO.selectById(id);
        busScheduleDAO.deleteSchedule(busSchedule);
    }

    public List<BusSchedule> selectBusLine(String line){
        return busScheduleDAO.selectByLine(line);
    }

    public List<BusSchedule> selectByType(String type){
        return busScheduleDAO.selectByType(type);
    }
}
