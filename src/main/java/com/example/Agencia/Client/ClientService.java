package com.example.Agencia.Client;

import com.example.Agencia.Package.Package;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(String cpf, String email, String name, String phone_number) {
        clientRepository.saveClient(cpf, email, name, phone_number);
    }

    public List<ClientResponseDTO>  getAllClients(){
        return clientRepository.findAllClients();
    }

    @Transactional
    public void updateClient(Long id_client, String cpf, String name, String email, String phone_number){
        clientRepository.updateClient(id_client, cpf, name, email, phone_number);
    }

    public Optional<Client> findClientById(Long id_client) {
        return clientRepository.findById(id_client);
    }

    @Transactional
    public void deleteClientById(Long id_client) {
        clientRepository.deleteClientById(id_client);
    }

}
