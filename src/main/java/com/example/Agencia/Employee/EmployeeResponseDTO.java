package com.example.Agencia.Employee;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String cpf;
    private Date birth_date;

    public EmployeeResponseDTO(Long id, String name, String cpf, Date birth_date) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birth_date = birth_date;
    }
}
