package com.example.Agencia.Employee;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class EmployeeResponseDTO {

    private Long id_employee;
    private String name;
    private String cpf;
    private Date birth_date;


    public EmployeeResponseDTO(Long id_employee, String name, String cpf, Date birth_date) {
        this.id_employee = id_employee;
        this.name = name;
        this.cpf = cpf;
        this.birth_date = birth_date;
    }
}
