package com.example.Agencia.Driver;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class DriverResponseDTO{
    private Long id_driver;
    private String license_category;

    public DriverResponseDTO(Long id_driver, String license_category) {
        this.id_driver = id_driver;
        this.license_category = license_category;
    }
}
