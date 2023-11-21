package com.example.Agencia.Booking;

import com.example.Agencia.PackageAccommodation.PackageAccommodationId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="booking")
@Entity(name="booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BookingId.class)
public class Booking {

    @Id
    private Long id_package;
    @Id
    private Long id_ticket;
    @Id
    private Long id_seller;
    @Id
    private Long id_client;


}