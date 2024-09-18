package com.example.petshop.service_impl;

import com.example.petshop.repo.OrderPetDetailRepo;
import com.example.petshop.service.OrderPetDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPetDetailServiceImpl implements OrderPetDetailService {
    @Autowired
    private OrderPetDetailRepo orderPetDetailRepo;
}
