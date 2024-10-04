package com.example.petshop.service_impl;

import com.example.petshop.repo.PetRepo;
import com.example.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepo petRepo;
}
