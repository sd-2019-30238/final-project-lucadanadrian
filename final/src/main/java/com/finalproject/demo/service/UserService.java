package com.finalproject.demo.service;

import com.finalproject.demo.dao.UserDAO;
import com.finalproject.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.insertTable(user);
    }

    public User selectUserByEmail(String email){
        return userDAO.selectByEmail(email);
    }

}
