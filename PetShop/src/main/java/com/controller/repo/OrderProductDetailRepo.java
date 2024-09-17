package com.controller.repo;

import com.controller.entity.OrderProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductDetailRepo extends JpaRepository<OrderProductDetail, Integer> {
}
