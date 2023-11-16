package com.example.Agencia.Booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {

    private Long id_package;
    private Long id_client;
    private String title;
    private String name;
    private Long id_ticket;
    private Long id_employee;

    public BookingResponseDTO(Long id_package, String title, String name, Long id_ticket, Long id_client, Long id_employee){
        this.id_package = id_package;
        this.id_ticket = id_ticket;
        this.title = title;
        this.name = name;
        this.id_client = id_client;
        this.id_employee= id_employee;
    }

}