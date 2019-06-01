package com.finalproject.demo.service;

import com.finalproject.demo.model.AppUserDetails;
import com.finalproject.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LogInService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.selectUserByEmail(s);
        if (user == null) {
            return null;
        }
        AppUserDetails userDetail = new AppUserDetails(user);
        return userDetail;
    }
}
