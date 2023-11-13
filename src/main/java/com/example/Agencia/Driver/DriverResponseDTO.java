package com.example.Agencia.Driver;

import java.sql.Date;

public record DriverResponseDTO(Long id, String license_category, Date birth_date, String name, String cpf) {
    public DriverResponseDTO(Driver driver){
        this(driver.getId(), driver.license_category, driver.getBirth_date(), driver.getName(), driver.getCpf());
    }
}
