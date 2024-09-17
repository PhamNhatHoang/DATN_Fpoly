package com.controller.service_impl;

import com.controller.service.PetImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetImageServiceImpl implements PetImageService {
    @Autowired
    private PetImageService petImageService;
}
