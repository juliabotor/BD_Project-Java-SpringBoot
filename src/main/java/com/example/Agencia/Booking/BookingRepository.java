package com.example.Agencia.Booking;

import com.example.Agencia.PackageAccommodation.PackageAccommodationResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO booking(id_package, id_employee, id_client, id_ticket) VALUES (:id_package, :id_employee, :id_client, :id_ticket)")
    void saveBookingWithQuery(@Param("id_package") Long id_package,
                                           @Param("id_employee") Long id_employee,
                                           @Param("id_client") Long id_client,
                                           @Param("id_ticket") Long id_ticket);

    @Query("SELECT NEW com.example.Agencia.Booking.BookingResponseDTO(b.id_package, p.title, e.name, b.id_employee, b.id_client, c.name,b.id_ticket) " +
            "FROM com.example.Agencia.Booking.Booking b " +
            "JOIN com.example.Agencia.Employee.Employee e ON b.id_employee = e.id_employee " +
            "JOIN com.example.Agencia.Package.Package p ON b.id_package = p.id_package " +
            "JOIN com.example.Agencia.Client.Client c ON b.id_client = c.id_client")
    List<BookingResponseDTO> findBookings();

}
