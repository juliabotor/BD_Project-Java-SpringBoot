package com.example.Agencia.controller;

import com.example.Agencia.Client.*;
import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import com.example.Agencia.Employee.EmployeeResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientService clientService;


    @CrossOrigin( origins = "*" , allowedHeaders = "*")


    @PostMapping
    public void saveClient(@RequestBody ClientRequestDTO clientData) {
        Client data = new Client(clientData);
        clientService.saveClient(data.getCpf(), data.getEmail(), data.getName(), data.getPhone_number());
    }

    @CrossOrigin( origins = "*" , allowedHeaders = "*")

    @GetMapping
    public List<ClientResponseDTO> getAllClients() {
        return clientService.getAllClients();
    }



}
