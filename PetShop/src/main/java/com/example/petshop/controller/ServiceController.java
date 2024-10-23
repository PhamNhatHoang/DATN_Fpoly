package com.example.petshop.controller;

import com.example.petshop.entity.Service;
import com.example.petshop.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;
    @GetMapping("/service/detail/{serviceName}")
    public String getServiceDetail(@PathVariable("serviceName") String serviceName, Model model) {
        List<Service> services = serviceService.getAll();
        List<Service> limitedServices = services.stream()
                .limit(6)
                .collect(Collectors.toList());
        
        // Fetching detailed service information
        Service detailService = serviceService.getByServiceName(serviceName)
                .orElse(null); // Handle if service not found

        model.addAttribute("services", limitedServices);
        model.addAttribute("detailService", detailService);

        return "_service"; // Return the name of your Thymeleaf template without .html
    }

}
