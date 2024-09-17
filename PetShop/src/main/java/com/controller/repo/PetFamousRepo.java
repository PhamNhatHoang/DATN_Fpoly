package com.controller.repo;

import com.controller.entity.PetFamous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetFamousRepo extends JpaRepository<PetFamous, Integer> {
}
