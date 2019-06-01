package com.finalproject.demo.service;

import com.finalproject.demo.dao.UserDAO;
import com.finalproject.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void addUser(User user){
        userDAO.insertTable(user);
    }

}
