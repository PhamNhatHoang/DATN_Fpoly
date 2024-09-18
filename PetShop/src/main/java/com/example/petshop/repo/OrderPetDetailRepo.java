package com.example.petshop.repo;

import com.example.petshop.entity.OrderPetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPetDetailRepo extends JpaRepository<OrderPetDetail, Integer> {
}
