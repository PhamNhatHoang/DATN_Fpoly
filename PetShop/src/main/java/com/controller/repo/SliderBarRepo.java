package com.controller.repo;

import com.controller.entity.SliderBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderBarRepo extends JpaRepository<SliderBar, Integer> {
}
