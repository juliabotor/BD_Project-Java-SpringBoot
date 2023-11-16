package com.example.Agencia.Booking;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookingId implements Serializable {
    private Long id_package;
    private Long id_ticket;
    private Long id_employee;
    private Long id_client;

}
