package com.example.Agencia.Accommodation;

import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccommodationRepository  {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AccommodationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Accommodation> findById(Long id_accommodation) {
        String sql = "SELECT * FROM Accommodation WHERE id_accommodation = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_accommodation}, (resultSet, rowNum) ->
                Optional.of(new Accommodation(
                        resultSet.getLong("id_accommodation"),
                        resultSet.getString("name"),
                        resultSet.getString("street"),
                        resultSet.getString("district"),
                        resultSet.getInt("number"),
                        resultSet.getString("image")
                ))
        );
    }

    public void saveAccommodation(String name, String district, String street, String image, Integer number) {
        String sql = "INSERT INTO Accommodation (name, district, street, image, number) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, district, street, image, number);
    }

    public List<AccommodationResponseDTO> findAllAccommodations() {
        String sql = "SELECT id_accommodation, name, district, street, image, number FROM Accommodation";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new AccommodationResponseDTO(
                        resultSet.getLong("id_accommodation"),
                        resultSet.getString("name"),
                        resultSet.getString("district"),
                        resultSet.getString("street"),
                        resultSet.getInt("number"),
                        resultSet.getString("image")
                )
        );
    }



}
