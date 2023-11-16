package com.example.Agencia.Ticket;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class TicketResponseDTO{

    private Long id_ticket;
    private Float price;
    private Date date;


    public TicketResponseDTO(Long id_ticket, Float price, Date date){
        this.id_ticket = id_ticket;
        this.price = price;
        this.date = date;
    }
}
