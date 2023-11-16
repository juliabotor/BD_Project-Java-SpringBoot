package com.example.Agencia.controller;

import com.example.Agencia.Booking.BookingRequestDTO;
import com.example.Agencia.Booking.BookingService;
import com.example.Agencia.PackageAccommodation.PackageAccommodationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public void createBooking(@RequestBody BookingRequestDTO request) {
        bookingService.createBooking(request.getId_package(), request.getId_employee(), request.getId_client(), request.getId_ticket());
    }

}
