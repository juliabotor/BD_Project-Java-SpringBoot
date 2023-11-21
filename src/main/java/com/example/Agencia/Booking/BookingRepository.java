package com.example.Agencia.Booking;

import com.example.Agencia.PackageAccommodation.PackageAccommodationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void saveBooking(Long id_package, Long id_seller, Long id_client, Long id_ticket) {
        String sql = "INSERT INTO booking(id_package, id_seller, id_client, id_ticket) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, id_package, id_seller, id_client, id_ticket);
    }

    public List<BookingResponseDTO> findBookings() {
        String sql = "select b.id_package, b.id_seller, b.id_client, b.id_ticket " +
                "FROM booking b " +
                "JOIN seller s ON b.id_seller = s.id_seller " +
                "JOIN package p ON b.id_package = p.id_package " +
                "JOIN client c ON b.id_client = c.id_client";

        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new BookingResponseDTO(
                        resultSet.getLong("id_package"),
                        resultSet.getLong("id_client"),
                        resultSet.getLong("id_seller"),
                        resultSet.getLong("id_ticket")
                ));
    }
}
