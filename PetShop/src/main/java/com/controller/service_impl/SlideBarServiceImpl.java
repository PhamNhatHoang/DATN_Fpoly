package com.controller.service_impl;

import com.controller.repo.SlideBarRepo;
import com.controller.service.SlideBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlideBarServiceImpl implements SlideBarService {
    @Autowired
    private SlideBarRepo slideBarRepo;
}
