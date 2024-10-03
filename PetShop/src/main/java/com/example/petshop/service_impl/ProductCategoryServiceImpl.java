package com.example.petshop.service_impl;

import com.example.petshop.repo.ProductCategoryRepo;
import com.example.petshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
}
