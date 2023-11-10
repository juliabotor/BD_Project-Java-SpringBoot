package com.example.Agencia.controller;

import com.example.Agencia.Client.Client;
import com.example.Agencia.Client.ClientRepository;
import com.example.Agencia.Client.ClientRequestDTO;
import com.example.Agencia.Client.ClientResponseDTO;
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

    @GetMapping
    public List<ClientResponseDTO> getAllClient() {
        List<ClientResponseDTO> clientList = repository.findAll().stream().map(ClientResponseDTO::new).toList();
        return clientList;
    }

    @PostMapping
    public Client createClient(@RequestBody ClientRequestDTO clientData) {
        Client client = new Client(clientData);
        repository.save(client);
        return client;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Client> updateClient(@RequestBody ClientRequestDTO clientData) {
        Optional<Client> optionalClient = repository.findById(clientData.id());
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setName(clientData.name());
            client.setEmail(clientData.email());
            client.setCpf(clientData.cpf());
            repository.save(client);
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
