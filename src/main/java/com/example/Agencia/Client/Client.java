package com.example.Agencia.Client;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "client")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private String email;
    private String phone_number;

    public Client(ClientRequestDTO data){
        this.name = data.name();
        this.email = data.email();
        this.phone_number = data.phone_number();
        this.cpf = data.cpf();
        this.id = data.id();
    }

}