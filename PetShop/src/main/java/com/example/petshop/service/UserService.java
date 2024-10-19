package com.example.petshop.service;
import com.example.petshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDetails findById(String username);
    User findByUsername(String name);
}
