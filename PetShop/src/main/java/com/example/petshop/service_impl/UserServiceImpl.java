package com.example.petshop.service_impl;


import com.example.petshop.config.CustomUserDetails;
import com.example.petshop.entity.User;
import com.example.petshop.repo.UserRepo;
import com.example.petshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
        if (user == null) {
            return null;
        }
        return new CustomUserDetails(user);
    }
}
