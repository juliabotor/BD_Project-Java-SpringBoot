package com.example.Agencia.Employee;

import java.sql.Date;

public record EmployeeResponseDTO(Long id, String cpf, String name, Date birth_date) {
    public EmployeeResponseDTO(Employee employee){
        this(employee.getId(), employee.getCpf(), employee.getName(), employee.getBirth_date());
    }
}
