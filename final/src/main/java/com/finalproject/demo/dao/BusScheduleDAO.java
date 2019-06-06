package com.finalproject.demo.dao;

import com.finalproject.demo.model.BusSchedule;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class BusScheduleDAO {
    @Autowired
    SessionFactory sessionFactory;

    public BusSchedule selectById(int id){
        return sessionFactory.getCurrentSession().get(BusSchedule.class, id);
    }

    public List<BusSchedule> selectAll(){
        return sessionFactory.getCurrentSession().createQuery("from " + BusSchedule.class.getName()).list();
    }

    public void insertSchedule(BusSchedule busSchedule){
        sessionFactory.getCurrentSession().save(busSchedule);
    }

    public void updateSchedule(BusSchedule busSchedule){
        sessionFactory.getCurrentSession().saveOrUpdate(busSchedule);
    }

    public void deleteSchedule(BusSchedule busSchedule){
        sessionFactory.getCurrentSession().delete(busSchedule);
    }
}
