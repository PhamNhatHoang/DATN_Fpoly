package com.example.petshop.service_impl;

import com.example.petshop.entity.Service;
import com.example.petshop.repo.ServiceRepo;
import com.example.petshop.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public List<Service> getAll() {
        return serviceRepo.findAll();
    }

    @Override
    public Optional<Service> getByServiceName(String serviceName) {
        return serviceRepo.findByServiceName(serviceName);
    }

    @Override
    public void saveService(Service service) {
        serviceRepo.save(service);
    }

    @Override
    public void deleteByServiceName(String serviceName) {
        serviceRepo.deleteByServiceName(serviceName);
    }
}
