package com.example.Agencia.Seller;

import com.example.Agencia.Client.Client;
import com.example.Agencia.Client.ClientResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepository {

    private JdbcTemplate jdbcTemplate;

    public SellerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Seller> findById(Long id_seller) {
        String sql = "SELECT * FROM Seller WHERE id_seller = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_seller}, (resultSet, rowNum) ->
                Optional.of(new Seller(
                        resultSet.getLong("id_seller"),
                        resultSet.getInt("workload")
                ))
        );
    }

    public void saveSeller(Long id_seller, Integer workload) {
        String sql = "INSERT INTO Seller(id_seller, workload) VALUES (?, ?)";
        jdbcTemplate.update(sql, id_seller,workload);
    }

    public List<SellerResponseDTO> findAllSellers() {
        String sql = "SELECT id_seller, workload FROM Seller";

        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new SellerResponseDTO(
                        resultSet.getLong("id_seller"),
                        resultSet.getInt("workload")
                )
        );
    }

}
