package com.example.Agencia.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PackageRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PackageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Package> findById(Long id_package) {
        String sql = "SELECT * FROM Package WHERE id_package = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_package}, (resultSet, rowNum) ->
                Optional.of(new Package(
                        resultSet.getLong("id_package"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getString("image"),
                        resultSet.getLong("id_guide")
                ))
        );
    }

    public void savePackage(String title, String description, Float price, String image, Long id_guide) {
        String sql = "INSERT INTO Package (title, description, price, image, id_guide) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, title, description, price, image, id_guide);
    }

    public List<PackageResponseDTO> findAllPackages() {
        String sql = "SELECT id_package, title, description, price, image FROM Package";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new PackageResponseDTO(
                        resultSet.getLong("id_package"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getString("image")
                )
        );
    }

    public void updatePackage(Long id_package, String title, String description, Float price, String image) {
        String sql = "UPDATE Package SET title = ?, description = ?, price = ?, image = ? WHERE id_package = ?";
        jdbcTemplate.update(sql, title, description, price, image, id_package);
    }

    public void deletePackageById(Long id_package) {
        String sql = "DELETE FROM Package WHERE id_package = ?";
        jdbcTemplate.update(sql, id_package);
    }
}
