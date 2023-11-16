package com.example.Agencia.controller;

import com.example.Agencia.Booking.BookingRequestDTO;
import com.example.Agencia.Booking.BookingResponseDTO;
import com.example.Agencia.Booking.BookingService;
import com.example.Agencia.PackageAccommodation.PackageAccommodationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping
    public List<BookingResponseDTO> getBookings(){
        return bookingService.getBookings();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void createBooking(@RequestBody BookingRequestDTO request) {
        bookingService.createBooking(request.getId_package(), request.getId_employee(), request.getId_client(), request.getId_ticket());
    }

}
