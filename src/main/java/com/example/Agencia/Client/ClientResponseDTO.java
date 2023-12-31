package com.example.Agencia.Client;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ClientResponseDTO{
    private Long id_client;
    private String name;
    private String cpf;
    private String email;
    private String phone_number;


    public ClientResponseDTO(Long id_client, String cpf, String email, String name, String phone_number) {
        this.id_client = id_client;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.phone_number = phone_number;
    }
}
