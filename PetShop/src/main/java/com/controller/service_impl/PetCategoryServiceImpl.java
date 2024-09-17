package com.controller.service_impl;

import com.controller.service.PetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetCategoryServiceImpl implements PetCategoryService {
    @Autowired
    private PetCategoryService petCategoryService;
}
