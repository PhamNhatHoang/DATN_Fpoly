package com.example.petshop.service;

import com.example.petshop.entity.SliderBar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SlideBarService {
    List<SliderBar> getAll();
}
