package com.example.petshop.service;

import com.example.petshop.entity.PetCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetCategoryService {
    List<PetCategory> getAll();

    void save(PetCategory petCategory);

    void deleteId(int id);

    void findById(int id);
}
