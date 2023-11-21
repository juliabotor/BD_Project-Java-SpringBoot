package com.example.Agencia.Guide;


import com.example.Agencia.Ticket.TicketResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class GuideRepository {

    private JdbcTemplate jdbcTemplate;

    public GuideRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveGuide(String description) {
        String sql = "INSERT INTO Guide(description) VALUES (?)";
        jdbcTemplate.update(sql, description);
    }

    public List<GuideResponseDTO> findAllGuides() {
        String sql = "SELECT id_guide, description FROM Guide";

        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new GuideResponseDTO(
                        resultSet.getLong("id_guide"),
                        resultSet.getString("description")
                )
        );
    }

}
