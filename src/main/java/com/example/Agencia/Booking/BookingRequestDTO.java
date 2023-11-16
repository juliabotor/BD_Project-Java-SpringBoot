package com.example.Agencia.Booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDTO {

    private Long id_package;
    private Long id_ticket;
    private Long id_client;
    private Long id_employee;

}