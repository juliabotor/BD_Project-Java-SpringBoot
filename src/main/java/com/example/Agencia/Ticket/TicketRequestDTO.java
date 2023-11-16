package com.example.Agencia.Ticket;

import java.sql.Date;

public record TicketRequestDTO(Long id_ticket, Float price, Date date) {
}
