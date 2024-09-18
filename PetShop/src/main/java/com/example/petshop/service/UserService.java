package com.example.petshop.service;

import com.example.petshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    UserDetails findById(String username);
}
