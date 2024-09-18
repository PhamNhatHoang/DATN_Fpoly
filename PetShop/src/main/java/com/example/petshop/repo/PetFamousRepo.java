package com.example.petshop.repo;

import com.example.petshop.entity.PetFamous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetFamousRepo extends JpaRepository<PetFamous, Integer> {
}
