package com.controller.repo;

import com.controller.entity.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingServiceRepo extends JpaRepository<BookingService, Integer> {
}
