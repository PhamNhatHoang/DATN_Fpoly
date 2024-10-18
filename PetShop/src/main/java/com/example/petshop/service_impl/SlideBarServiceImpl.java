package com.example.petshop.service_impl;


import com.example.petshop.entity.SliderBar;
import com.example.petshop.repo.SlideBarRepo;
import com.example.petshop.service.SlideBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SlideBarServiceImpl implements SlideBarService {
    @Autowired
    private SlideBarRepo slideBarRepo;

    @Override
    public List<SliderBar> getAll() {
        return slideBarRepo.findAll();
    }
}
