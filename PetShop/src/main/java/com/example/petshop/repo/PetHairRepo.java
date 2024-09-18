package com.example.petshop.repo;

import com.example.petshop.entity.PetHair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetHairRepo extends JpaRepository<PetHair, Integer> {
}
