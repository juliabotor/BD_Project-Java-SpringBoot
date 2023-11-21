package com.example.Agencia.Ticket;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class TicketRepository {

    private JdbcTemplate jdbcTemplate;

    public TicketRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveTicket(Float price, Date date) {
        String sql = "INSERT INTO Ticket(price, date) VALUES (?, ?)";
        jdbcTemplate.update(sql, price, date);
    }

    public List<TicketResponseDTO> findAllTickets() {
        String sql = "SELECT id_ticket, price, date FROM Ticket";

        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new TicketResponseDTO(
                        resultSet.getLong("id_ticket"),
                        resultSet.getFloat("price"),
                        resultSet.getDate("date")
                )
        );
    }
}
