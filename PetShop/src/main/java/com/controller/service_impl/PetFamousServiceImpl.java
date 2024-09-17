package com.controller.service_impl;

import com.controller.service.PetFamousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetFamousServiceImpl implements PetFamousService {
    @Autowired
    private PetFamousService petFamousService;
}
