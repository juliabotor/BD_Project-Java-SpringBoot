package com.example.Agencia.Ticket;

import com.example.Agencia.Package.PackageResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO Ticket(price, date) VALUES (:price, :date)")
    void saveTicketWithQuery(@Param("price") Float price,
                              @Param("date") Date date);

    @Query("SELECT new com.example.Agencia.Ticket.TicketResponseDTO(t.id_ticket, t.price, t.date) FROM Ticket t")
    List<TicketResponseDTO> findAllTickets();

}
