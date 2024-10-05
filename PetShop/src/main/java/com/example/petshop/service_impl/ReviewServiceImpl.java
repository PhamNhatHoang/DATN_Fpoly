package com.example.petshop.service_impl;

import com.example.petshop.repo.ReviewRepo;
import com.example.petshop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
}
