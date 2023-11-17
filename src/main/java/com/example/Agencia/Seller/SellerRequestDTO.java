package com.example.Agencia.Seller;

import java.sql.Date;

public record SellerRequestDTO(Long id, String name, String cpf, Date birth_date,Integer workload, Long id_supervisor) {
}