package com.example.Agencia.Booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {

    private Long id_package;
    private String name;
    private String name_client;
    private String title;
    private Long id_employee;
    private Long id_ticket;
    private Long id_client;

    public BookingResponseDTO(Long id_package, String title, String name, Long id_employee, Long id_client, String name_client,Long id_ticket){
        this.id_package = id_package;
        this.title = title;
        this.name = name;
        this.id_employee = id_employee;
        this.id_client = id_client;
        this.name_client = name_client;
        this.id_ticket = id_ticket;

    }

}