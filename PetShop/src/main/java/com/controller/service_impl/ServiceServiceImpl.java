package com.controller.service_impl;

import com.controller.repo.ServiceRepo;
import com.controller.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepo serviceRepo;
}
