package com.example.Agencia.Booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {

    private Long id_package;
    private Long id_seller;
    private Long id_ticket;
    private Long id_client;

    public BookingResponseDTO(Long id_package, Long id_seller, Long id_client, Long id_ticket){
        this.id_package = id_package;
        this.id_seller = id_seller;
        this.id_client = id_client;
        this.id_ticket = id_ticket;

    }

}