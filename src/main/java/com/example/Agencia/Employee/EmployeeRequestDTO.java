package com.example.Agencia.Employee;

import java.sql.Date;


public record EmployeeRequestDTO(Long id, String name, String cpf, Date birth_date) {
}
