package com.example.Agencia.Seller;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SellerResponseDTO{
    private Long id;
    private String name;
    private String cpf;
    private Date birth_date;

    private Integer workload;

    public SellerResponseDTO(Long id, String name, String cpf, Date birth_date, Integer workload) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birth_date = birth_date;
        this.workload = workload;
    }
}
