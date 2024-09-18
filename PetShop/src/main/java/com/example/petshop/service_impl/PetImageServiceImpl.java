package com.example.petshop.service_impl;

import com.example.petshop.repo.PetImageRepo;
import com.example.petshop.service.PetImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetImageServiceImpl implements PetImageService {
    @Autowired
    private PetImageRepo petImageRepo;
}
