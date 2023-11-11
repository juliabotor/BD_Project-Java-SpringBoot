package com.example.Agencia.Seller;

import java.sql.Date;

public record SellerResponseDTO(Long id, String name, String cpf, Date birth_date, Integer workload) {
    public SellerResponseDTO(Seller seller){
        this(seller.getId(), seller.getCpf(), seller.getName(), seller.getBirth_date(), seller.getWorkload());
    }
}
