package com.example.petshop.service;
import com.example.petshop.entity.User;
>>>>>>> 1ca2bf2910c223089592b9fb43660604cf8a1054
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDetails findById(String username);
    User findByUsername(String name);
}
