package com.example.petshop.service;

import com.example.petshop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAll();
<<<<<<< HEAD

    Product getById(int id);
=======
>>>>>>> 1ca2bf2910c223089592b9fb43660604cf8a1054
}
