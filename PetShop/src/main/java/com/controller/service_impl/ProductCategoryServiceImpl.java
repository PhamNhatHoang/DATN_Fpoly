package com.controller.service_impl;

import com.controller.repo.ProductCategoryRepo;
import com.controller.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
}
