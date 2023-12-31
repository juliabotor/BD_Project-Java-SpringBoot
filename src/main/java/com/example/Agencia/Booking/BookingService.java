package com.example.Agencia.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingResponseDTO> getBookings(){
        return bookingRepository.findBookings();
    }

    public void createBooking(Long id_package, Long id_seller, Long id_client, Long id_ticket){
        bookingRepository.saveBooking(id_package, id_seller, id_client, id_ticket);
    }

}
