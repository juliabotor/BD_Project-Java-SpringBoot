package com.example.Agencia.Driver;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class DriverResponseDTO{
    private Long id;
    private String name;
    private String cpf;
    private Date birth_date;
    private String license_category;

    public DriverResponseDTO(Long id, String name, String cpf, Date birth_date, String license_category) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birth_date = birth_date;
        this.license_category = license_category;
    }
}
