package com.example.petshop.service_impl;

import com.example.petshop.repo.PetHairRepo;
import com.example.petshop.service.PetHairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetHairServiceImpl implements PetHairService {
    @Autowired
    private PetHairRepo petHairRepo;
}
