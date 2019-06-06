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

    public ValidationCode selectByCode(String code){
        return (ValidationCode) sessionFactory.getCurrentSession().createQuery("from " + ValidationCode.class.getName() + " u where u.code_ticket =:code").setParameter("code", code).getSingleResult();
    }

    public List<ValidationCode> selectAll() {
        return (List<ValidationCode>) sessionFactory.getCurrentSession().createSQLQuery("Select * from validationcode").addEntity(ValidationCode.class).list();
    }

    public void insertTable(ValidationCode validationCode){
        sessionFactory.getCurrentSession().save(validationCode);
    }

    public void deleteFromTable(int id){
        sessionFactory.getCurrentSession().createSQLQuery("Delete from validationcode where code_id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
