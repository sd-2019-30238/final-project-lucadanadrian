package com.finalproject.demo.dao;

import com.finalproject.demo.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public User selectById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public User selectByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from " + User.class.getName() + " u where u.email =:email").setParameter("email", email).getSingleResult();
    }

    public List<User> selectAll() {
        return (List<User>) sessionFactory.getCurrentSession().createSQLQuery("Select * from user").addEntity(User.class).list();
    }

    public void insertTable(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateTable(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public void deleteFromTable(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("Delete from user where user_id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
