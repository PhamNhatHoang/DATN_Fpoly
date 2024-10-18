package com.example.petshop.service_impl;

<<<<<<< HEAD

import java.util.List;
import java.util.stream.Collectors;

import com.example.petshop.entity.Authority;
import com.example.petshop.entity.DTO.AuthorityDTO;
=======
import com.example.petshop.entity.Authority;
>>>>>>> 1ca2bf2910c223089592b9fb43660604cf8a1054
import com.example.petshop.repo.AuthorityRepo;
import com.example.petshop.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepo authorityRepo;

    @Override
    public List<Authority> findAll() {
        return authorityRepo.findAll();
    }
}
