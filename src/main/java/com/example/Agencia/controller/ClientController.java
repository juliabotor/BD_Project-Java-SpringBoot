package com.example.Agencia.controller;

import com.example.Agencia.Client.*;
import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import com.example.Agencia.Employee.EmployeeResponseDTO;
import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageRequestDTO;
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

    @CrossOrigin( origins = "*" , allowedHeaders = "*")

    @PutMapping("/update")
    @Transactional
    public ResponseEntity updateClient(@RequestBody ClientRequestDTO data){
        Optional<Client> optionalClient = clientService.findClientById(data.id_client());
        if (optionalClient.isPresent()){
            Client clients = optionalClient.get();
            clients.setCpf(data.cpf());
            clients.setName(data.name());
            clients.setEmail(data.email());
            clients.setPhone_number(data.phone_number());
            clientService.updateClient(data.id_client(),data.cpf(), data.name(), data.email(), data.phone_number());
            return ResponseEntity.ok(clients);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @DeleteMapping("/delete/{id_client}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable("id_client") Long id_client){
        Optional<Client> optionalClient = clientService.findClientById(id_client);
        if(optionalClient.isPresent()){
            clientService.deleteClientById(id_client);
            return ResponseEntity.ok("client deleted succesfully!");
        }
        return ResponseEntity.notFound().build();

    }

}
