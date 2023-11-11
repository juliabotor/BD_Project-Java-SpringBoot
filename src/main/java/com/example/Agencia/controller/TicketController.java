package com.example.Agencia.controller;

import com.example.Agencia.Ticket.Ticket;
import com.example.Agencia.Ticket.TicketRepository;
import com.example.Agencia.Ticket.TicketRequestDTO;
import com.example.Agencia.Ticket.TicketResponseDTO;
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
    private TicketRepository repository;

    @GetMapping
    public List<TicketResponseDTO> getAll(){
        List<TicketResponseDTO> ticketList = repository.findAll().stream().map(TicketResponseDTO::new).toList();
        return ticketList;
    }

    @PostMapping
    public void saveTicket(@RequestBody TicketRequestDTO data){
        Ticket ticketData = new Ticket(data);
        repository.save(ticketData);
        return;
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTicket(@RequestBody TicketRequestDTO data){
        Optional<Ticket> optionalTicket = repository.findById(data.id());
        if(optionalTicket.isPresent()){
            Ticket ticket = optionalTicket.get();
            ticket.setDate(data.date());
            ticket.setPrice(data.price());
            return ResponseEntity.ok(ticket);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
