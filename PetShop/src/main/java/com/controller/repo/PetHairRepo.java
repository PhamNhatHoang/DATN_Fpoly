package com.controller.repo;

import com.controller.entity.PetHair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetHairRepo extends JpaRepository<PetHair, Integer> {
}
