package com.example.Agencia.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void saveTicket(Float price, Date date) {
        ticketRepository.saveTicketWithQuery(price, date);
    }

    public List<TicketResponseDTO> getAllTickets(){
        return ticketRepository.findAllTickets();
    }



}
