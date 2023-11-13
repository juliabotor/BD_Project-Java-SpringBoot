package com.example.Agencia.Driver;

import java.sql.Date;

public record DriverRequestDTO(Long id, String license_category, String name, String cpf, Date birth_date) {
}
