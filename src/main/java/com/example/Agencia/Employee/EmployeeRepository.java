package com.example.Agencia.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Employee> findById(Long id_employee) {
        String sql = "SELECT * FROM Employee WHERE id_employee = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_employee}, (resultSet, rowNum) ->
                Optional.of(new Employee(
                        resultSet.getLong("id_employee"),
                        resultSet.getString("name"),
                        resultSet.getDate("birth_date"),
                        resultSet.getString("cpf"),
                        resultSet.getLong("id_supervisor")
                ))
        );
    }

    public void saveEmployee(String name, String cpf, Date birth_date, Long id_supervisor) {
        String sql = "INSERT INTO Employee (name, cpf, birth_date, id_supervisor) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, cpf, birth_date, id_supervisor);
    }

    public List<EmployeeResponseDTO> findAllEmployees() {
        String sql = "SELECT id_employee, name, cpf, birth_date, id_supervisor FROM Employee";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new EmployeeResponseDTO(
                        resultSet.getLong("id_employee"),
                        resultSet.getString("name"),
                        resultSet.getString("cpf"),
                        resultSet.getDate("birth_date"),
                        resultSet.getLong("id_supervisor")
                )
        );
    }

    public void updateEmployee(Long id_employee, String name, String cpf, Date birth_date) {
        String sql = "UPDATE Employee SET name = ?, cpf = ?, birth_date = ? WHERE id_employee = ?";
        jdbcTemplate.update(sql, name, cpf, birth_date, id_employee);
    }

    public void deleteEmployeeById(Long id_employee) {
        String sql = "DELETE FROM Employee WHERE id_employee = ?";
        jdbcTemplate.update(sql, id_employee);
    }
}
