package com.example.Agencia.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(String cpf, String email, String name, String phone_number) {
        clientRepository.saveClientWithQuery(cpf, email, name, phone_number);
    }

    public List<ClientResponseDTO>  getAllClients(){
        return clientRepository.findAllClients();
    }

}
