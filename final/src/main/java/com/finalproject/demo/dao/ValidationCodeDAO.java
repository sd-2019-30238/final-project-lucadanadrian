package com.finalproject.demo.dao;

import com.finalproject.demo.model.ValidationCode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationCodeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public ValidationCode selectById(int id) {
        return sessionFactory.getCurrentSession().get(ValidationCode.class, id);
    }

    public List<ValidationCode> selectByCode(String code){
        return  sessionFactory.getCurrentSession().createSQLQuery("Select * from validationcode where code_ticket= '" + code+"'").addEntity(ValidationCode.class).list();
    }

    public List<ValidationCode> selectAll() {
        return (List<ValidationCode>) sessionFactory.getCurrentSession().createSQLQuery("Select * from validationcode").addEntity(ValidationCode.class).list();
    }


    public void insertTable(ValidationCode validationCode){
        sessionFactory.getCurrentSession().save(validationCode);
    }

    public void updateTable(ValidationCode validationCode){
        sessionFactory.getCurrentSession().saveOrUpdate(validationCode);
    }

    public void deleteFromTable(int id){
        sessionFactory.getCurrentSession().createSQLQuery("Delete from validationcode where code_id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
