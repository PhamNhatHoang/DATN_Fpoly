package com.controller.repo;

import com.controller.entity.PetImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetImageRepo extends JpaRepository<PetImage, Integer> {
}
