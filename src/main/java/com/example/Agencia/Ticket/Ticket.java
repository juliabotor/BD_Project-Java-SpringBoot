package com.example.Agencia.Ticket;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_ticket")
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ticket;
    private Float price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Ticket(TicketRequestDTO data){
        this.id_ticket = data.id_ticket();
        this.date = data.date();
        this.price = data.price();
    }

}
