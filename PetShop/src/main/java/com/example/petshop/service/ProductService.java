package com.example.petshop.service;

import com.example.petshop.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
<<<<<<< HEAD
    Optional<Product> findById(Integer id);
    void save(Product product);
    void deleteById(Integer id);
=======

    Product getById(int id);
>>>>>>> origin/NhatHoang
}
