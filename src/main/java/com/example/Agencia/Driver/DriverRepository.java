package com.example.Agencia.Driver;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class DriverRepository {

    private JdbcTemplate jdbcTemplate;

    public DriverRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Driver> findById(Long id_driver) {
        String sql = "SELECT * FROM Driver WHERE id_driver = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_driver}, (resultSet, rowNum) ->
                Optional.of(new Driver(
                        resultSet.getLong("id_driver"),
                        resultSet.getString("license_category")
                ))
        );
    }

    public void saveDriver(Long id_driver, String license_category) {
        String sql = "INSERT INTO Driver(id_driver, license_category) VALUES (?, ?)";
        jdbcTemplate.update(sql, id_driver,license_category);
    }

    public List<DriverResponseDTO> findAllDriver() {
        String sql = "SELECT id_driver, license_category FROM Driver";

        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new DriverResponseDTO(
                        resultSet.getLong("id_driver"),
                        resultSet.getString("license_category")
                )
        );
    }

}
