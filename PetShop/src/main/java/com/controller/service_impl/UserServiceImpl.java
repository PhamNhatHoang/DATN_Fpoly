package com.controller.service_impl;

import com.controller.config.CustomUserDetails;
import com.controller.entity.User;
import com.controller.repo.UserRepo;
import com.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails findById(String username) {
        User user = userRepo.findByUsername(username);
        return new CustomUserDetails(user);
    }
}
