package com.example.petshop.service;

import com.example.petshop.entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<Service> getAll();
    Optional<Service> getByServiceName(String serviceName);
    void saveService(Service service);
    void deleteByServiceName(String serviceName);
}
