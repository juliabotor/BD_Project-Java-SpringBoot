package com.example.Agencia.Employee;

import java.sql.Date;


public record EmployeeRequestDTO(Long id_employee, String name, String cpf, Date birth_date, Long id_supervisor) {
}
