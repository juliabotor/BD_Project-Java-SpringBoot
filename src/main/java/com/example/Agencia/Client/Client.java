package com.example.Agencia.Client;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "client")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_client")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private String cpf;
    private String name;
    private String email;
    private String phone_number;

    public Client(ClientRequestDTO data){
        this.name = data.name();
        this.email = data.email();
        this.phone_number = data.phone_number();
        this.cpf = data.cpf();
        this.id_client = data.id_client();
    }

}