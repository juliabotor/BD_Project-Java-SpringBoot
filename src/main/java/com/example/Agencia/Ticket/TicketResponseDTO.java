package com.example.Agencia.Ticket;

import java.sql.Date;

public record TicketResponseDTO(Long id, Float price, Date date) {
    public TicketResponseDTO(Ticket ticket){
        this(ticket.getId(), ticket.getPrice(), ticket.getDate());
    }
}
