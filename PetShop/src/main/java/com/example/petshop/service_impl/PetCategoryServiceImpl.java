package com.example.petshop.service_impl;

import com.example.petshop.repo.PetCategoryRepo;
import com.example.petshop.service.PetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetCategoryServiceImpl implements PetCategoryService {
    @Autowired
    private PetCategoryRepo petCategoryRepo;
}
