package com.example.Agencia.Ticket;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity(name = "ticket")
@Table(name = "ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Ticket(TicketRequestDTO data){
        this.id = data.id();
        this.date = data.date();
        this.price = data.price();
    }

}
