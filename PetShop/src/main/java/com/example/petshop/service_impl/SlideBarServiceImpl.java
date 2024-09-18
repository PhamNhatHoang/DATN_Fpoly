package com.example.petshop.service_impl;

import com.example.petshop.repo.SlideBarRepo;
import com.example.petshop.service.SlideBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlideBarServiceImpl implements SlideBarService {
    @Autowired
    private SlideBarRepo slideBarRepo;
}
