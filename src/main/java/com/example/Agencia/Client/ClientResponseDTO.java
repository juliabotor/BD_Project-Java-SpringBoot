package com.example.Agencia.Client;

public record ClientResponseDTO(Long id, String cpf, String name, String phoneNumber) {
    public ClientResponseDTO(Client client){
        this(client.getId(), client.getName(), client.getPhoneNumber(), client.getCpf());
    }
}
