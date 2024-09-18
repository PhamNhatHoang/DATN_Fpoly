package com.example.petshop.service_impl;

import com.example.petshop.repo.RatingRepo;
import com.example.petshop.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
}
