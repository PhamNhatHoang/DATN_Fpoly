package com.example.petshop.repo;

import com.example.petshop.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServiceRepo extends JpaRepository<Service, String> {
    Optional<Service> findByServiceName(String serviceName);
    void deleteByServiceName(String serviceName);
}
