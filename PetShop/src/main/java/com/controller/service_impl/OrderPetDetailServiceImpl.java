package com.controller.service_impl;

import com.controller.repo.OrderPetDetailRepo;
import com.controller.service.OrderPetDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPetDetailServiceImpl implements OrderPetDetailService {
    @Autowired
    private OrderPetDetailRepo orderPetDetailRepo;
}
