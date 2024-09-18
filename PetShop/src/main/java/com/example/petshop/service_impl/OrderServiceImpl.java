package com.example.petshop.service_impl;

import com.example.petshop.repo.OrderRepo;
import com.example.petshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
}
