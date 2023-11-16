package com.example.Agencia.controller;

import com.example.Agencia.Ticket.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void saveTicket(@RequestBody TicketRequestDTO data){
        Ticket ticketData = new Ticket(data);
        ticketService.saveTicket(ticketData.getPrice(), ticketData.getDate());

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping
    public List<TicketResponseDTO> getAllTickets(){
        return ticketService.getAllTickets();
    }
}
