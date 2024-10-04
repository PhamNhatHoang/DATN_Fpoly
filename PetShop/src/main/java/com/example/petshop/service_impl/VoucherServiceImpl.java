package com.example.petshop.service_impl;

import com.example.petshop.repo.VoucherRepo;
import com.example.petshop.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepo voucherRepo;
}
