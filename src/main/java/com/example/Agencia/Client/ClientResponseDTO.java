package com.example.Agencia.Client;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ClientResponseDTO{
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone_number;


    public ClientResponseDTO(Long id, String cpf, String email, String name, String phone_number) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.phone_number = phone_number;
    }
}
