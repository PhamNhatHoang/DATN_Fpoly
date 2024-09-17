package com.controller.service_impl;

import com.controller.repo.AuthorityRepo;
import com.controller.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepo authorityRepo;
}
