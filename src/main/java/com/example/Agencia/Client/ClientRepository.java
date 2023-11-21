package com.example.Agencia.Client;

import com.example.Agencia.Employee.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    private JdbcTemplate jdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveClient(String cpf, String email, String name, String phone_number) {
        String sql = "INSERT INTO Client(cpf, email, name, phone_number) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cpf, email, name, phone_number);
    }

    public List<ClientResponseDTO> findAllClients() {
        String sql = "SELECT id_client, cpf, email, name, phone_number FROM Client";

        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new ClientResponseDTO(
                        resultSet.getLong("id_client"),
                        resultSet.getString("cpf"),
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("phone_number")
                )
        );
    }

    public Optional<Client> findById(Long id_client) {
        String sql = "SELECT * FROM Client WHERE id_client = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_client}, (resultSet, rowNum) ->
                Optional.of(new Client(
                        resultSet.getLong("id_client"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("cpf"),
                        resultSet.getString("phone_number")
                ))
        );
    }


    public void updateClient(Long id_client, String cpf, String name, String email, String phone_number) {
        String sql = "UPDATE Client SET cpf = ?, name = ?, email = ?, phone_number = ? WHERE id_client = ?";
        jdbcTemplate.update(sql, cpf, name, email, phone_number, id_client);
    }

    public void deleteClientById(Long id_client) {
        String sql = "DELETE FROM Client WHERE id_client = ?";
        jdbcTemplate.update(sql, id_client);
    }
}
