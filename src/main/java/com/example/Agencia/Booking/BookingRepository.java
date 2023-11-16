package com.example.Agencia.Booking;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO booking(id_package, id_employee, id_client, id_ticket) VALUES (:id_package, :id_employee, :id_client, :id_ticket)")
    void saveBookingWithQuery(@Param("id_package") Long id_package,
                                           @Param("id_employee") Long id_employee,
                                           @Param("id_client") Long id_client,
                                           @Param("id_ticket") Long id_ticket);

}
