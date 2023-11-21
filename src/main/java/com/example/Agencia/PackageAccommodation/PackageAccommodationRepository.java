package com.example.Agencia.PackageAccommodation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PackageAccommodationRepository {

    private JdbcTemplate jdbcTemplate;

    public PackageAccommodationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void savePackageAccommodation(Long idPackage, Long idAccommodation) {
        String sql = "INSERT INTO package_accommodation(id_package, id_accommodation) VALUES (?, ?)";
        jdbcTemplate.update(sql, idPackage, idAccommodation);
    }

    public List<PackageAccommodationResponseDTO> findPackagesAccommodationsNames() {
        String sql = "SELECT p.id_package, p.title, p.description, p.price, p.image, a.id_accommodation, a.name " +
                "FROM package p " +
                "JOIN package_accommodation pa ON p.id_package = pa.id_package " +
                "JOIN accommodation a ON pa.id_accommodation = a.id_accommodation";

        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new PackageAccommodationResponseDTO(
                        resultSet.getLong("id_package"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getString("image"),
                        resultSet.getLong("id_accommodation"),
                        resultSet.getString("name")
                )
        );
    }
}
