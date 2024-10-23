package com.example.petshop.rest;

import com.example.petshop.entity.Service;
import com.example.petshop.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/api/service")
@RestController
public class RestServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<Service> getAllServices() {
        return serviceService.getAll();
    }

    @GetMapping("/{serviceName}")
    public Optional<Service> getServiceByName(@PathVariable("serviceName") String serviceName) {
        return serviceService.getByServiceName(serviceName);
    }

    @PostMapping
    public void saveService(@RequestBody Service service) {
        serviceService.saveService(service);
    }

    @PutMapping("/{serviceName}")
    public void updateService(@PathVariable("serviceName") String serviceName, @RequestBody Service service) {
        service.setServiceName(serviceName);
        serviceService.saveService(service);
    }

    @DeleteMapping("/{serviceName}")
    public void deleteService(@PathVariable("serviceName") String serviceName) {
        serviceService.deleteByServiceName(serviceName);
    }
}
