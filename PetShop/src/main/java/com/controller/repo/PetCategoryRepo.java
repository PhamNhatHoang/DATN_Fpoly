package com.controller.repo;

import com.controller.entity.PetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCategoryRepo extends JpaRepository<PetCategory, Integer> {
}
