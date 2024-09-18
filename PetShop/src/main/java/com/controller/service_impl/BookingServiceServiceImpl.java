package com.controller.service_impl;

import com.controller.repo.BookingServiceRepo;
import com.controller.service.BookingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceServiceImpl implements BookingServiceService {
    @Autowired
    private BookingServiceRepo bookingServiceRepo;
}
