package com.controller.service_impl;

import com.controller.repo.PetHairRepo;
import com.controller.service.PetHairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetHairServiceImpl implements PetHairService {
    @Autowired
    private PetHairRepo petHairRepo;
}